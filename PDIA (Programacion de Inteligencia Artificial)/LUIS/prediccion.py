from azure.cognitiveservices.language.luis.authoring import LUISAuthoringClient
from azure.cognitiveservices.language.luis.authoring.models import ApplicationCreateObject
from azure.cognitiveservices.language.luis.runtime import LUISRuntimeClient
from msrest.authentication import CognitiveServicesCredentials
from functools import reduce
import os,json, time, uuid

subscription_key = '2a68f45b5fce4d33b8798bc926f5b723'
authoring_endpoint = 'https://luisgrouppdia2-authoring.cognitiveservices.azure.com/'

predictionKey = 'a574d14393854471a870dc3d4dca81c5'
predictionEndpoint = 'https://luisgrouppdia2.cognitiveservices.azure.com/'


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

# Añadir informacion al modelo
print("\nAñadimos la intencion 'book' y 5 entidades correspondientes a ciudad origen, ciudad destino, fecha_inicio, fecha_fin y presupuesto ")
client.model.add_intent(app_id, version_id, 'book')
print("Intención creada")

client.model.add_entity(app_id, version_id, name="or_city")
client.model.add_entity(app_id, version_id, name="dst_city")
client.model.add_entity(app_id, version_id, name="str_date")
client.model.add_entity(app_id, version_id, name="end_date")
client.model.add_entity(app_id, version_id, name="budget")
print("entidades creadas")

# Añade el ejemplo a la entidad.
print("\nAñadimos los ejemplos definidos en el json")
f = open('jsonFlight1.json', 'r')
data = json.load(f)
client.examples.batch(app_id, version_id, data)
print("\nEjemplos añadidos")

#Ahora entrenamos el modelo
client.train.train_version(app_id, version_id)
waiting = True

while waiting:
    info = client.train.get_status(app_id, version_id)
    
    # get_status returns a list of training statuses, one for each model. Loop through them and make sure all are done.

    waiting = any(map(lambda x: 'Queued' == x.details.status or 'InProgress' == x.details.status, info))

    if waiting:
        print ("Esperamos 10 segundo a que finalice el entrenamiento...")
        time.sleep(10)
        
    else:
        print ("trained")
        waiting = False

# Publicamos la aplicación
client.apps.update_settings(app_id, is_public=True)
responseEndpointInfo = client.apps.publish(app_id, version_id, is_staging=False)
print ("Publicada")


#Autenticación del cliente del entorno de ejecución de predicción
runtimeCredentials = CognitiveServicesCredentials(predictionKey)
clientRuntime = LUISRuntimeClient(endpoint=predictionEndpoint, credentials=runtimeCredentials) # Utilizamos otro cliente para hacer las predicciones

# Obtención de la predicción a partir del entorno de ejecución
# La expresión de usuario forma parte del objeto prediction_request.
predictionRequest = { "query" : "Hello, I am planning to book a trip from Madrid to Sevilla from Thursday, August 18 to Saturday, September 3" }

#El método get_slot_prediction necesita varios parámetros como, el identificador de la aplicación,
# el nombre de la ranura y el objeto de la solicitud de predicción para completar la solicitud.
# La solicitud devuelve un objeto PredictionResponse.
# Production == slot name
predictionResponse = clientRuntime.prediction.get_slot_prediction(app_id, "Production", predictionRequest)

print(predictionResponse.as_dict())

print("Esta frase pertenece a: {}".format(predictionResponse.prediction.top_intent))
print("Intenciones: ")

for intent in predictionResponse.prediction.intents:
    print("\t{}".format (json.dumps (intent))) #Serializa un objeto a JSON
    
print("Entidades reconocidas en la orden: {}".format (predictionResponse.prediction.entities))
