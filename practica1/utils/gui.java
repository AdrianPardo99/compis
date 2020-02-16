package utils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/*Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 15-02-2020 */

public class gui extends components{
  private int x,y;
  private String name;
  public gui(){
    this.x=450;
    this.y=500;
    this.name="Practica 1";
  }

  public void initGui(){
    jrApp=new JFrame(name);
    jrApp.setBounds(0,0,x,y);
    jrApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jrApp.setLocationRelativeTo(null);
    jrApp.setLayout(null);
    jrApp.setResizable(false);
    initComponents();
    jrApp.setVisible(true);
    jrApp.setDropTarget(null);
  }

  /*Pendientes por hacer de la interfaz es el menu validaciones e implemntar
   * AFN a AFD y la automatizacion de obtener datos con retornos a String */
  private void initComponents(){

  }
}
