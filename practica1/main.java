import afn.AF;
import regex.regex;
import java.util.ArrayList;
import utils.color;
import utils.gui;

/*Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 29-02-2020 */

public class main{
  public static void main(String[] args) {
    gui frame=new gui();
    frame.initGui();
    //arrF.get(0).execute();
  }
}

/*Code prube...
 *
 if(args.length==0){
   System.out.printf("%sPor favor ingresa el "+
   "programa y como argumentos algunas regex%s\n",color.BRED,color.KNRM);
 }
 boolean or=false,ban=false;
 ArrayList<AFN> arrF=new ArrayList<AFN>();
 regex Reg=new regex();
 for(String s:args){
   Reg.stringToArray(s);
   if(Reg.getArrChar()==null)
     continue;
   for(Character c:Reg.getArrChar()){
     if(c=='(' || c==')'){
       continue;
     }else{
       if(c=='|'){
         if(!or){
           arrF.add(new AFN());
           or=true;
         }
         continue;
       }else if(c=='*'){
         arrF.set( arrF.size()-1, arrF.get(arrF.size()-1).kleene());
       }else if(c=='+'){
         arrF.set(arrF.size()-1, arrF.get(arrF.size()-1).plus());
       }else if(or){
         arrF.remove(arrF.size()-1);
         arrF.add(new AFN(c));
         arrF.get(arrF.size()-2).unirAFN(arrF.get(arrF.size()-1));
         arrF.remove(arrF.size()-1);
         or=false;
       }else{
         if(ban){
           arrF.set(arrF.size()-1,arrF.get(arrF.size()-1).concatenarAFN(new AFN(c)));
         }else{
           arrF.add(new AFN(c));
           ban=true;
         }
       }
     }
   }
   ban=false;
   or=false;
 }
 for(AFN f:arrF){
   f.printAFN();
 }
 *



 Codigo de prueba para AFN to AFD
 ArrayList<AF> arrF=new ArrayList<AF>();
 arrF.add(new AF('a'));
 arrF.get(0).kleene();
 arrF.get(0).enumAFN();
 arrF.add(new AF('b'));
 arrF.get(1).enumAFN();
 arrF.get(0).unirAFN(arrF.get(1));
 arrF.get(0).enumAFN();
 arrF.remove(1);
 arrF.add(new AF('c'));
 arrF.get(1).enumAFN();
 arrF.get(0).unirAFN(arrF.get(1));
 arrF.get(0).enumAFN();
 arrF.remove(1);
 arrF.get(0).AFNtoAFD();
 arrF.get(0).printAFN();
*/
