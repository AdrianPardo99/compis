import sys
sys.path.append("AFN/")
from Automata import *


aut = Automata("A")
aut2 = Automata("B")
aut.printTupla()
aut2.printTupla()
aut = aut.concatenarAFN(aut2)
aut.printTupla()
aut3 = Automata("C")
aut = aut.concatenarAFN(aut3)
aut.printTupla()
aut = aut.cerraduraPo()
aut=aut.cerraduraOp()
aut4=Automata("D")
aut=aut.unirAFN(aut4)
aut.printTupla()
aut.AFNtoAFD()
print(aut.printTupla())
aut.graphAutomata()
