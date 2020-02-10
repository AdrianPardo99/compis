import afn.AFN;

/*Developed by:
 * Valdez Esquivel Melani Betsabee
 * Gonzalez Pardo Adrian
 * Jurado Macias Samuel Alejandro
 * 3CM6 20-02
 * Last file update: 10-02-2020 */

public class main{
  public static void main(String[] args) {
    AFN f1=new AFN('s'),f2=new AFN('n');
    System.out.printf("\nAFN 1\n");
    f1.printAFN();
    System.out.printf("\nAFN 2\n");
    f2.printAFN();
    System.out.printf("\nAFN 1  AFN 2\n");
    f1.concatenarAFN(f2);
    f1.printAFN();
    System.out.printf("\nAFN 2\n");
    f2=new AFN('p');
    f2.printAFN();
    System.out.printf("\nnew AFN 2\n");
    f2.kleene();
    f2.printAFN();
  }
}
