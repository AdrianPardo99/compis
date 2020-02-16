package utils;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import afn.AFN;
/*Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 16-02-2020 */

public class components{
  protected JFrame jrApp;
  protected ArrayList<JButton> arrBtn;
  protected ArrayList<JLabel> arrLbl;
  protected ArrayList<JTextField> arrTxt;
  protected ArrayList<AFN> arrAFN;
  protected JComboBox cmb;
  protected JPanel pan;
  protected int i;
  protected String namesCMB[]={"Crea AFN","Unir AFN's",
    "Concatenar AFN's","Cerraduras AFN","AFN to AFD",
    "Ver Transiciones \ndel Automata"},
    lbl1[]={"Create Simple AFN","Ingresa la letra","Indice del AFN",""},
    lbl2[]={"Union AFN","Ingresa el indice del primer AFN",
      "Ingresa el indice del segundo AFN","AFN Disponibles",""},
    lbl3[]={"Concatenacion AFN","Ingresa el indice del primer AFN",
      "Ingresa el indice del segundo AFN","AFN Disponibles",""};
}
