import tkinter
import tarfile
import sys
import fonk
from tkinter import *
import shutil
import zipfile
import os
from tkinter import filedialog
class ProgMenu(tkinter.Menu):
    def __init__(self, parent):
        tkinter.Menu.__init__(self, parent)
        filemenu = tkinter.Menu(self, tearoff=False)
        filemenu.add_command(label="Dosyaları sıkıştır",command=self.sıkıştır)
        filemenu.add_command(label="Dosyaları çıkart",command=self.çıkart)
        filemenu.add_command(label="Özellikler")
        filemenu.add_command(label="Yorum Düzenle")
        filemenu.add_command(label="Yazdır")
        filemenu.add_command(label="Çıkış",command=parent.destroy)
        self.add_cascade(label="Dosya",menu=filemenu)
        cmenu=tkinter.Menu(self)
        cmenu.add_command(label="Bul")
        cmenu.add_command(label="Terminale Git",command=fonk.terminal)
        cmenu.add_command(label="Sistem",command=fonk.sysbilgi)
        cmenu.add_command(label="Program",command=fonk.progbilgi)
        self.add_cascade(label="Komutlar",menu=cmenu)
        amenu=tkinter.Menu(self)
        amenu.add_command(label="Çalışma")
        amenu.add_command(label="Yardım",command=fonk.yrdm)
        self.add_cascade(label="Bilgi",menu=amenu)
    def sıkıştır(self):
        dosyayolu=filedialog.askopenfilename()
        shutil.make_archive('/home/alikaraca/Masaüstü','tar',dosyayolu)
        return self.sıkıştır()
    def çıkart(self):
        tar=filedialog.askopenfilename()
        tar = tarfile.open("pycharm.tar")
        dosya = tar.extractfile(tar)
        dosya.read()
        d = open(tar, "w")
        d.write(dosya.read())
        d.close()
