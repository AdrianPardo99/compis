package afn;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

/* Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 29-02-2020 */

public class Estado{
  /* Clase Estado */
  private boolean aceptacion;
  private Set<Transicion> transiciones;
  private int id,token;

  /* Constructor sin parametros */
  public Estado(){
    this.aceptacion=false;
    this.transiciones=new HashSet<Transicion>();
    this.id=-1;
    this.token=0;
  }

  /* Constructor con parametro de aceptacion como estado final */
  public Estado(boolean aceptacion){
    this.aceptacion=aceptacion;
    this.transiciones=new HashSet<Transicion>();
    this.id=-1;
    this.token=0;
  }

  /* Constructor con parametro de conjunto de transiciones */
  public Estado(Set<Transicion> transiciones){
    this.aceptacion=false;
    this.transiciones=transiciones;
    this.id=-1;
    this.token=0;
  }

  /* Constructor con parametros de estado de aceptacion y conjunto
   * de transiciones del estado */
  public Estado(boolean aceptacion,Set<Transicion> transiciones){
    this.aceptacion=aceptacion;
    this.transiciones=transiciones;
    this.id=-1;
    this.token=0;
  }

  public Estado(int id){
    this.id=id;
    this.aceptacion=false;
    this.transiciones=new HashSet<Transicion>();
    this.token=0;
  }

  /* Getters y Setters de los elementos de la clase */
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

  public void setToken(int token){
    this.token=token;
  }

  public int getToken(){
    return this.token;
  }


  /* Funcion que imprime los datos de la clase */
  public void printEstado(){
    for (Transicion t : transiciones){
      System.out.printf("  (%d)=",this.getId());
      t.printTransicion();
      System.out.printf("\n");
    }
  }

  public Object[] getEstadoTransicion(){
    ArrayList<String> f=new ArrayList<>();
    for(Transicion t:transiciones){
      f.add(this.getId()+","+t.getStringTransicion());
    }
    return f.toArray();
  }

}
