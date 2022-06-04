import socket 
import threading 
  
# --- --- --- IMPORTACIONES --- --- --- #

from azure.cognitiveservices.language.luis.authoring import LUISAuthoringClient
from azure.cognitiveservices.language.luis.authoring.models import ApplicationCreateObject
from azure.cognitiveservices.language.luis.runtime import LUISRuntimeClient
from msrest.authentication import CognitiveServicesCredentials
from functools import reduce
import os,json, time, uuid
import proyectoCine



### --- --- --- --- --- --- --- --- --- --- #
# · Importamos las credenciales desde config.ini:   

import configparser
config = configparser.ConfigParser()
config.read('config.ini')

subscription_key = config.get ('AZURE','subscription_key')
authoring_endpoint = config['AZURE']['authoring_endpoint']

predictionKey = config.get ('AZURE','predictionKey')
predictionEndpoint = config['AZURE']['predictionEndpoint']

print(subscription_key)
print(authoring_endpoint)

print(predictionKey)
print(predictionEndpoint)



# --- --- --- --- --- --- --- --- --- --- --- --- --- #
# · Creacion de parámetros:  #

# Usamos a UUID para evitar nombres duplicados
appName = "cine" + str(uuid.uuid4())
version_id = "0.1"

#Autenticación del cliente para la creación del cliente
client = LUISAuthoringClient(authoring_endpoint, CognitiveServicesCredentials(subscription_key)) #Entrenar y crear el modelo (el cliente)

'''Creación de una aplicación de LUIS'''
# define app basicas
appDefinition = ApplicationCreateObject (name=appName, initial_version_id=version_id, culture='es-es')

# crea app
app_id = client.apps.add(appDefinition)

# obtiene app id - necessaia
print("Creada app LUIS app con ID {}".format(app_id))
print("")
print("")



# --- --- --- --- --- --- --- --- --- --- --- --- --- #

PORT = 8000
SERVER = 'localhost'
ADDRESS = (SERVER, PORT) 
  
FORMAT = "utf-8"
  
conn = []
  
server = socket.socket() 
server.bind(ADDRESS) 
  
def startChat(): 
    
    print("server is working on " + SERVER) 
    server.listen() 
      
    while True: 
        conn, addr =  server.accept() 
        conn.send("NAME".encode(FORMAT)) 
        name = conn.recv(1024).decode(FORMAT) 

        conn.send(f"{name}, este es nuestro servicio de ChatBot!".encode(FORMAT)) 
        conn.send('¿ En qué podemos ayudarte ?'.encode(FORMAT))
      
        thread = threading.Thread(target = handle,  args = (conn, addr)) 
        thread.start() 
        print(f"active connections {threading.activeCount()-1}") 
  
def handle(conn, addr): 
    connected = True 
    while connected:     
        message = conn.recv(1024)  
        conn.send(message)  
        predictionRequest = { "query" : message }

    conn.close() 

  
startChat() 