package afn;
import java.util.HashSet;
import java.util.Set;

public class Estado{
  private boolean aceptacion;
  private Set<Transicion> transiciones;
  private int id;

  public Estado(){
    this.aceptacion=false;
    this.transiciones=new HashSet<Transicion>();
    this.id=-1;
  }

  public Estado(boolean aceptacion){
    this.aceptacion=aceptacion;
    this.transiciones=new HashSet<Transicion>();
    this.id=-1;
  }

  public Estado(Set<Transicion> transiciones){
    this.aceptacion=false;
    this.transiciones=transiciones;
    this.id=-1;
  }

  public Estado(boolean aceptacion,Set<Transicion> transiciones){
    this.aceptacion=aceptacion;
    this.transiciones=transiciones;
    this.id=-1;
  }

	public boolean isAceptacion() {
		return aceptacion;
	}

	public void setAceptacion(boolean aceptacion) {
		this.aceptacion = aceptacion;
	}

	public Set<Transicion> getTransiciones() {
		return transiciones;
	}

	public void setTransiciones(Set<Transicion> transiciones) {
		this.transiciones = transiciones;
	}

  public void setId(int id){
    this.id=id;
  }

  public int getId(){
    return this.id;
  }

  public void printEstado(){
    for (Transicion t : transiciones){
      System.out.printf("  (%d)=",this.getId());
      t.printTransicion();
      System.out.printf("\n");
    }
  }

}
