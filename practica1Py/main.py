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

aut=aut.cerraduraPo()

aut.printTupla()
afd=aut.AFNtoAFD()
print(aut.printTupla())
print(afd.printTupla())
aut.graphAutomata()
afd.graphAutomata()
