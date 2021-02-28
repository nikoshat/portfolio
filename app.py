# Purpose: This is a simple Python GUI application using Tkinter (Python's default standard GUI package)
# Details for Tkinter module --> https://wiki.python.org/moin/TkInter
# Creation Date: 06.09.2020
# Author: Nikos Hatiras
# Revision: 0.2
# Comments: Tested with success on Windows 10 and Ubuntu 20.10 Groovy Gorilla OS

import tkinter as tk
from tkinter import filedialog, Text
import os

#initilaize gui
root = tk.Tk()
apps = []

if os.path.isfile('save.txt'):
    with open('save.txt', 'r') as f:
        tempApps = f.read()
        tempApps = tempApps.split(',')
        #stripping the unnecessary whitespace-comma
        apps = [x for x in tempApps if x.strip()] 
        
def addApp():
#this clears up the list of apps opened alredy
    for widget in frame.winfo_children():
        widget.destroy()
    
    filename = filedialog.askopenfilename(initialdir="/", title="Select File", filetypes=[("All Files", "*.*")])

#append to the apps and print it into the terminal console (optional)
    apps.append(filename)
    print(filename)
#display app(s) opened into the frame  
    for app in apps:
        label = tk.Label(frame, text=app, bg="#90EE90")
        label.pack()


def runApps():
    for app in apps:
        os.startfile(app)


# add and customizet cavnas dimensions to the gui
canvas = tk.Canvas(root, height=600, width=800, bg="#263D42")
canvas.pack()

#add and customize white frame inside the gui
frame = tk.Frame(root, bg="white")
frame.place(relwidth=0.8, relheight=0.8, relx=0.1, rely=0.1)

#add buttons to the main gui
openFile = tk.Button(root, text="Open File", padx=10, 
                    pady=5, fg="white", bg='#263D42', command=addApp)
openFile.pack()

runApps = tk.Button(root, text="Run Apps", padx=10, 
                    pady=5, fg="white", bg='#263D42', command=runApps)
runApps.pack()

label = tk.Label(frame, text="Apps opened recently:", fg="blue")
label.pack()

for app in apps:
    label = tk.Label(frame, text=app)
    label.pack()



#the call of the actual main loop 
# button x (close) practically terminates the loop
root.mainloop()

#file save.txt saves the apps that we have opened
with open ('save.txt', 'w') as f:
    for app in apps:
        f.write(app + ',')