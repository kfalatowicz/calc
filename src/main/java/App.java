
public class App {


    public static void main( String[] args ) {
        Calc calc = new Calc();

        System.out.println(calc.calculate("1 + ( 2 * 3 ) / -1"));

        System.out.println();

        System.out.println(Calc2.calculate("1 + ( 2 * 3 ) / -1"));

    }



}
