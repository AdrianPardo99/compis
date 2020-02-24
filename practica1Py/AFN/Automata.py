import Estados
import Transiciones
import networkx as nx
import numpy as np
import matplotlib.pyplot as plt


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
        e1.getTransiciones().append(Transiciones.Transicion(self._edoInit, epsilon))
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
        aut = self.cerraduraPo()
        for i in self._edosAceptacion:
            aut._edoInit.getTransiciones().append(Transiciones.Transicion(i, epsilon))
        return aut

    def moverA(self, estados, simbolo):
        for i in estados.getTransiciones():
            if(i.getSimbolo() == simbolo):
                return True
        return False

    def moverGetA(self, estados, simbolo):
        for i in estados.getTransiciones():
            if(i.getSimbolo() == simbolo):
                return i.getEstadoSig()
        return

    def cerraduraEpsilon(self, estados):
        epsilon = "ε"
        resultado = set()
        estadoAux = list()
        for i in self._edosAFN:
            if(i.getName() == estados.getName()):
                estadoAux = i.getTransiciones()
                break
        if(len(estadoAux) > 0):
            for i in estadoAux:
                if(epsilon in i.stringTransicion()):
                    resultado.add(estados.getName())
                    string = i.stringTransicion().replace("(", "").replace(
                        ")", "").replace(epsilon, "").replace("->", "")
                    resultado.add(string)
                    if(i.getEstadoSig() not in resultado and estados.getName() != i.getEstadoSig()):
                        resultado2 = self.cerraduraEpsilon(i.getEstadoSig())
                        if(len(resultado2) > 0):
                            for j in resultado2:
                                resultado.add(j)

        resultado = sorted(resultado)
        return resultado

    def AFNtoAFD(self):
          s=list()
          s0=list()
          s0.append(self.cerraduraEpsilon(self._edoInit))
          s0.append("")
          s.append(s0)
          s2=list()
          afd=Automata()
          afd._alfabeto=self._alfabeto

          ss=s[0]
          k=0
          while k<len(s):
              ss=s[k]
              for i in ss[0]:
                  for sim in self._alfabeto:
                      if(self.moverA(self._edosAFN[int(i)],sim)):
                          sn=list()
                          sAux=list()
                          sAux=self.cerraduraEpsilon(self.moverGetA(self._edosAFN[int(i)],sim))
                          sAux.append(self.moverGetA(self._edosAFN[int(i)],sim).getName())
                          sAux.append(self._edosAFN[int(i)].getName())
                          sAux=list(dict.fromkeys(sAux))
                          sn.append(sAux)
                          sn.append(sim)
                          if(sn in s):
                              s2.append(sn)
                              continue
                          s.append(sn)
              k+=1
          print("Conjunto de estados Sn="+str(s))
          print("Conjuntos repetidos "+str(s2))

    def graphAutomata(self):
        options = {
            'node_color': 'white',
            'edgecolors': 'black',
            'linewidths': 2,
            'node_size': 500,
            'width': 2
        }
        g = nx.DiGraph()
        labels = dict()
        for i in self._edosAFN:
            g.add_node(i.getName())
        for i in self._edosAFN:
            for j in i.getTransiciones():
                labels.update(
                    {(i.getName(), j.getEstadoSig().getName()): j.getSimbolo()})
                g.add_edge(i.getName(), j.getEstadoSig().getName())
        pos = nx.planar_layout(g)
        nx.draw(g, pos, with_labels=True, **options)
        nx.draw_networkx_nodes(g, pos,
                               nodelist=[self._edoInit.getName()],
                               node_color='g',
                               node_size=500,
                               linewidths=2,
                               edgecolors='black')
        for i in self._edosAceptacion:
            nx.draw_networkx_nodes(g, pos,
                                   nodelist=[i.getName()],
                                   node_color='r',
                                   node_size=500,
                                   linewidths=2,
                                   edgecolors='black')
        nx.draw_networkx_edge_labels(g, pos, edge_labels=labels)
        plt.show()
