package afn;

public class Transicion{
  private Estado estadoSig;
  private Character simbolo;

  public Transicion(){
    this.estadoSig=null;
    this.simbolo=null;
  }

  public Transicion(Estado estadoSig){
    this.estadoSig=estadoSig;
    this.simbolo=null;
  }

  public Transicion(Character simbolo){
    this.estadoSig=null;
    this.simbolo=simbolo;
  }

  public Transicion(Estado estadoSig,Character simbolo){
    this.estadoSig=estadoSig;
    this.simbolo=simbolo;
  }

	public Estado getEstadoSig() {
		return estadoSig;
	}

	public void setEstadoSig(Estado estadoSig) {
		this.estadoSig = estadoSig;
	}

	public Character getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(Character simbolo) {
		this.simbolo = simbolo;
	}

  public void printTransicion(){
    System.out.printf("(%s -> %d)",simbolo.toString(),estadoSig.getId());
  }
}
