import java.util.HashSet;

public class Estado{
  private boolean aceptacion;
  private HashSet<Transicion> transiciones;

  public Estado(){
    this.aceptacion=false;
    this.transiciones=new HashSet<>();
  }

  public Estado(boolean aceptacion){
    this.aceptacion=aceptacion;
    this.transiciones=new HashSet<>();
  }

  public Estado(HashSet<Transicion> transiciones){
    this.aceptacion=false;
    this.transiciones=transiciones;
  }

  public Estado(boolean aceptacion,HashSet<Transicion> transiciones){
    this.aceptacion=aceptacion;
    this.transiciones=transiciones;
  }

	public boolean isAceptacion() {
		return aceptacion;
	}

	public void setAceptacion(boolean aceptacion) {
		this.aceptacion = aceptacion;
	}

	public HashSet<Transicion> getTransiciones() {
		return transiciones;
	}

	public void setTransiciones(HashSet<Transicion> transiciones) {
		this.transiciones = transiciones;
	}
  
}
