import tkinter
from tkinter import *
import os
from Menü import ProgMenu

class arayüz(tkinter.Tk):
    def __init__(self):
        super().__init__()
        menuBar=ProgMenu(self)
        self.config(menu=menuBar)
        self.listBir = tkinter.Listbox(width=50, height=10)
        self.listİki = tkinter.Listbox(width=50, height=10)
        butonBir=tkinter.Button(text="F3 İncele")
        butonBir.place(relx=0.0,rely=0.8)
        butonİki=tkinter.Button(text="F4 Düzenle")
        butonİki.place(relx=0.13,rely=0.8)
        butonÜç=tkinter.Button(text="F5 Kopyala")
        butonÜç.place(relx=0.28,rely=0.8)
        butonDört=tkinter.Button(text="F6 Taşı",width=7)
        butonDört.place(relx=0.43,rely=0.8)
        butonBeş=tkinter.Button(text="F7 Yeni Klasör",width=12)
        butonBeş.place(relx=0.55,rely=0.8)
        butonAltı=tkinter.Button(text="F8 Sil",width=6)
        butonAltı.place(relx=0.74,rely=0.8)
        butonYedi=tkinter.Button(text="Alt+F4",command=self.destroy)
        butonYedi.place(relx=0.85,rely=0.8)
        label1=tkinter.Label(text="Copyright 2016 LinuxCommander™")
        label1.pack(side=BOTTOM)
        self.dizinList("/home/alikaraca/Masaüstü")
    def onSelect(self, evt):
        self.w = evt.widget
        self.index = int(self.w.curselection()[0])
        self.value = self.w.get(self.index)
        print("%s" %(self.value))
        return self.value
    def dizinList(self,yol):
        self.yazıBir = tkinter.Label(text="Dosyalar : ")
        self.yazıBir.pack()
        for i in os.listdir(yol):
            dosya = os.path.join(yol, i)
            if os.path.isfile(dosya):
                self.listBir.insert(1, dosya)
                self.listBir.pack()
        self.yazıİki = tkinter.Label(text="Klasörler : ")
        self.yazıİki.pack()
        for i in os.listdir(yol):
            dosya2 = os.path.join(yol, i)
            if os.path.isdir(dosya2):
                self.listİki.insert(1, dosya2)
                self.listİki.pack()
        self.listİki.bind("<<ListboxSelect>>", self.onSelect)
        self.listBir.bind("<<ListboxSelect>>", self.onSelect)
pencere=arayüz()
pencere.geometry("600x600")
pencere.mainloop()
