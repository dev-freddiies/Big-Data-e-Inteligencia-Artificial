import hashlib
import json
from mimetypes import init
from sqlite3 import Timestamp
from hashlib import sha256
from datetime import datetime
import time
from flask import Flask, request
import requests


class Bloque:
    
    def __init__ (self,id, transacciones, timestamp, hash_previo, nonce = 0):
        
        self.id = id
        self.transacciones = transacciones
        self.timestamp = timestamp
        self.hash_previo = hash_previo
        self.nonce = nonce

    def calcula_hash(self): 

        #Convierte el bloque en una cadena JSON y luego retorna el hash
        #del mismo.   
        bloque_string = json.dumps(self, default=lambda o: o.__dict__, sort_keys=True)        
        return  sha256(bloque_string.encode()).hexdigest()


class Blockchain:
    dificultad = 2

    def __init__ (self):

        self.transacciones_sin_confirmar = []
        self.cadena = []

    def crea_bloque_genesis(self):

        bloque_genesis = Bloque(0,[],0, "0",0)
        bloque_genesis.hash = bloque_genesis.calcula_hash()
        self.cadena.append(bloque_genesis)

    @property
    def ultimo_bloque(self):

        return self.cadena[-1]


    def prueba_de_trabajo(self, bloque):


        bloque.nonce = 0
        hash_calculado = bloque.calcula_hash()
        while not hash_calculado.startswith('0' * Blockchain.dificultad):
           bloque.nonce += 1
           hash_calculado =bloque.calcula_hash()
        return hash_calculado
    
    def aniade_bloque(self, Bloque, proof):

        hash_previo = self.ultimo_bloque.hash
        if hash_previo != Bloque.hash_previo:
            return False

        if not self.es_valido(Bloque, proof):
            return False

        Bloque.hash = proof
        self.cadena.append(Bloque)
        return True
 
    def es_valido(self, Bloque, block_hash):

        return (block_hash.startswith('0' * self.dificultad) and
                block_hash == Bloque.calcula_hash())

    def aniade_nueva_transaccion(self, transaccion):
        self.transacciones_sin_confirmar.append(transaccion)
    
    def comprueba_validez_cadena(self,cadena):
        resultado = True
        hash_previo = "0"
        for bloque in cadena:
            hash_bloque = bloque.hash
            delattr(bloque, "hash")
            if not self.es_valido(bloque, hash_bloque) or hash_previo != bloque.hash_previo:
                resultado = False
            break
        bloque.hash, hash_previo = hash_bloque, hash_bloque
        return resultado
    
    def minar(self):
     
        if not self.transacciones_sin_confirmar:
          return False
    
        ultimo_bloque = self.ultimo_bloque
        nuevo_bloque = Bloque(id = ultimo_bloque.id +1,
                            transacciones=self.transacciones_sin_confirmar,
                            timestamp=time.time(),
                            hash_previo = ultimo_bloque.hash     
                            )
        prueba = self.prueba_de_trabajo(nuevo_bloque)
        self.aniade_bloque(nuevo_bloque, prueba)
        self.transacciones_sin_confirmar = []
        return True

'''
#PRUEBA DEL BLOCKCHAIN

#print ("\n\n-----------------------------------\n")
#bloque = Bloque(0, [], 0, 0, 0)
#bloque_hash = bloque.calcula_hash()
#cadena_bloque = Blockchain()
#cadena_bloque.crea_bloque_genesis()
#cadena_bloque.minar()
#print(bloque_hash)
#print ("\n-----------------------------------\n\n")
'''

#Inicializar la aplicación Flask
app = Flask(__name__)

# La copia del blockchain del nodo
blockchain = Blockchain()
blockchain.crea_bloque_genesis()

# Las direcciones de otros participantes de la red
peers = set()

# endpoint para enviar una nueva transaccion. Sera usado por nuestra
# aplicacion para anadir nuevos datos (posts) a la cadena de bloques
@app.route('/nueva_transaccion', methods=['POST'])
def nueva_transaccion():
    tx_data = request.get_json()
    campos_obligatorios = ["autor", "contenido"]

    for campo in campos_obligatorios:
        if not tx_data.get(campo):
            return "Datos de transaccion invalidos", 404

    tx_data["timestamp"] = time.time()
    blockchain.aniade_nueva_transaccion(tx_data)
    return "Exito", 201


@app.route('/cadena', methods=['GET'])
def obten_cadena():
    datos_cadena = []
    for bloque in blockchain.cadena:
        datos_cadena.append(bloque.__dict__)
    return json.dumps({"longitud": len(datos_cadena),"cadena": datos_cadena,"peers": list(peers)})



@app.route('/minar', methods=['GET'])
def minar_transacciones_no_confirmadas():
    resultado = blockchain.minar()
    if not resultado:
        return "No hay transacciones para minar"
    else:
        anunciar_nuevo_bloque(Bloque)#anuncia el bloque
        return "Se ha minado el Bloque #{}.".format(blockchain.ultimo_bloque.id)

@app.route('/aniade_bloque', methods=['POST'])
def verifica_y_aniade_bloque():
    datos_bloque = request.get_json()
    bloque = Bloque (datos_bloque.id, datos_bloque.transacciones, 
                    datos_bloque.timestamp, datos_bloque.hash_previo, datos_bloque.nonce)
    prueba = datos_bloque['hash']

    aniadido = Blockchain.aniade_bloque
    if not aniadido:
        return "El bloque se descarto por el nodo", 400
    return "Bloque anadido a la cadena", 201

def anunciar_nuevo_bloque(bloque):

    for peer in peers:
        url = "{}aniade_bloque".format(peer)
        cabeceras = {'Content-Type': "application/json"}
        requests.post(url, data=json.dumps(bloque.__dict__, sort_keys=True),
            headers=cabeceras)


app.run(host='127.0.0.1',port=8000,debug=True)