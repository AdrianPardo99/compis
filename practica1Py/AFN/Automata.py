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
            transicion = Transiciones.Transicion(ef, simbolo)
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
            i.setName(str(c))
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
        transicion = Transiciones.Transicion(self._edoInit, epsilon)
        e1.getTransiciones().append(transicion)
        transicion = Transiciones.Transicion(aut._edoInit, epsilon)
        e1.getTransiciones().append(transicion)
        for i in self._edosAceptacion:
            transicion = Transiciones.Transicion(e2, epsilon)
            i.getTransiciones().append(transicion)
            i.setAceptacion(False)
        for i in aut._edosAceptacion:
            transicion = Transiciones.Transicion(e2, epsilon)
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
        del aut
        return self

    def concatenarAFN(self, aut):
        for i in self._edosAceptacion:
            i.getTransiciones().extend(aut._edoInit.getTransiciones())
            i.setAceptacion(False)
        aut._edoInit.getTransiciones().clear()
        aut._edosAFN.remove(aut._edoInit)
        self._alfabeto.update(aut._alfabeto)
        self._edosAFN.extend(aut._edosAFN)
        self._edosAceptacion.clear()
        self._edosAceptacion.extend(aut._edosAceptacion)
        del aut
        return self

    def cerraduraOp(self):
        epsilon = "ε"
        e1 = Estados.Estados()
        e2 = Estados.Estados()
        e1.getTransiciones().append(Transiciones.Transicion(self._edoInit, epsilon))
        e1.getTransiciones().append(Transiciones.Transicion(e2, epsilon))
        e2.setAceptacion(True)
        for i in self._edosAceptacion:
            i.getTransiciones().append(Transiciones.Transicion(e2, epsilon))
            i.setAceptacion(False)
        self._edosAFN.append(e1)
        self._edosAFN.append(e2)
        self._edosAceptacion.clear()
        self._edosAceptacion.append(e2)
        self._edoInit = e1
        del e1, e2
        return self

    def cerraduraPo(self):
        epsilon = "ε"
        e1 = Estados.Estados()
        e2 = Estados.Estados()
        e1.getTransiciones().append(Transiciones.Transicion(self._edoInit,epsilon))
        e2.setAceptacion(True)
        for i in self._edosAceptacion:
            i.getTransiciones().append(Transiciones.Transicion(e2, epsilon))
            i.getTransiciones().append(Transiciones.Transicion(self._edoInit, epsilon))
            i.setAceptacion(False)
        self._edosAFN.append(e1)
        self._edosAFN.append(e2)
        self._edosAceptacion.clear()
        self._edosAceptacion.append(e2)
        self._edoInit = e1
        del e1, e2
        return self

    def cerraduraKl(self):
        epsilon = "ε"
        aut=self.cerraduraPo()
        for i in self._edosAceptacion:
            aut._edoInit.getTransiciones().append(Transiciones.Transicion(i,epsilon))
        return aut



    def moverA(self,estados,simbolo):
        resultante=list()
        for _ in range(len(estados)):
            estado=estados.pop()
            resultante |= list(estado.getTransiciones())
        return resultante

    def cerraduraEpsilon(self,estados):
        epsilon = "ε"
        resultado=set()
        estadoAux=list()
        for i in self._edosAFN:
            if(i.getName()==estados.getName()):
                estadoAux=i.getTransiciones()
                break
        if(len(estadoAux)>0):
            for i in estadoAux:
                if(epsilon in i.stringTransicion()):
                    resultado.add(estados.getName())
                    strign=i.stringTransicion().replace("(","").replace(")","").replace(epsilon,"").replace("->","")
                    resultado.add(strign)
        resultado=sorted(resultado)
        return resultado


    def AFNtoAFD(self):
        s=list()
        s.append(self.cerraduraEpsilon(self._edoInit))
        print(self.printTupla())
        for i in self._edosAFN:
                for j in s:
                    for k in j:
                        if(k==i.getName()):
                            if self.cerraduraEpsilon(i) not in s and k!=self._edoInit.getName():
                                s.append(self.cerraduraEpsilon(i))
        print(str(s))
