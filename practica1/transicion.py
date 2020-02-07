
class Transicion:
    def __init__():
        self._simbolo=NULL
        self._Estado=set()

    def __init__(self,simbolo,Estado):
        self._simbolo=simbolo
        self._Estado.add(Estado)

    def __init__(self,simbolo):
        self._simbolo=simbolo
        self._Estado=set()

    def __init__(self,Estado):
        self._Estado=Estado
        self._simbolo=NULL


