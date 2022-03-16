# --- --- --- IMPORTACIONES --- --- --- #

from azure.cognitiveservices.language.luis.authoring import LUISAuthoringClient
from azure.cognitiveservices.language.luis.authoring.models import ApplicationCreateObject
from azure.cognitiveservices.language.luis.runtime import LUISRuntimeClient
from msrest.authentication import CognitiveServicesCredentials
from functools import reduce
import os,json, time, uuid
import proyectoCine

### --- --- --- --- --- --- --- --- --- --- #



# --- > Cambiar eso para que funcione --- ---

# Importamos las credenciales desde config.ini

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



### --- --- --- --- --- --- --- --- --- --- PEDIMOS LOS DATOS AL USUARIO  --- --- --- --- --- --- --- --- --- --- ###

palabraQuery = input('Introduce una palabra que va a ser la intención: ')

### --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ###


arrayIntenciones = ['Saludos', 'Confirmar', 'Agradecer']

# · Lanzamos las funciones con las variables que necesitan: 

proyectoCine.intenciones(app_id, version_id, client, arrayIntenciones)
proyectoCine.ejemplos(app_id, version_id, client)
proyectoCine.entrenamiento(app_id, version_id, client)
proyectoCine.prediccion(palabraQuery, predictionKey, predictionEndpoint, app_id)

# --- --- --- --- --- --- --- --- --- --- --- --- --- #




