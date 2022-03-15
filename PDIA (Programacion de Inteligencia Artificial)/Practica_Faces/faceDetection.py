### --- --- --- --- --- --- --- --- --- --- IMPORTACIONES  --- --- --- --- --- --- --- --- --- --- ###



# <snippet_imports>

import asyncio
import io
import glob
import os
import sys
import time
import uuid
from msrest.pipeline import ClientRawResponse
import requests
from urllib.parse import urlparse
from io import BytesIO

# To install this module, run:
# python -m pip install Pillow

from PIL import Image, ImageDraw, ImageFont
from azure.cognitiveservices.vision.face import FaceClient
from msrest.authentication import CognitiveServicesCredentials
from azure.cognitiveservices.vision.face.models import TrainingStatusType, Person
import matplotlib.pyplot as plt
import matplotlib.patches as patches
from PIL import Image

# </snippet_imports>



### --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ###





### --- --- --- --- --- --- --- --- --- --- CREAMOS UNA VARIABLE DETECCION  --- --- --- --- --- --- --- --- --- --- ###
#
#
# · En la funcion le introducimos la foto que nos indica el usuario que quiere utilizar y el face_client
# · Almacenamos en la variable detected_faces el image_stream (que es para abrir la foto en local), el modelo de deteccion modelo 01 (porque es el default) y los atributos de cara que es una funcion de azure, donde queremos que nos indique la edad, el genero y las emociones


def deteccion(foto, face_client):
    
    # Accedemos a una foto en local
    test_image_array = glob.glob(foto)
    image_stream = open(test_image_array[0], 'r+b')
    
    detected_faces = face_client.face.detect_with_stream(image_stream, detection_model='detection_01',return_face_attributes=['age', 'gender','emotion'])
    
    if not detected_faces:

        raise Exception('No se han detectado caras en la imagen: {}'.format(single_image_name))

    return detected_faces

    

### --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ###





### --- --- --- --- --- --- --- --- --- --- CREAMOS UNA FUNCION PARA DETECTAR LAS EMOCIONES  --- --- --- --- --- --- --- --- --- --- ###
#
#
# · Tambien las asignamos a un diccionario y les cambiamos el nombre
# · A parte nos quedamos con el nombre de la emocion y la certeza de que sea esa emoxion



def getEmotion(emoObject):
    
    emoDict = dict()
    emoDict['enfadado'] = emoObject.anger
    emoDict['desprecio'] = emoObject.contempt
    emoDict['asco'] = emoObject.disgust
    emoDict['miedo'] = emoObject.fear
    emoDict['felicidad'] = emoObject.happiness
    emoDict['neutral'] = emoObject.neutral
    emoDict['tristeza'] = emoObject.sadness
    emoDict['sorpresa'] = emoObject.surprise
    
    emoName = max(emoDict, key=emoDict.get)
    emoLevel = emoDict[emoName]
    
    return emoName, emoLevel



### --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #





### --- --- --- --- --- --- --- --- --- --- HACEMOS VARIAS FUNCIONES PARA DIBUJAR UN RECTANGULO EN LA CARA  --- --- --- --- --- --- --- --- --- --- ###
#
#
# · Las variables getRectangle y drawFaceRectangles son para pintar el rectangulo en la cara del sujeto
# · Dentro de la funcion drawFaceRectangles mostramos todos los datos obtenidos por el programa mediante un bucle for



def getRectangle(faceDictionary):
    rect = faceDictionary.face_rectangle
    left = rect.left
    top = rect.top
    right = left + rect.width
    bottom = top + rect.height
    
    return ((left, top), (right, bottom))



def drawFaceRectangles(foto, colorRectangulo, nombrePersona, detected_faces) :
    
    # Abrimos la imagen en local  
    img = Image.open((foto))

    print('Dibujando un rectangulo en la cara: ')
    print ("  ")

    
    draw = ImageDraw.Draw(img)
    
    font = ImageFont.truetype(r'C:\Users\System-Pc\Desktop\arial.ttf',20)
    
    for face in detected_faces:
        
        draw.rectangle(getRectangle(face), outline=colorRectangulo, width=8)
        draw.text((face.face_rectangle.left, face.face_rectangle.top), nombrePersona, font = font, align="left")
        
        emotion, certeza = getEmotion(face.face_attributes.emotion)
      
       
        
        print (" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ")
        print ("  ")
        print (" DATOS OBTENIDOS DE LA CARA DE LA IMAGEN ", foto)
        print ("  ")
        print (" - CARAS DETECTADAS: ", len(detected_faces), ", en la foto: ", foto)
        print ("  ")
        print (" · Nombre del/la sujeto/a: ", nombrePersona)
        print (" · Nombre de la imagen: ", foto)
        print (" · Este es el id de la foto: " , face.face_id)
        print (" · Edad: ", str(detected_faces[0].face_attributes.age))
        print (" · Género: ", str(detected_faces[0].face_attributes.gender))
        print(" · Emocion: Se ha detectado: ", emotion," en un: ", certeza)  
        print ("  ")
        print (" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ")
        

    # Mostramos la imagen
    img.show()


def drawFaceRectanglesGroup(fotoGrupo, colorRectangulo, nombrePersona, detected_faces) :
    
    # Abrimos la imagen en local  
    img = Image.open((fotoGrupo))

    print('Dibujando un rectangulo en la cara: ')
    print ("  ")

    
    draw = ImageDraw.Draw(img)
    
    font = ImageFont.truetype(r'C:\Users\System-Pc\Desktop\arial.ttf',20)
    
    for face in detected_faces:
        
        draw.rectangle(getRectangle(face), outline=colorRectangulo, width=8)
        draw.text((face.face_rectangle.left, face.face_rectangle.top), nombrePersona, font = font, align="left")
        
    return fotoGrupo
        
           

    
    

### --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #

