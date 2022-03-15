from azure.cognitiveservices.language.luis.authoring import LUISAuthoringClient
from azure.cognitiveservices.language.luis.authoring.models import ApplicationCreateObject
from azure.cognitiveservices.language.luis.runtime import LUISRuntimeClient
from msrest.authentication import CognitiveServicesCredentials
from functools import reduce
import os,json, time, uuid


def intenciones(app_id, version_id, client):
    # Añadir informacion al modelo
    print("· Añadimos la intencion 'book' y 5 entidades correspondientes a ciudad origen, ciudad destino, fecha_inicio, fecha_fin y presupuesto.")
    print("")

    client.model.add_intent(app_id, version_id, 'BookFlight')
    
    # --- --- --- --- --- ---> · Con el bucle for no fuciona, hay que cambiarlo
    '''
    #Añadimos intenciones
    intentNames = ["BookFlight"]
    for intent in intentNames:
        client.model.add_intent(app_id, version_id, intent)
    '''   
    # <--- --- --- --- --- --- ·
    
    print("· Intención creada")
    print("")

    


def entidades(app_id, version_id, client):
    # Creamos entidadades para From, To, Departure_date, Return_date, budget :
    # Añadimos entidades al modelo
    
    from_id = client.model.add_entity(app_id, version_id, name="From")
    to_id = client.model.add_entity(app_id, version_id, name="To")
    departure_date_id = client.model.add_entity(app_id, version_id, name="Departure_date")
    return_date_id = client.model.add_entity(app_id, version_id, name="Return_date")
    budget_id = client.model.add_entity(app_id, version_id, name="budget")
    
    print("· Entidades creadas")
    print("")
    
    #return departure_date_id, return_date_id, budget_id

    
    

def ejemplos(app_id, version_id, client):
    # Añade el ejemplo a la entidad.
    print("· Añadimos los ejemplos definidos en el json")
    print("")

    f = open('trainset_sin_sub.json', 'r')
    data = json.load(f)
    client.examples.batch(app_id, version_id, data)
    
    print("· Ejemplos añadidos")
    print("")




def entrenamiento(app_id, version_id, client):
    #Ahora entrenamos el modelo
    client.train.train_version(app_id, version_id)
    waiting = True

    while waiting:
        info = client.train.get_status(app_id, version_id)
        
        # get_status returns a list of training statuses, one for each model. Loop through them and make sure all are done.

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

    # Publicamos la aplicación
    client.apps.update_settings(app_id, is_public=True)
    responseEndpointInfo = client.apps.publish(app_id, version_id, is_staging=False)
    print ("¡ PUBLICADA !")
    print("")




def prediccion(peticion, predictionKey, predictionEndpoint, app_id):
    #Autenticación del cliente del entorno de ejecución de predicción
    runtimeCredentials = CognitiveServicesCredentials(predictionKey)
    clientRuntime = LUISRuntimeClient(endpoint=predictionEndpoint, credentials=runtimeCredentials) # Utilizamos otro cliente para hacer las predicciones

    # Obtención de la predicción a partir del entorno de ejecución
    # La expresión de usuario forma parte del objeto prediction_request.
    # predictionRequest = { "query" : "I want to book a trip to Sevilla from Caprica on Saturday, August 13, 2016 for 8 adults. I want to spend $1700." }
    predictionRequest = { "query" : peticion }


    #El método get_slot_prediction necesita varios parámetros como, el identificador de la aplicación,
    # el nombre de la ranura y el objeto de la solicitud de predicción para completar la solicitud.
    # La solicitud devuelve un objeto PredictionResponse.
    # Production == slot name
    predictionResponse = clientRuntime.prediction.get_slot_prediction(app_id, "Production", predictionRequest)

    print(predictionResponse.as_dict())
    
    print("")
    print("· Esta frase pertenece a: {}".format(predictionResponse.prediction.top_intent))
    print("")
    print("· Intenciones: ")
    print("")


    for intent in predictionResponse.prediction.intents:
        print("\t{}".format (json.dumps (intent))) #Serializa un objeto a JSON
        
    print("- Entidades reconocidas en la orden: {}".format (predictionResponse.prediction.entities))
    print("")




'''
def preconstruidaspreconstruidas(client, app_id, version_id, departure_date_id, return_date_id, budgeet_id):
    # Crear entidades. Como vamos a usar entidades preconstruidas, la añadimos al modelo
    # Añadir entidad preconstruida :
    client.model.add_prebuilt(app_id, version_id, prebuilt_extractor_names=["money", "datetimeV2"])

    # añade característica a la entidades creadas como entidades predefinidas

    prebuiltFeaturedDefinition = {"model_name": "datetimeV2", "is_required": False}
    client.features.add_entity_feature(app_id, version_id, departure_date_id, prebuiltFeaturedDefinition)
    client.features.add_entity_feature(app_id, version_id, return_date_id, prebuiltFeaturedDefinition)

    prebuiltFeaturedDefinition = {"model_name": "money", "is_required": False}
    client.features.add_entity_feature(app_id, version_id, budget_id, prebuiltFeaturedDefinition)
'''