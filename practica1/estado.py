import transicion

class Estado:
    def __init__():
        self._Aceptacion=FALSE
        self._Transicion=set()
    
    def __init__(self,Aceptacion):
        self._Aceptacion=Aceptacion
        self._Transicion=set()

    def __init__(self,Aceptacion,Transicion):
        self._Aceptacion=Aceptacion
        self._Transicion=Transicion

    def __init__(self,Transicion):
        self._Aceptacion=FALSE
        self._Transicion=Transicion
