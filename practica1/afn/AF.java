package afn;
import java.util.Set;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashSet;
import java.lang.ProcessBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/* Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 29-02-2020 */

public class AF extends AFN{
  private ArrayList<Transicion> arrTransicion;
  public AF(){
    super();
    isAFD=false;
  }

  public AF(Character s){
    super(s);
    isAFD=false;
  }


    /* Funcion que permite obtener
     * el estado que tiene el simbolo del lenguaje
     */
    public Estado moverA(Estado e,Character simbolo){
      for(Transicion t :e.getTransiciones()){
        if(t.getSimbolo()==simbolo){
          return t.getEstadoSig();
        }
      }
      return null;
    }

    /* Funcion que hace la cerradura epsilon de cualquier
     * estado del automata
     */
    public HashSet<Estado> cerraduraEpsilon(Estado e){
      if(e==null){
        return null;
      }
      HashSet<Estado> R=new HashSet<Estado>(),aux;
      Stack<Estado> p=new Stack<Estado>();
      Estado e2;
      p.push(e);
      while(!p.empty()){
        e2=p.pop();
        if(R.contains(e2)){
          continue;
        }
        for(Transicion t :e2.getTransiciones() ) {
          if(t.getSimbolo()==epsilon){
            if(!R.contains(t.getEstadoSig())){
              p.push(t.getEstadoSig());
              aux=cerraduraEpsilon(t.getEstadoSig());
              R.add(t.getEstadoSig());
              for (Estado e1 :aux){
                if(!R.contains(e1)){
                  R.add(e1);
                }
              }
            }
          }
        }
      }
      R.add(e);
      return R;
    }


    /* Funcion que hace las llamadas de funciones moverA y cerraduraEpsilon */
    public HashSet<Estado> IrA(Estado e,Character simbolo){
      return cerraduraEpsilon(moverA(e,simbolo));
    }

    /* Funcion que convierte de AFN a AFD */
    public AF AFNtoAFD(){
      if(this.isAFD){
        return this;
      }
      int i=0,b=1,c=0;
      ArrayList<String> tran=new ArrayList<String>();
      ArrayList<HashSet<Estado>> B=new ArrayList<HashSet<Estado>>();
      HashSet<HashSet<Estado>> A=new HashSet<HashSet<Estado>>();
      HashSet<Estado> aux,s=cerraduraEpsilon(this.edoInit),aux2;
      A.add(s);
      B.add(s);
      AF afd=new AF();
      afd.isAFD=true;
      while(!A.isEmpty()){
        aux=A.stream().findFirst().get();
        System.out.printf("Iteracion %d\n{",i);
        for(Estado s1:aux){
          System.out.printf(" %d ",s1.getId());
        }
        System.out.printf("}\n");
        for(Character sim:alfabeto){
          for(Estado e:aux){
            aux2=IrA(e,sim);
            if(aux2!=null){
              if(!B.contains(aux2)){
                tran.add(i+","+sim+","+b);
                B.add(aux2);
                A.add(aux2);
                b++;
              }else{
                int coun=0,coun2=1,k,l;
                String sub="";
                for(HashSet<Estado> aux3:B){
                  coun2=1;
                  if(aux3.containsAll(aux2)){
                    for(String str:tran){
                      for(k=0;k<str.length();k++){
                        if(str.charAt(k)==','){
                          k++;
                          break;
                        }
                      }
                      for(l=k;l<str.length();l++){
                        if(str.charAt(l)==','){
                          break;
                        }
                      }
                      if(str.substring(k,l).charAt(0)==sim){
                        sub=str.substring(l+1,str.length())+","+sim+","+coun2;
                      }
                      coun2++;
                    }
                  }
                  coun++;
                }
                tran.add(sub);
              }
            }
          }
        }
        i++;
        A.remove(aux);
      }
      for(String ss:tran){
        System.out.printf("%s\n",ss);
      }
      int token=10;
      afd.edoInit=new Estado();
      afd.edoInit.setId(0);
      afd.edosAFN.add(afd.edoInit);
      afd.alfabeto=this.alfabeto;
      aux=B.stream().findFirst().get();
      for(Estado ee:aux){
        if(ee.isAceptacion()){
          afd.edoInit.setAceptacion(true);
          afd.edoInit.setToken(token);
          token+=10;
          afd.edosAceptacion.add(afd.edoInit);
          break;
        }
      }
      B.remove(aux);
      for(int j=0;j<i-1;j++){
        Estado e=new Estado();
        e.setId(j+1);
        aux=B.stream().findFirst().get();
        for(Estado ee:aux){
          if(ee.isAceptacion()){
            e.setAceptacion(true);
            e.setToken(token);
            token+=10;
            afd.edosAceptacion.add(e);
            break;
          }
        }
        afd.edosAFN.add(e);
        B.remove(aux);
      }
      String sub[];
      i=0;
      while(i<tran.size()){
        for(Estado edo:afd.edosAFN){
          sub=tran.get(i).split(",",3);
          b=Integer.parseInt(sub[0]);
          if(edo.getId()==b){
            for(Estado edo2:afd.edosAFN){
              c=Integer.parseInt(sub[2]);
              if(edo2.getId()==c){
                edo.getTransiciones().add(new Transicion(edo2,sub[1].charAt(0)));
                i++;
                break;
              }
            }
            break;
          }
        }
      }
      i=0;
      afd.printAFD();
      return afd;
    }

    public boolean bisAFD(){
      return this.isAFD;
    }
}
