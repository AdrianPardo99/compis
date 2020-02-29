from Automata import *
class AFN(Automata):

	"""

		Clase definitoria de un AFN

	"""

	def __init__(self, nombre, estados =[], alfabeto = []):
		Automata.__init__(self, nombre, estados, alfabeto)


class AFD(Automata):

	"""

		Clase definitori de una AFD

	"""
	def __init__(self, nombre, estados = [], alfabeto = []):
		Automata.__init__(self, nombre, estados, alfabeto)
