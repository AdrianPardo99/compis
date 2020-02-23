import Estados

class Transicion:
    def __init__(self, estadoSig=None,simbolo=None):
        if estadoSig is not None and simbolo is not None:
            self._estadoSig=estadoSig
            self._simbolo=simbolo
        elif simbolo is not None and estadoSig is None:
            self._estadoSig=None
            self._simbolo=simbolo
        elif estadoSig is not None and simbolo is None:
            self._estadoSig=estadoSig
            self._simbolo=None
        else:
            self._simbolo=None
            self._estadoSig=None
    
    def getEstadoSig(self):
        return self._estadoSig
    
    def setEstadoSig(self,estadoSig):
        self._estadoSig=estadoSig
    
    def getSimbolo(self):
        return self._simbolo
    
    def setSimbolo(self,simbolo):
        self.simbolo=simbolo
    
    def printTransicion(self):
        print("(",self._simbolo,'->',self._estadoSig.getToken(),")")
    
    def stringTransicion(self):
        return '('+self._simbolo+'->'+self._estadoSig.getName()+')'
    
    def __str__(self):
        return '('+self._simbolo+'->'+self._estadoSig.getName()+')'

