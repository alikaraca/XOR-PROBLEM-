import platform
import tkinter
from tkinter import messagebox
import subprocess
def terminal():
    os.system("gnome-terminal -e 'bash -c \"cd; exec bash\"' ")
def sysbilgi():
    plat1=platform.processor()
    plat=platform.system()
    messagebox.showinfo(title="Sistem Bilgisi",message=(plat,plat1))
def progbilgi():
    messagebox.showinfo(title="Program Bilgisi",message="Linux Commander 2016")
def yrdm():
    messagebox.showinfo(title="Yardım",message="Sorunlarınız için lütfen program dağıtıcınızla iletişime geçiniz.")
