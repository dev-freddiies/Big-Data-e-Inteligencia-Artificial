### --- --- --- --- --- --- --- --- --- IMPORTACIONES --- --- --- --- --- --- --- --- ---  ###



# <snippet_imports>
import asyncio
import io
import glob
import os
import sys
import time
import uuid
import requests
from urllib.parse import urlparse
from io import BytesIO

# To install this module, run:
# python -m pip install Pillow

from PIL import Image, ImageDraw
from azure.cognitiveservices.vision.face import FaceClient
from msrest.authentication import CognitiveServicesCredentials
from azure.cognitiveservices.vision.face.models import TrainingStatusType, Person

import faceDetection
import faceDetectionGroup


# </snippet_imports>

# Importamos las credenciales desde config.ini

import configparser
config = configparser.ConfigParser()
config.read('config.ini')
key_name =config.get('AZURE', 'KEY')
endpoint_name = config.get('AZURE','ENDPOINT')



### --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #





### --- --- --- --- --- --- --- --- --- CREACION DE face_client y person_group_id --- --- --- --- --- --- --- --- ---  ###



print(key_name)
print(endpoint_name)

# Create an authenticated FaceClient
face_client = FaceClient(endpoint_name, CognitiveServicesCredentials(key_name))



### --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #





### --- --- --- --- --- --- --- --- --- --- PEDIMOS LOS DATOS AL USUARIO  --- --- --- --- --- --- --- --- --- --- ###
#
#
# · foto: para que el usuario elija que foto quiere utilizar 
# · colorRectangulo: Para que el usuario elija que color quiere utilizar en el rectángulo
# · nombrePersona: Para que el usuario introduzca el nombre de la persona


foto = input('Introduzca el nombre de una foto: ')
colorRectangulo = input('Introduzca el color del rectangulo: ')
nombrePersona = input('Introduzca el nombre de la persona que aparece: ')
fotoGrupo = input('Introduzca el nombre de la foto del grupo: ')


### --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ###

# Crear un grupo de personas
person_group_id =str(uuid.uuid4()) # UGenera un UID aleatorio

grupo = glob.glob(fotoGrupo)

# Asignacion de caras a los objetos Person
person_images = [file for file in glob.glob('*.jpg') if file.startswith(nombrePersona)] 

faceDetection.drawFaceRectangles(foto,colorRectangulo,nombrePersona,(faceDetection.deteccion(foto, face_client)))

faceDetectionGroup.crearGrupos(face_client, person_group_id, person_images, grupo)
faceDetectionGroup.entrenar(face_client, person_group_id)
results, faces = faceDetectionGroup.identificar(grupo,face_client,person_group_id)
detected_faces = faceDetection.deteccion(foto, face_client)
faceDetectionGroup.pintaGrupo(results, faces, colorRectangulo, nombrePersona, fotoGrupo, detected_faces)




