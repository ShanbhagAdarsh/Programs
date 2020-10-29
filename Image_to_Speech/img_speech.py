import pytesseract
from gtts import gTTS
import os
import cv2
from googletrans import Translator
img = cv2.imread("RESOURCES/refer.jpg")
pytesseract.pytesseract.tesseract_cmd = 'Tesseract-OCR/tesseract'
result = pytesseract.image_to_string(img)
print(result)
with open('RESOURCES/DEFAULT.txt', mode='w') as file:
    file.write(result)
    file.close
translator = Translator()
text_to_translate = translator.translate(result,src= 'en',dest= 'hi')
text = text_to_translate.text
print(text)
speak = gTTS(text=text, lang='hi', slow= False)
speak.save("speech.mp3")
os.system("speech.mp3")


