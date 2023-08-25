
public class Fibonacci {

    public static void main(String[] args) {


        int[] ertekek = {-2, 1, 4, 2, 5, -10};

        rendez(ertekek);
        fibonacci();

        for (int i = 0; i < 12; i++) {

            System.out.println(fibo(i));

        }
    }

    private static void fibonacci() {

        int elöző = 1;
        int elözőelötti = 0;

        for (int i = 0; i < 10; i++) {
            int aktuális = elözőelötti + elöző;
            elözőelötti = elöző;
            elöző = aktuális;
            System.out.println("Fibonacci: " + aktuális);
        }
        fibo(5);
    }

    static void rendez(int[] ertekek) {
        for (int i = 0; i < ertekek.length; i++) {
            for (int j = 1; j < ertekek.length - 1; j++) {
                if (ertekek[j - 1] < ertekek[j]) {
                    int tmp = ertekek[j - 1];
                    ertekek[j - 1] = ertekek[j];
                    ertekek[j] = tmp;
                    kiír(ertekek);
                }

            }
        }
    }

    static void kiír(int[] szam) {
        for (int i = 0; i < szam.length; i++) {
            System.out.println(szam[i] + " ");
        }
        System.out.println();
    }

    private static int fibo(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);

    }

    }
