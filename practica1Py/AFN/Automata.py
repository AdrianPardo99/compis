import Estados
import Transiciones

class Automata(object):

    def __init__(self, simbolo=None):
        if simbolo is not None:
            self._edoInit = Estados.Estados()
            self._alfabeto = set(simbolo)
            self._edoInit.setName("0")
            ef = Estados.Estados()
            ef.setAceptacion(True)
            ef.setName("f")
            #transicion = "( "+simbolo+","+ef.getName()+" )"
            transicion= Transiciones.Transicion(ef,simbolo)
            print("Transicion generada:",transicion)
            self._edoInit.getTransiciones().append(transicion)
            self._edosAFN = list()
            self._edosAFN.append(self._edoInit)
            self._edosAFN.append(ef)
            self._edosAceptacion = list()
            self._edosAceptacion.append(ef)
        else:
            self._edoInit = None
            self._alfabeto = set()
            self._edosAceptacion = set()
            self._edosAFN = set()

    def enumAFN(self):
        c = 0
        for i in self._edosAFN:
            print("Nombre anterior: "+i.getName())
            i.setName(str(c))
            print("Nombre nuevo: "+i.getName())
            c += 1
        return self._edosAFN

    def printTupla(self):
        self._edosAFN = self.enumAFN()
        tupla = "Σ{ "
        for i in self._alfabeto:
            tupla += i+" "
        tupla += "}\nS={ "
        for i in self._edosAFN:
            tupla += i.getName()+" "
        tupla += "}\nF{ "
        for i in self._edosAceptacion:
            tupla += i.getName()+" "
        tupla += "}\nI{ "+self._edoInit.getName()+" }\nδ={\n   "
        for i in self._edosAFN:
            for j in i.getTransiciones():
                tupla += "("+i.getName()+")->"+j.stringTransicion()+"\n   "
        tupla += "}\n"
        return tupla

    def unirAFN(self, aut):
        epsilon = "ε"
        e1 = Estados.Estados()
        e2 = Estados.Estados()
        #transicion = "("+epsilon+","+self._edoInit.getName()+")"
        transicion=Transiciones.Transicion(self._edoInit,epsilon)
        e1.getTransiciones().append(transicion)
        #transicion = "("+epsilon+","+aut._edoInit.getName()+")"
        transicion=Transiciones.Transicion(aut._edoInit,epsilon)
        e1.getTransiciones().append(transicion)
        for i in self._edosAceptacion:
            #transicion = "("+epsilon+","+e2.getName()+")"
            transicion=Transiciones.Transicion(e2,epsilon)
            i.getTransiciones().append(transicion)
            i.setAceptacion(False)
        for i in aut._edosAceptacion:
            #transicion = "("+epsilon+","+e2.getName()+")"
            transicion=Transiciones.Transicion(e2,epsilon)
            i.getTransiciones().append(transicion)
            i.setAceptacion(False)
        e2.setAceptacion(True)
        self._alfabeto.update(aut._alfabeto)
        self._edosAFN.append(e1)
        self._edosAFN.append(e2)
        self._edosAFN.extend(aut._edosAFN)
        self._edosAceptacion.clear()
        self._edosAceptacion.append(e2)
        self._edoInit = e1
        self.enumAFN()
        return self
    
    def concatenarAFN(self, aut):
        for i in self._edosAceptacion:
            i.getTransiciones().extend(aut._edoInit.getTransiciones())


aut = Automata("A")
aut2 = Automata("B")
print(aut.printTupla())
print(aut2.printTupla())
aut = aut.unirAFN(aut2)
print(aut.printTupla())
