import tkinter
from tkinter import *
import os
from tkinter import ttk, filedialog
from Menü import ProgMenu
class Arayüz(tkinter.Tk):
    def __init__(self):
        super().__init__()
        menuBar=ProgMenu(self)
        self.config(menu=menuBar)
        self.listBir = tkinter.Listbox(width=50, height=10)
        self.listİki = tkinter.Listbox(width=50, height=10)
        self.butonBir=Button(text=" F3 İncele        ",width=12,height=1)
        self.butonBir.place(relx=0.25,rely=0.7)
        self.butonİki = Button(text=" F4 Düzenle     ",width=12,height=1)
        self.butonİki.place(relx=0.25,rely=0.75)
        self.butonUc = Button(text=" F5 Kopyala      ",width=12,height=1)
        self.butonUc.place(relx=0.25,rely=0.80)
        self.butonDort = Button(text="F6 Taşı       ",width=12,height=1)
        self.butonDort.place(relx=0.25,rely=0.85)
        self.butonBes = Button(text="F7 Yeni Klasör ",width=12,height=1)
        self.butonBes.place(relx=0.55,rely=0.7)
        self.butonAltı = Button(text="F8 Sil        ",width=12,height=1)
        self.butonAltı.place(relx=0.55,rely=0.75)
        self.butonYedi = Button(text="Alt-F4 Çıkış  ",width=12,height=1,command=self.destroy)
        self.butonYedi.place(relx=0.55,rely=0.80)
        self.lbl = Label(text="Copyright © 2016 LinuxCommander™, All Rights Reserved.")
        self.lbl.pack(side=BOTTOM)
        self.tree = ttk.Treeview(height=15)
        self.filePath(self.fileDia())
    def onSelect(self, evt):
        self.w = evt.widget
        self.index = int(self.w.curselection()[0])
        self.value = self.w.get(self.index)
        print("%s" %(self.value))
        return self.value
    def fileDia(self):
        dia = filedialog.askdirectory(initialdir="/")
        return dia
    def treeW(self, giriş):
        self.tree.insert("", 25, text=giriş, values=("1A", "1b"))
        self.tree.pack()
    def filePath(self, yol):
        for i in os.listdir(yol):
            dosya = os.path.join(yol, i)
            self.treeW(i)
            print(i)


pencere=Arayüz()
pencere.title("Linux Commander")
pencere.geometry("600x600")
pencere.configure(background="yellow")
pencere.mainloop()
