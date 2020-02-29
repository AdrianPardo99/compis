import graphviz as gv

class Estado():

	"""
		nombre: 		Nombre del estado
		transiciones:	Diccionario que define las transiciones del estado con otros estados, la llave es un síbolo del alfabeto y los elementos descritos por la llave los estados a los que transiciona
		aceptacion:		Valor Booleano lo denota como estado de aceptación
	"""

	def __init__(self, nombre, transiciones = {} , aceptacion = False, inicial = False):
		self._nombre = nombre
		self._transiciones = transiciones
		self._aceptacion = aceptacion
		self._inicial = inicial
		self._token = -1

	# Getters

	def getNombre(self):
		return self._nombre

	def getTransiciones(self):
		return self._transiciones

	def getEstadosTransicion(self, simbolo):
		return self._transiciones[simbolo] if simbolo in self._transiciones else []

	def isAceptacion(self):
		return self._aceptacion

	def isInicial(self):
		return self._inicial

	def getToken(self):
		return self._token

	# Setters

	def setNombre(self, nombre):
		self._nombre = nombre

	def setTransiciones(self, transiciones):
		self._transiciones = transiciones

	def setAceptacion(self, aceptacion = True):
		self._aceptacion = aceptacion

	def setInicial(self, inicial = True):
		self._inicial = inicial

	def agregarTransicion(self, simbolo, estados = []):
		if simbolo in self._transiciones:
			for estado in estados:
				if estado not in self._transiciones[simbolo]:
					self._transiciones[simbolo].append(estado)
		else:
			self._transiciones[simbolo] = estados

	def setToken(self, token):
		self._token = token

	# Operaciones

	def mover(self, simbolo):
		""" Operación que retorna un conjunto de estados al que transiciona un estado con el símbolo dado

			@param simbolo: string
			@returns transiciones[simbolo] : list(Estado)"""

		return self._transiciones[simbolo]
