# --- --- --- IMPORTACIONES --- --- --- #

from azure.cognitiveservices.language.luis.authoring import LUISAuthoringClient
from azure.cognitiveservices.language.luis.authoring.models import ApplicationCreateObject
from azure.cognitiveservices.language.luis.runtime import LUISRuntimeClient
from msrest.authentication import CognitiveServicesCredentials
from functools import reduce
import os,json, time, uuid
import prediccion_2

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
appName = "Book Flight " + str(uuid.uuid4())
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

entidades=['']

### --- --- --- --- --- --- --- --- --- --- PEDIMOS LOS DATOS AL USUARIO  --- --- --- --- --- --- --- --- --- --- ###

# peticion = input('Introduzca una peticion para un viaje (en ingles, por favor): ')
peticion = "I want to book a trip to Sevilla from Caprica on Saturday, August 13, 2016 for 8 adults. I want to spend $1700." # --- --- ---> La inicializo a esa frase porque así no hay que escribir y es mas rápido

### --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ###


# · Lanzamos las funciones con las variables que necesitan: 

prediccion_2.intenciones(app_id, version_id, client)
prediccion_2.entidades(app_id, version_id, client)
prediccion_2.ejemplos(app_id, version_id, client)
prediccion_2.entrenamiento(app_id, version_id, client)
prediccion_2.prediccion(peticion, predictionKey, predictionEndpoint, app_id)

# --- --- --- --- --- --- --- --- --- --- --- --- --- #



