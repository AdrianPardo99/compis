package regex;
import java.util.ArrayList;
import utils.color;

/* Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 10-02-2020 */

public class regex{
  /* Clase regex (Regular Expression) */
  private ArrayList<Character> arrChar;

  /* Constructor sin parametros */
  public regex(){
    arrChar=new ArrayList<Character>();
  }

  /* Getters y Setters de los elementos de la clase */
	public ArrayList<Character> getArrChar() {
		return arrChar;
	}

	public void setArrChar(ArrayList<Character> arrChar) {
		this.arrChar = arrChar;
	}

  /* Funcion que analiza si la regex esta bien balanceada
   * en caso de ser utilizada con parentesis */
  public ArrayList<Character> stringToArray(String reg){
    int parentesis=0,i;
    this.arrChar.clear();
    for (i=0;i<reg.length() ; i++) {
      if(reg.charAt(i)=='('){
        parentesis++;
      }else if(reg.charAt(i)==')'){
        parentesis--;
      }
    }
    if(parentesis!=0){
      System.out.printf("%sError parentesis no balanceado...%s\n",
        color.BRED,color.KNRM);
      return null;
    }else{
      System.out.printf("%sRegex balanceada...%s\n",
        color.BGRN,color.KNRM);
    }
    for(i=0;i<reg.length();i++){
      this.arrChar.add(reg.charAt(i));
    }
    return this.arrChar;
  }
}
