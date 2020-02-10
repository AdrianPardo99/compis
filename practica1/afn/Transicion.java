package afn;

/* Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 10-02-2020 */

public class Transicion{
  /* Clase Transicion */
  private Estado estadoSig;
  private Character simbolo;

  /* Constructor sin parametros */
  public Transicion(){
    this.estadoSig=null;
    this.simbolo=null;
  }

  /* Constructor con parametro Estado de destion */
  public Transicion(Estado estadoSig){
    this.estadoSig=estadoSig;
    this.simbolo=null;
  }

  /* Constructor con parametro de simbolo de lectura */
  public Transicion(Character simbolo){
    this.estadoSig=null;
    this.simbolo=simbolo;
  }

  /* Constructor con parametros del simbolo de lectura y el
   * Estado destino */
  public Transicion(Estado estadoSig,Character simbolo){
    this.estadoSig=estadoSig;
    this.simbolo=simbolo;
  }

  /* Constructor con parametros del simbolo de lectura y el
   * Estado destino inverso */
  public Transicion(Character simbolo,Estado estadoSig){
    this.estadoSig=estadoSig;
    this.simbolo=simbolo;
  }

  /* Getters y Setters de los elementos de la clase */
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

  /* Funcion que imprime los datos de la clase */
  public void printTransicion(){
    System.out.printf("(%s -> %d)",simbolo.toString(),estadoSig.getId());
  }
}
