# <snippet_imports>
import asyncio
import io
import glob
import os
import sys
import time
from urllib import request
import uuid
import requests
from urllib.parse import urlparse
from io import BytesIO
# To install this module, run:
# python -m pip install Pillow
from PIL import Image, ImageDraw, ImageFont
from azure.cognitiveservices.vision.face import FaceClient
from msrest.authentication import CognitiveServicesCredentials
from azure.cognitiveservices.vision.face.models import TrainingStatusType, Person

import faceDetection
# </snippet_imports



def crearGrupos(face_client,person_group_id,person_images,grupo):
    
    # Creamos un grupo de personas vacio
    face_client.person_group.create(person_group_id=person_group_id, name=person_group_id)

    # Definir una imagen
    persona = face_client.person_group_person.create(person_group_id, "Persona")

    # Añade a la persona mujer al grupo de personas
    for image in person_images:
        m = open(image, 'r+b')
        face_client.person_group_person.add_face_from_stream(person_group_id, persona.person_id, m)
    

    

def entrenar(face_client,person_group_id):
    
    print()
    print('Entrenando al grupo de personas...')

    # Entrenamiento
    face_client.person_group.train(person_group_id)

    while (True):
        training_status = face_client.person_group.get_training_status(person_group_id)
        print()
        
        if (training_status.status is TrainingStatusType.succeeded):
            break
        
        elif (training_status.status is TrainingStatusType.failed):
            face_client.person_group.delete(person_group_id=person_group_id)
            sys.exit('El entrenamiento de la persona ha fallado')
        
   
    
def identificar(grupo,face_client,person_group_id):
    
     # Group image for testing against //Se lo paso por parametro desde el main
    image = open(grupo[0], 'r+b')
    
    print(' · Pausa de 60 segundos · ') 
    time.sleep(10)
    print(" 10 ")
    time.sleep(10)
    print(" 20 ")
    time.sleep(10)
    print(" 30 ")
    time.sleep(10)
    print(" 40 ")
    time.sleep(10)
    print(" 50 ")
    time.sleep(10)
    print(" 60 ")
    print(" ")
    print(" Ya ")
    print(" ")
    
    # Detecta caras
    face_ids = []

    # Usamos el modelo 3 para un mejor rendimiento
    faces = face_client.face.detect_with_stream(image, detection_model='detection_03')
    for face in faces:
        face_ids.append(face.face_id)
       
    # Y ahora probamos a identificar en nuestro grupo de personas, si encientra esa cara
    results = face_client.face.identify(face_ids, person_group_id)

    print('Identificacion de caras en {}'.format(os.path.basename(image.name)))

    if not results:
        print('No se identifican personas en el grupo de caras {}.'.format(os.path.basename(image.name)))
        
    for person in results:
        if len(person.candidates) > 0:
            print('Persona con ID {} es identificada {} con una fiabilidad de {}.'.format(person.face_id, os.path.basename(image.name), person.candidates[0].confidence))
        else:
            print('No se han identificado personas con el ID {} en {}.'.format(person.face_id, os.path.basename(image.name)))
    
    return results, faces

    
    
def pintaGrupo(results, faces, colorRectangulo, nombrePersona, fotoGrupo, detected_faces):

    # Abrimos la imagen en local  
    img = Image.open(fotoGrupo)
    
    contador=0
    
    for person in results:
        if len(person.candidates) > 0:
            print(" ")
            print("Persona con ID es identificada con un ID ", person.face_id, " en el grupo")
            print(" ")

            colorRectangulo = "green"
            img = faceDetection.drawFaceRectanglesGroup(fotoGrupo, colorRectangulo, nombrePersona, detected_faces)
            contador=contador+1


        else:
            print("Persona con ID es identificada con un ID ", person.face_id, " en el grupo")
            colorRectangulo = "red"
            nombrePersona = "Desconocido"
            
            img = faceDetection.drawFaceRectanglesGroup(fotoGrupo, colorRectangulo, nombrePersona, detected_faces)
            contador=contador+1
            
    img.show
            

'''    
def pintaGrupo (results, faces, colorRectangulo, nombrePersona, fotoGrupo):

    response = request.get(fotoGrupo)
    # Abrimos la imagen en local  
    img = Image.open((fotoGrupo))

    print('Dibujando un rectangulo en la cara: ')
    print ("  ")
    
    contador=0
    
    for person in results:
        face_det = faces[contador]
        if len(person.candidates) > 0:
            print("Persona con ID es identificada con un ID ", person.face_id, " en el grupo")
            print("Persona con ID es identificada con un ID ", faces[contador].face_id, " en el grupo")
            colorRectangulo = "green"

        else:
            print("Persona con ID es identificada con un ID ", person.face_id, " en el grupo")
            colorRectangulo = "red"
            nombrePersona = "Desconocido"
         
        contador=contador+1
        
    faceDetection.drawFaceRectangles(face_det, img, colorRectangulo, nombrePersona)
    
img.show
''' 
