

from azure.cognitiveservices.language.luis.authoring import LUISAuthoringClient
from azure.cognitiveservices.language.luis.authoring.models import ApplicationCreateObject
from azure.cognitiveservices.language.luis.runtime import LUISRuntimeClient
from msrest.authentication import CognitiveServicesCredentials
from functools import reduce
import os,json, time, uuid





def intenciones(app_id, version_id, client, arrayIntenciones):
    # Añadir informacion al modelo
    
    print("· Añadimos las intenciones.")
    print("")

    #Añadimos intenciones
    intentNames = ["Proyecto_Cine"]
    for intent in arrayIntenciones:
        client.model.add_intent(app_id, version_id, intent)
    
    print("· Intención creada")
    print("")

   
 
 
 
def añadirEntidades(app_id, version_id, client, arrayEntidades, arraySubEntidades):
    print(arrayEntidades)
    print(arraySubEntidades)
    print("")

    for i in arrayEntidades:
        client.model.add_entity(app_id, version_id, name = i, children=arraySubEntidades)

    




def ejemplos(app_id, version_id, client, data):
    # · Añade el ejemplo a la entidad:
    
    print("· Añadimos los ejemplos definidos en el json")
    print("")

    client.examples.batch(app_id, version_id, data)
       
    print("· Ejemplos añadidos")
    print("")
    




def entrenamiento(app_id, version_id, client):
    # · Ahora entrenamos el modelo:
    
    client.train.train_version(app_id, version_id)
    waiting = True

    while waiting:
        info = client.train.get_status(app_id, version_id)
        
        waiting = any(map(lambda x: 'Queued' == x.details.status or 'InProgress' == x.details.status, info))

        if waiting:
            
            print (" - Esperamos 10 segundo a que finalice el entrenamiento... - ")
            print("")
            
            time.sleep(1)
            print (1)
            time.sleep(1)
            print (2)
            time.sleep(1)
            print (3)
            time.sleep(1)
            print (4)
            time.sleep(1)
            print (5)
            time.sleep(1)
            print (6)
            time.sleep(1)
            print (7)
            time.sleep(1)
            print (8)
            time.sleep(1)
            print (9)
            time.sleep(1)
            print (10)
            
            print("")
            
        else:
            print ("¡ TRAINED !")
            print("")

            waiting = False

    # · Publicamos la aplicación:
    
    client.apps.update_settings(app_id, is_public=True)
    responseEndpointInfo = client.apps.publish(app_id, version_id, is_staging=False)
    
    print ("¡ PUBLICADA !")
    print("")





def prediccion(palabraQuery, predictionKey, predictionEndpoint, app_id):
    
    # · Autenticación del cliente del entorno de ejecución de predicción:
    runtimeCredentials = CognitiveServicesCredentials(predictionKey)
    clientRuntime = LUISRuntimeClient(endpoint=predictionEndpoint, credentials=runtimeCredentials) # Utilizamos otro cliente para hacer las predicciones

    # 1.- Obtención de la predicción a partir del entorno de ejecución:
    # 2.- La expresión de usuario forma parte del objeto prediction_request:
    # · predictionRequest = { "query" : "I want to book a trip to Sevilla from Caprica on Saturday, August 13, 2016 for 8 adults. I want to spend $1700." }
    predictionRequest = { "query" : palabraQuery }


    # 1.- El método get_slot_prediction necesita varios parámetros como, el identificador de la aplicación,
    # 2.- el nombre de la ranura y el objeto de la solicitud de predicción para completar la solicitud.
    # 3.- La solicitud devuelve un objeto PredictionResponse.
    # ·· Production == slot name
    predictionResponse = clientRuntime.prediction.get_slot_prediction(app_id, "Production", predictionRequest)

    print(predictionResponse.as_dict())
    
    print("")
    print("· Esta frase pertenece a: {}".format(predictionResponse.prediction.top_intent))
    print("")
    print("· Intenciones: ")
    print("")


    for intent in predictionResponse.prediction.intents:
        print("\t{}".format (json.dumps (intent))) # ··· Serializa un objeto a JSON
            
    return predictionResponse.prediction
