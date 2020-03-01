package utils;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import afn.AF;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

/*Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 29-02-2020 */

public class components{
  protected JFrame jrApp;
  protected ArrayList<JButton> arrBtn;
  protected ArrayList<JLabel> arrLbl;
  protected ArrayList<JTextField> arrTxt;
  protected ArrayList<AF> arrAFN;
  protected JComboBox cmb,cmbCerradura;
  protected JPanel pan;
  protected JTextArea area;
  protected int i;
  protected JTable tableAF;
  protected JScrollPane sc,sc1;
  protected DefaultTableModel model;
  protected String namesCMB[]={"Crea AFN","Unir AFN's",
    "Concatenar AFN's","Cerraduras AFN","AFN to AFD",
    "Ver Transiciones \ndel Automata"},
    lbl1[]={"Create Simple AFN","Ingresa la letra","Indice del AFN",""},
    lbl2[]={"Union AFN","Ingresa el indice del primer AFN",
      "Ingresa el indice del segundo AFN","AFN Disponibles",""},
    lbl3[]={"Concatenacion AFN","Ingresa el indice del primer AFN",
      "Ingresa el indice del segundo AFN","AFN Disponibles",""},
    cmbCerr[]={"Positiva","Kleene","Interrogativa"},
    lbl4[]={"Cerraduras","Ingresa el indice del AFN","Cerradura","AFN Disponibles",""},
    lbl5[]={"Muestra datos del AF","Indice del AF","AF Disponibles",""},
    lbl6[]={"Pasar AFN-AFD","Indice del AF","AF Disponibles",""},
    tableColumn[]={"Inicial","Simbolo","A"};

}
