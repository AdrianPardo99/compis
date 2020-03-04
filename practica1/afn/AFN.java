package afn;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Stack;

/* Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 29-02-2020 */

public class AFN{
  /* Clase AFN (Automata Finito No Determinista) */
  protected Estado edoInit;
  protected boolean isAFD;
  protected Set<Estado> edosAceptacion,edosAFN;
  protected Set<Character> alfabeto;

  protected static Character epsilon='ε';

  /* Constructor sin parametros */
  public AFN(){
    edoInit=null;
    alfabeto=new HashSet<Character>();
    alfabeto.clear();
    edosAceptacion=new HashSet<Estado>();
    edosAceptacion.clear();
    edosAFN=new HashSet<Estado>();
    edosAFN.clear();
  }

  /* Constructor con parametro que crea automata basico */
	public AFN(Character s){
    Estado ef;
    edoInit=new Estado();
    ef=new Estado();
    edosAceptacion=new HashSet<Estado>();
    edosAceptacion.add(ef);
    edosAFN=new HashSet<Estado>();
    edosAFN.add(ef);
    edosAFN.add(edoInit);
    ef.setAceptacion(true);
    alfabeto=new HashSet<Character>();
    alfabeto.add(s);
    edoInit.getTransiciones().add(new Transicion(ef,s));
  }

  /* Funcion que enumera los estados contenidos en el conjunto de
   * Estados del AFN */
  public void enumAFN(){
    int i=0;
    for(Estado edo:edosAFN){
      edo.setId(i++);
    }
  }

  /* Funcion que imprime el lenguaje que usa el AFN */
  public void printLang(){
    System.out.printf("Σ(");
    for (Character a : alfabeto) {
      System.out.printf(" %s ",a.toString());
    }
    System.out.printf(")\n");
  }

  /* Funcion que imprime los estados del AFN */
  public void printEdosAFN(){
    System.out.printf("S={");
    for(Estado edo:edosAFN){
      System.out.printf(" %d ",edo.getId());
    }
    System.out.printf("}\n");
  }

  /* Funcion que imprime los estados finales o de aceptacion
   * del AFN */
  public void printEdosAceptacion(){
    System.out.printf("F={");
    for(Estado edo:edosAceptacion){
      System.out.printf(" %d ",edo.getId());
    }
    System.out.printf("}\n");
  }

  /* Funcion que imprime las transiciones del AFN */
  public void printTransiciones(){
    System.out.printf("δ={\n");
    for(Estado edo:edosAFN){
      edo.printEstado();
    }
    System.out.printf("}\n");
  }

  /* Funcion que imprime el estado inicial */
  public void printInit(){
    System.out.printf("I={ %d }\n",edoInit.getId());
  }

  /* Funcion que imprime los datos del AFN */
  public void printAFN(){
    enumAFN();
    printLang();
    printEdosAFN();
    printInit();
    printEdosAceptacion();
    printTransiciones();
  }

  /* Funcion que imprime los datos del AFN */
  public void printAFD(){
    printLang();
    printEdosAFN();
    printInit();
    printEdosAceptacion();
    printTransiciones();
  }

  /* Funcion con parametro que crea automata basico */
  public AFN afnBasico(Character s){
    this.isAFD=false;
    return new AFN(s);
  }

  /* Funcion que une dos AFN con la logica de la regex
   * (regular expresion) f1 | f2 */
  public AFN unirAFN(AFN f2){
    this.isAFD=false;
    Estado e1=new Estado(),e2=new Estado();
    e1.getTransiciones().add(new Transicion(this.edoInit,epsilon));
    e1.getTransiciones().add(new Transicion(f2.edoInit,epsilon));
    for (Estado e : this.edosAceptacion){
      e.getTransiciones().add(new Transicion(e2,epsilon));
      e.setAceptacion(false);
    }
    for (Estado e : f2.edosAceptacion){
      e.getTransiciones().add(new Transicion(e2,epsilon));
      e.setAceptacion(false);
    }
    e2.setAceptacion(true);
    this.alfabeto.addAll(f2.alfabeto);
    this.edosAFN.add(e1);
    this.edosAFN.add(e2);
    this.edosAFN.addAll(f2.edosAFN);
    this.edosAceptacion.clear();
    this.edosAceptacion.add(e2);
    this.edoInit=e1;
    this.enumAFN();
    f2=null;
    return this;
  }

  /* Funcion que concatena dos AFN con la logica de la regex
   * (regular expresion) f1·f2 */
  public AFN concatenarAFN(AFN f2){
    this.isAFD=false;
    for (Estado e : this.edosAceptacion){
      e.getTransiciones().addAll(f2.edoInit.getTransiciones());
      e.setAceptacion(false);
    }
    f2.edoInit.getTransiciones().clear();
    f2.edosAFN.remove(f2.edoInit);
    this.alfabeto.addAll(f2.alfabeto);
    this.edosAFN.addAll(f2.edosAFN);
    this.edosAceptacion.clear();
    this.edosAceptacion.addAll(f2.edosAceptacion);
    f2=null;
    return this;
  }

  public AFN cerraduraOpcional(){
    this.isAFD=false;
    Estado e1=new Estado(),
      e2=new Estado();
    e1.getTransiciones().add(new Transicion(this.edoInit,epsilon));
    e1.getTransiciones().add(new Transicion(e2,epsilon));
    e2.setAceptacion(true);
    for(Estado e:this.edosAceptacion){
      e.getTransiciones().add(new Transicion(epsilon,e2));
      e.setAceptacion(false);
    }
    this.edosAFN.add(e1);
    this.edosAFN.add(e2);
    this.edosAceptacion.clear();
    this.edosAceptacion.add(e2);
    this.edoInit=e1;
    return this;
  }

  /* Funcion que genera la cerradura positiva de un AFN {f}^(+) */
  public AFN plus(){
    this.isAFD=false;
    Estado e1=new Estado(),
      e2=new Estado();
    e1.getTransiciones().add(new Transicion(epsilon,this.edoInit));
    e2.setAceptacion(true);
    for(Estado e:this.edosAceptacion){
      e.getTransiciones().add(new Transicion(e2,epsilon));
      e.getTransiciones().add(new Transicion(epsilon,this.edoInit));
      e.setAceptacion(false);
    }
    this.edosAFN.add(e1);
    this.edosAFN.add(e2);
    this.edosAceptacion.clear();
    this.edosAceptacion.add(e2);
    this.edoInit=e1;
    return this;
  }

  /* Funcion que genera la cerradura de Kleene de un AFN {f}^(*) */
  public AFN kleene(){
    this.isAFD=false;
    AFN f1=this.plus();
    for(Estado e:this.edosAceptacion){
      f1.edoInit.getTransiciones().add(new Transicion(e,epsilon));
    }
    return f1;
  }

  /* Funcion que devuelve las transiciones del AF */
  public Object[] getAllTransiciones(){
    ArrayList<String> f=new ArrayList<>();
    String aux="";
    for(Estado e:this.edosAFN){
      Object[] ob=e.getEstadoTransicion();
      for(Object o:ob){
        aux=o.toString();
        f.add(aux);
      }
    }
    return f.toArray();
  }
}
