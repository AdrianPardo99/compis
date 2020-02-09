package afn;

import java.util.Set;
import java.util.HashSet;

public class AFN{
  private Estado edoInit;
  private Set<Estado> edosAceptacion,edosAFN;
  private Set<Character> alfabeto;
  private static Character epsilon='ε';
  public AFN(){
    edoInit=null;
    alfabeto=new HashSet<Character>();
    alfabeto.clear();
    edosAceptacion=new HashSet<Estado>();
    edosAceptacion.clear();
    edosAFN=new HashSet<Estado>();
    edosAFN.clear();
  }

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

  public void enumAFN(){
    int i=0;
    for(Estado edo:edosAFN){
      edo.setId(i++);
    }
  }

  public void printLang(){
    System.out.printf("Σ(");
    for (Character a : alfabeto) {
      System.out.printf(" %s ",a.toString());
    }
    System.out.printf(")\n");
  }

  public void printEdosAFN(){
    System.out.printf("S={");
    for(Estado edo:edosAFN){
      System.out.printf(" %d ",edo.getId());
    }
    System.out.printf("}\n");
  }

  public void printEdosAceptacion(){
    System.out.printf("F={");
    for(Estado edo:edosAceptacion){
      System.out.printf(" %d ",edo.getId());
    }
    System.out.printf("}\n");
  }

  public void printTransiciones(){
    System.out.printf("δ={\n");
    for(Estado edo:edosAFN){
      edo.printEstado();
    }
    System.out.printf("}\n");
  }

  public void printInit(){
    System.out.printf("I={ %d }\n",edoInit.getId());
  }

  public void printAFN(){
    enumAFN();
    printLang();
    printEdosAFN();
    printInit();
    printEdosAceptacion();
    printTransiciones();
  }

  public AFN afnBasico(Character s){
    return new AFN(s);
  }

  public AFN unirAFN(AFN f2){
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
}
