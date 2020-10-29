from tkinter import *
from tkinter import filedialog
import os
import tkinter as tk
from PIL import Image
import pytesseract
from gtts import gTTS
from playsound import playsound

pytesseract.pytesseract.tesseract_cmd = 'Tesseract-OCR/tesseract'


def convert_audio():
    text_info = text.get()
    language = 'en'
    myObj = gTTS(text=text_info, lang=language, slow=False)
    myObj.save("audio.mp3")
    playsound("audio.mp3")
    text_entry.delete(0, END)
    os.remove("audio.mp3")



def readTxt():
    fln = filedialog.askopenfilename(initialdir=os.getcwd(), title="select image file",filetypes=(("Jpg file", "*.jpg"),("PNG file",".png"),("All files","*.*")))
    t1.set(fln)
    txt1.delete("1.0","end")
    tx = txt1.insert(INSERT,pytesseract.image_to_string(Image.open(fln)))
    t2.set(tx)


root = Tk()

t1 = StringVar()
t2 = StringVar()


wrapper = LabelFrame(root,text = "choose File")
wrapper.pack(fill="both",expand="yes",padx=10,pady=10)

wrapper2 = LabelFrame(root,text = "Image Text")
wrapper2.pack(fill="both",expand="yes",padx=10,pady=10)

txt = Entry(wrapper,textvariable=t1)
txt.pack(side=tk.LEFT,padx=10)

btn = Button(wrapper,text="Browse",command=readTxt)
btn.pack(side=tk.LEFT,padx=10)

txt1 = Text(wrapper2)
txt1.pack(padx=50,pady=100)

text = StringVar()
text_entry = Entry(textvariable=text,width="50")
text_entry.place(x=15,y=100)


btn2 = Button(wrapper,text="audio",command=convert_audio)
btn2.pack(side=tk.LEFT,padx=10)


root.title("Image Browser")
root.geometry("500x500")
root.resizable(False,False)
root.mainloop()
