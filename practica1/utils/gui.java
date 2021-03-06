package utils;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import afn.AF;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
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
    arrBtn=new ArrayList<>();
    arrLbl=new ArrayList<>();
    arrTxt=new ArrayList<>();
    arrAFN=new ArrayList<>();
    pan=new JPanel();
    cmb=new JComboBox();
    cmbCerradura=new JComboBox();
    arrBtn.add(new JButton("Abrir pestaña"));
    arrBtn.add(new JButton("Crea AFN"));
    arrBtn.add(new JButton("Une AFN"));
    arrBtn.add(new JButton("Concatena AFN"));
    arrBtn.add(new JButton("Cerradura"));
    arrBtn.add(new JButton("Visualizar"));
    arrBtn.add(new JButton("Convertir AFN a AFD"));
    for(String name:namesCMB){
      cmb.addItem(name);
    }
    for(String type : cmbCerr){
      cmbCerradura.addItem(type);
    }
    for(i=0;i<4;i++){
      arrLbl.add(new JLabel(lbl1[i]));
    }
    for(i=0;i<lbl2.length;i++){
      arrLbl.add(new JLabel(lbl2[i]));
    }
    for(i=0;i<lbl3.length;i++){
      arrLbl.add(new JLabel(lbl3[i]));
    }
    for(i=0;i<lbl4.length;i++){
      arrLbl.add(new JLabel(lbl4[i]));
    }
    for(i=0;i<lbl5.length;i++){
      arrLbl.add(new JLabel(lbl5[i]));
    }
    for(i=0;i<lbl6.length;i++){
      arrLbl.add(new JLabel(lbl6[i]));
    }
    for(i=0;i<8;i++){
      arrTxt.add(new JTextField());
    }
    model=new DefaultTableModel();
    tableAF=new JTable(model);
    sc=new JScrollPane(tableAF);
    for(String s:tableColumn){
      model.addColumn(s);
    }

    area=new JTextArea();
    sc1=new JScrollPane(area);
    setBoundingComponents();
  }

  private void setBoundingComponents(){
    arrBtn.get(0).setBounds(250,20,170,30);
    pan.setBounds(10,10,x,y);
    pan.setLayout(null);
    cmb.setBounds(10,20,230,30);
    arrLbl.get(0).setBounds((x/2)-70,70,200,30);
    for(i=1;i<3;i++){
      arrLbl.get(i).setBounds(10,110+(i-1)*(30),200,30);
    }
    arrTxt.get(0).setBounds(150,110,100,30);
    arrLbl.get(3).setBounds(150,140,50,30);

    arrLbl.get(4).setBounds((x/2)-70,70,200,30);
    for(i=5;i<7;i++){
      arrLbl.get(i).setBounds(10,110+(i-5)*(30),240,30);
    }
    arrTxt.get(1).setBounds(260,110,100,30);
    arrTxt.get(2).setBounds(260,140,100,30);
    arrLbl.get(7).setBounds(10,170,130,30);
    arrLbl.get(8).setBounds(160,170,200,30);
    arrBtn.get(1).setBounds((x/2)-70,180,100,30);
    arrBtn.get(2).setBounds((x/2)-70,210,100,30);

    arrLbl.get(9).setBounds((x/2)-70,70,200,30);
    for(i=10;i<12;i++){
      arrLbl.get(i).setBounds(10,110+(i-10)*(30),240,30);
    }
    arrLbl.get(12).setBounds(10,170,130,30);
    arrLbl.get(13).setBounds(160,170,200,30);
    arrTxt.get(3).setBounds(260,110,100,30);
    arrTxt.get(4).setBounds(260,140,100,30);
    arrBtn.get(3).setBounds((x/2)-100,210,160,30);

    arrLbl.get(14).setBounds((x/2)-70,70,200,30);
    for(i=15;i<17;i++){
      arrLbl.get(i).setBounds(10,110+(i-15)*(30),240,30);
    }
    arrLbl.get(17).setBounds(10,170,130,30);
    arrLbl.get(18).setBounds(160,170,200,30);
    arrTxt.get(5).setBounds(260,110,100,30);
    cmbCerradura.setBounds(260,140,100,30);
    arrBtn.get(4).setBounds((x/2)-100,210,160,30);


    arrLbl.get(19).setBounds((x/2)-70,70,200,30);
    arrLbl.get(20).setBounds(10,110,240,30);
    arrLbl.get(21).setBounds(10,140,240,30);
    arrLbl.get(22).setBounds(160,140,240,30);
    arrBtn.get(5).setBounds((x/2)-70,180,160,30);
    arrTxt.get(6).setBounds(160,110,100,30);
    sc.setBounds(10,220,x-30,100);
    sc1.setBounds(10,340,x-30,100);

    arrLbl.get(23).setBounds((x/2)-70,70,200,30);
    arrLbl.get(24).setBounds(10,110,240,30);
    arrLbl.get(25).setBounds(10,140,240,30);
    arrLbl.get(26).setBounds(160,140,240,30);
    arrTxt.get(7).setBounds(160,110,100,30);
    arrBtn.get(6).setBounds((x/2)-120,180,200,30);
    settingComponents();
  }

  private void settingComponents(){
    area.setEnabled(false);
    tableAF.setEnabled(false);
    arrBtn.get(0).addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        for (AF a : arrAFN) {
          if(a.bisAFD()){
            a.printAFD();
          }else{
            a.printAFN();
          }
        }
        if(cmb.getSelectedIndex()==0){
          pan.removeAll();
          pan.validate();
          pan.repaint();
          pan.add(cmb);
          pan.add(arrBtn.get(0));
          for(i=0;i<4;i++){
            pan.add(arrLbl.get(i));
          }
          pan.add(arrTxt.get(0));
          arrLbl.get(3).setText(""+arrAFN.size());
          pan.add(arrBtn.get(1));

        }else if(cmb.getSelectedIndex()==1){
          pan.removeAll();
          pan.validate();
          pan.repaint();
          pan.add(cmb);
          pan.add(arrBtn.get(0));
          for(i=4;i<8;i++){
            pan.add(arrLbl.get(i));
          }
          arrLbl.get(7).setText(""+arrAFN.size());
          pan.add(arrBtn.get(2));
          pan.add(arrTxt.get(1));
          pan.add(arrTxt.get(2));
          if(arrAFN.size()<2){
            JOptionPane.showMessageDialog(null,"Debe existir al menos 2 AFN's"
            +"\npara trabajar esta sección","Error",JOptionPane.ERROR_MESSAGE);
            arrBtn.get(2).setEnabled(false);
          }else{
            arrBtn.get(2).setEnabled(true);
          }
          pan.repaint();
        }else if(cmb.getSelectedIndex()==2){
          pan.removeAll();
          pan.validate();
          pan.repaint();
          pan.add(cmb);
          pan.add(arrBtn.get(0));
          for(i=9;i<14;i++){
            pan.add(arrLbl.get(i));
          }
          arrLbl.get(13).setText(""+arrAFN.size());
          pan.add(arrBtn.get(3));
          pan.add(arrTxt.get(3));
          pan.add(arrTxt.get(4));
          if(arrAFN.size()<2){
            JOptionPane.showMessageDialog(null,"Debe existir al menos 2 AFN's"
            +"\npara trabajar esta sección","Error",JOptionPane.ERROR_MESSAGE);
            arrBtn.get(3).setEnabled(false);
          }else{
            arrBtn.get(3).setEnabled(true);
          }
          pan.repaint();
        }else if(cmb.getSelectedIndex()==3){
          pan.removeAll();
          pan.validate();
          pan.repaint();
          pan.add(cmb);
          pan.add(arrBtn.get(0));
          for(i=14;i<19;i++){
            pan.add(arrLbl.get(i));
          }
          arrLbl.get(18).setText(""+arrAFN.size());
          pan.add(arrTxt.get(5));
          pan.add(cmbCerradura);
          pan.add(arrBtn.get(4));
          if(arrAFN.size()<1){
            JOptionPane.showMessageDialog(null,"Debe existir al menos 1 AFN"
            +"\npara trabajar esta sección","Error",JOptionPane.ERROR_MESSAGE);
            arrBtn.get(4).setEnabled(false);
          }else{
            arrBtn.get(4).setEnabled(true);
          }
          pan.repaint();
        }else if(cmb.getSelectedIndex()==4){
          pan.removeAll();
          pan.validate();
          pan.repaint();
          pan.add(cmb);
          pan.add(arrBtn.get(0));
          pan.add(arrLbl.get(23));
          pan.add(arrLbl.get(24));
          pan.add(arrLbl.get(25));
          pan.add(arrLbl.get(26));
          arrLbl.get(26).setText(""+arrAFN.size());
          pan.add(arrTxt.get(7));
          pan.add(arrBtn.get(6));
          if(arrAFN.size()<1){
            JOptionPane.showMessageDialog(null,"Debe existir al menos 1 AFN"
            +"\npara trabajar esta sección","Error",JOptionPane.ERROR_MESSAGE);
            arrBtn.get(6).setEnabled(false);
          }else{
            arrBtn.get(6).setEnabled(true);
          }
          /*Modulo de afn to afd*/
        }else if(cmb.getSelectedIndex()==5){
          /*Aqui va la tablita de transiciones*/
          model.setRowCount(0);
          area.setText("");
          pan.removeAll();
          pan.validate();
          pan.repaint();
          pan.add(cmb);
          pan.add(arrBtn.get(0));
          for(i=19;i<23;i++){
            pan.add(arrLbl.get(i));
          }
          arrLbl.get(22).setText(""+arrAFN.size());
          pan.add(arrBtn.get(5));
          pan.add(arrTxt.get(6));
          if(arrAFN.size()<1){
            JOptionPane.showMessageDialog(null,"Debe existir al menos 1 AFN"
            +"\npara trabajar esta sección","Error",JOptionPane.ERROR_MESSAGE);
            arrBtn.get(5).setEnabled(false);
          }else{
            arrBtn.get(5).setEnabled(true);
          }
          pan.add(sc);
          pan.add(sc1);
        }else{
          pan.removeAll();
          pan.validate();
          pan.repaint();
          pan.add(cmb);
          pan.add(arrBtn.get(0));
        }
      }
    });

    arrBtn.get(1).addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        if(arrTxt.get(0).getText().isEmpty()){
          JOptionPane.showMessageDialog(null,"Debe escribir una "+
            "letra para crear el AFN\npara trabajar esta sección",
            "Error",JOptionPane.ERROR_MESSAGE);
        }else{
          arrAFN.add(new AF(arrTxt.get(0).getText().charAt(0)));
          arrLbl.get(3).setText(""+arrAFN.size());
          arrTxt.get(0).setText("");
        }
      }
    });
    arrBtn.get(2).addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        if(arrTxt.get(1).getText().isEmpty()||arrTxt.get(2).getText().isEmpty()){
          JOptionPane.showMessageDialog(null,"Debe escribir los "+
            "indices de los AFN\npara trabajar esta sección",
            "Error",JOptionPane.ERROR_MESSAGE);
        }else{
          int a=Integer.parseInt(arrTxt.get(1).getText()),
          b=Integer.parseInt(arrTxt.get(2).getText());
          if(a>arrAFN.size()-1||b>arrAFN.size()-1){
            JOptionPane.showMessageDialog(null,"Debe escribir los "+
            "indices\npara trabajar esta sección\n"+
            "Estos indices si son correctos eliminara el segundo AFN"+
            "\nY el primer AFN ingresado sera el modificado",
            "Error",JOptionPane.ERROR_MESSAGE);
          }else if(a==b){
            JOptionPane.showMessageDialog(null,"Debe escribir los "+
              "indices diferentes de los AFN\npara trabajar esta sección",
              "Error",JOptionPane.ERROR_MESSAGE);
          }else{
            arrAFN.get(a).unirAFN(arrAFN.get(b));
            arrAFN.remove(b);
            arrLbl.get(8).setText(""+arrAFN.size());
            arrTxt.get(1).setText("");
            arrTxt.get(2).setText("");
            if(arrAFN.size()<2){
              arrLbl.get(8).setText(""+arrAFN.size());
              JOptionPane.showMessageDialog(null,"El AFN "+b+" es eliminado y\n"+
                "su configuracion esta en el AFN "+a+
                "\n\nY se deshabilitara boton debido a que ya no hay otro AFN",
                "Atencion",JOptionPane.INFORMATION_MESSAGE);
              arrBtn.get(2).setEnabled(false);
            }else{
              arrLbl.get(8).setText(""+arrAFN.size());
              arrBtn.get(2).setEnabled(true);
              JOptionPane.showMessageDialog(null,"El AFN "+b+" es eliminado y\n"+
                "su configuracion esta en el AFN "+a,"Atencion",
                JOptionPane.INFORMATION_MESSAGE);
            }
            pan.repaint();
          }
        }
      }
    });
    arrBtn.get(3).addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        if(arrTxt.get(3).getText().isEmpty()||arrTxt.get(4).getText().isEmpty()){
          JOptionPane.showMessageDialog(null,"Debe escribir los "+
            "indices de los AFN\npara trabajar esta sección",
            "Error",JOptionPane.ERROR_MESSAGE);
        }else{
          int a=Integer.parseInt(arrTxt.get(3).getText()),
          b=Integer.parseInt(arrTxt.get(4).getText());
          if(a>arrAFN.size()-1||b>arrAFN.size()-1){
            JOptionPane.showMessageDialog(null,"Debe escribir los "+
            "indices\npara trabajar esta sección\n"+
            "Estos indices si son correctos eliminara el segundo AFN"+
            "\nY el primer AFN ingresado sera el modificado",
            "Error",JOptionPane.ERROR_MESSAGE);
          }else if(a==b){
            JOptionPane.showMessageDialog(null,"Debe escribir los "+
              "indices diferentes de los AFN\npara trabajar esta sección",
              "Error",JOptionPane.ERROR_MESSAGE);
          }else{
            arrAFN.get(a).concatenarAFN(arrAFN.get(b));
            arrAFN.remove(b);
            arrLbl.get(13).setText(""+arrAFN.size());
            arrTxt.get(3).setText("");
            arrTxt.get(4).setText("");
            if(arrAFN.size()<2){
              arrLbl.get(8).setText(""+arrAFN.size());
              JOptionPane.showMessageDialog(null,"El AFN "+b+" es eliminado y\n"+
                "su configuracion esta en el AFN "+a+
                "\n\nY se deshabilitara boton debido a que ya no hay otro AFN",
                "Atencion",JOptionPane.INFORMATION_MESSAGE);
              arrBtn.get(3).setEnabled(false);
            }else{
              arrLbl.get(13).setText(""+arrAFN.size());
              arrBtn.get(3).setEnabled(true);
              JOptionPane.showMessageDialog(null,"El AFN "+b+" es eliminado y\n"+
                "su configuracion esta en el AFN "+a,"Atencion",
                JOptionPane.INFORMATION_MESSAGE);
            }
            pan.repaint();
          }
        }
      }
    });
    arrBtn.get(4).addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        if(arrTxt.get(5).getText().isEmpty()){
          JOptionPane.showMessageDialog(null,"Debe escribir el "+
            "indice del AFN\npara trabajar esta sección",
            "Error",JOptionPane.ERROR_MESSAGE);
        }else{
          int a=Integer.parseInt(arrTxt.get(5).getText());
          if(a>arrAFN.size()-1){
            JOptionPane.showMessageDialog(null,"Debe escribir el "+
            "indice\npara trabajar esta sección\n"+
            "Este indices si es correcto sobreescribira el AFN",
            "Error",JOptionPane.ERROR_MESSAGE);
          }else{
            String op[]={"Cerradura positiva","Cerradura de kleene",
              "Cerradura opcional"};
            switch(cmbCerradura.getSelectedIndex()){
              case 0:
                arrAFN.get(a).plus();
              break;
              case 1:
                arrAFN.get(a).kleene();
              break;
              case 2:
                arrAFN.get(a).cerraduraOpcional();
              break;
            }
            JOptionPane.showMessageDialog(null,"El AFN "+a+" es modificado a\n"
              +op[cmbCerradura.getSelectedIndex()],
              "Atencion",JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    });
    arrBtn.get(5).addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        area.setText("");
        model.setRowCount(0);
        if(arrTxt.get(6).getText().isEmpty()){
          JOptionPane.showMessageDialog(null,"Debe escribir el "+
            "indice del AFN\npara trabajar esta sección",
            "Error",JOptionPane.ERROR_MESSAGE);
        }else{
          int a=Integer.parseInt(arrTxt.get(6).getText());
          if(a>arrAFN.size()-1){
            JOptionPane.showMessageDialog(null,"Debe escribir el "+
              "indice\npara trabajar esta sección\n","Error",
              JOptionPane.ERROR_MESSAGE);
          }else{
            String aux="",arr[];
            for(Object o:arrAFN.get(a).getAllTransiciones()){
              aux=o.toString();
              arr=aux.split(",");
              Object ar[]={arr[0],arr[1],arr[2]};
              model.addRow(ar);
            }
            area.setText(arrAFN.get(a).Tupla());
          }


        }
      }
    });
    /* Aqui transforma AFN a AFD */
    arrBtn.get(6).addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        if(arrTxt.get(7).getText().isEmpty()){
          JOptionPane.showMessageDialog(null,"Debe escribir los "+
            "indices de los AF\npara trabajar esta sección",
            "Error",JOptionPane.ERROR_MESSAGE);
        }else{
          int a=Integer.parseInt(arrTxt.get(7).getText());
          if(a>arrAFN.size()-1){
            JOptionPane.showMessageDialog(null,"Debe escribir el "+
            "indice\npara trabajar esta sección\n"+
            "Este indices si es correcto sobreescribira el AFN",
            "Error",JOptionPane.ERROR_MESSAGE);
          }else{
            AF aux=arrAFN.get(a).AFNtoAFD();
            arrAFN.remove(a);
            arrAFN.add(aux);
            JOptionPane.showMessageDialog(null,"Se paso el AFN con indice "+a+
              " a AFD exitosamente","Informacion",
              JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    });
    arrTxt.get(0).addKeyListener(new  KeyListener(){
      @Override
      public void keyPressed(KeyEvent e){}
      @Override
      public void keyReleased(KeyEvent e){}
      @Override
      public void keyTyped(KeyEvent e){
        if(arrTxt.get(0).getText().length()>0){
          e.consume();
        }
      }
    });

    for(i=1;i<8;i++){
      arrTxt.get(i).addKeyListener(new KeyListener(){
        @Override
        public void keyPressed(KeyEvent e){}
        @Override
        public void keyReleased(KeyEvent e){}
        @Override
        public void keyTyped(KeyEvent e){
          if(!Character.isDigit(e.getKeyChar())){
            e.consume();
          }
        }
      });
    }

    addComponents();
  }

  private void addComponents(){
    jrApp.add(pan);
    pan.add(arrBtn.get(0));
    pan.add(cmb);
  }
}
