package codechef.dsa_challenge.basic;

import java.util.Scanner;

public class Carvans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int cars = scanner.nextInt();
            int carsAtMaxSpeed = 0;
            int maxSpeedPossible = Integer.MAX_VALUE;
            for (int i = 0; i < cars; i++) {
                int speed = scanner.nextInt();
                if (speed <= maxSpeedPossible) {
                    carsAtMaxSpeed++;
                    maxSpeedPossible = speed;
                }
            }
            System.out.println(carsAtMaxSpeed);
        }
    }
}
