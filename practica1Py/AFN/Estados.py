class Estados():


    def __init__(self):
        self._transiciones=list()
        self._token=0
        self._aceptacion=False
        self._name=""


    def getTransiciones(self):
        return self._transiciones

    def getName(self):
        return self._name

    def getAceptacion(self):
        return self._aceptacion

    def getToken(self):
        return self._token

    def setTransiciones(self,transiciones):
        self._transiciones=transiciones

    def setName(self,name):
        self._name=name

    def setAceptacion(self,aceptacion):
        self._aceptacion=aceptacion

    def setToken(self,token):
        self._token=token
