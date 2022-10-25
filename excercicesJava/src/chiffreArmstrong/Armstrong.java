package chiffreArmstrong;

public class Armstrong {

    public static void Armstrong() {

        for (int i = 100; i < 1000; i++) {
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;
            if (i == (a * a * a + b * b * b + c * c * c))
                System.out.println(i + " ");
        }
    }


    public static void Armstrong_2() {
        int i, j, k, n, sommecube;
        System.out.println("Nombres de Armstrong:");
        for (i = 1; i <= 9; i++)
            for (j = 0; j <= 9; j++)
                for (k = 0; k <= 9; k++) {
                    n = 100 * i + 10 * j + k;
                    sommecube = i * i * i + j * j * j + k * k * k;
                    if (sommecube == n)
                        System.out.println(n);
                }
    }
    public static void main(String[] args) {
        //Armstrong();
        //sArmstrong_2();
    }

}
