from Estados import *

class Automata(object):

    def __init__(self):
        self._edoInit=null
        self._alfabeto=set()
        self._edosAceptacion=set()
        self._edosAFN=set()

    def __init__(self,simbolo):
        self._edoInit=Estados()
        self._alfabeto=set(simbolo)
        self._edoInit.setName("0")
        ef=Estados()
        ef.setAceptacion(True)
        ef.setName("f")
        transicion="( "+simbolo+","+ef.getName()+" )"
        print("Transicion generada: "+transicion)
        self._edoInit.getTransiciones().append(transicion)
        self._edosAFN=list()
        self._edosAFN.append(self._edoInit)
        self._edosAFN.append(ef)
        self._edosAceptacion=list()
        self._edosAceptacion.append(ef)


    def enumAFN(self):
        c=0
        for i in self._edosAFN:
            print("Nombre anterior: "+i.getName())
            i.setName(str(c))
            print("Nombre nuevo: "+i.getName())
            c+=1
        return self._edosAFN
    def printTupla(self):
        c=0
        self._edosAFN=self.enumAFN()
        tupla="Σ{ "
        for i in self._alfabeto:
            tupla+=i+" "
        tupla+="}\nS={ "
        for i in self._edosAFN:
            tupla+=i.getName()+" "
        tupla+="}\nF{ "
        for i in self._edosAceptacion:
            tupla+=i.getName()+" "
        tupla+="}\nI{ "+self._edoInit.getName()+" }\nδ={\n   "
        for i in self._edosAFN:
            for j in i.getTransiciones():
                tupla+="("+i.getName()+")->"+j+"\n   "
        tupla+="}\n"
        return tupla

    def unirAFN(self, aut):
        epsilon="ε"
        e1=Estados()
        e2=Estados()
        e2.setAceptacion(True)
        transicion="("+epsilon+","+self._edoInit.getName()+")"
        e1.getTransiciones().append(transicion)
        transicion="("+epsilon+","+aut._edoInit.getName()+")"
        e1.getTransiciones().append(transicion)
        for i in self._edosAceptacion:
            i.setAceptacion(False)
            transicion="("+epsilon+","+e2.getName()+")"
            i.getTransiciones().append(transicion)
        for i in aut._edosAFN:
            i.setAceptacion(False)
            transicion="("+epsilon+","+e2.getName()+")"
            i.getTransiciones().append(transicion)
        self._alfabeto.union(aut._alfabeto)
        self._edosAFN.append(e1)
        self._edosAFN.append(e2)
        self._edosAceptacion.clear()
        self._edosAceptacion.append(e2)
        self._edoInit=e1
        self.enumAFN()
        return self



aut=Automata("A")
aut2=Automata("B")
print(aut.printTupla())
print(aut2.printTupla())
aut=aut.unirAFN(aut2)
print(aut.printTupla())
