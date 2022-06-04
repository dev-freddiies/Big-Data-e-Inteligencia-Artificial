from node_server import Blockchain
from node_server import Bloque

dificultad = 2

'''
bandera = True
input('Introduzca el numero de la dificultad: ')

while (bandera==True):
    if dificultad == "1":
        dificultad=0
        bandera == False

        break
    elif dificultad == "2":
        dificultad=00
        bandera == False
        
        break
    elif dificultad == "3":
        dificultad=000
        bandera == False
        
        break
    else:
        print("Introduce una dificultad valida (de 1 a 3)")
'''

transacciones = input('Introduzca la transacción deseada, porfavor: ')
      
Blockchain = Blockchain(dificultad)

Blockchain.crea_bloque_genesis()
Blockchain.aniade_nueva_transaccion(transacciones)
Blockchain.minar()


