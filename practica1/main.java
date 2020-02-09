import afn.AFN;
public class main{
  public static void main(String[] args) {
    AFN f1=new AFN('s'),f2=new AFN('n');
    System.out.printf("AFN 1\n");
    f1.printAFN();
    System.out.printf("AFN 2\n");
    f2.printAFN();
    System.out.printf("AFN 1 | AFN 2\n");
    f1.unirAFN(f2);
    f1.printAFN();
  }
}
