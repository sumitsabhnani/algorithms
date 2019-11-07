package codechef.june19;

import java.util.Scanner;

public class ChefAndProxy {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int testCases;
        testCases = reader.nextInt();
        while (testCases-- > 0) {
            int D = reader.nextInt();
            int minAttendance = (int) Math.ceil((double) D * 0.75);
            int actualAttendance = 0;
            char[] attendanceSheet = reader.next().toCharArray();
            int proxyable = 0;
            for (int i = 0; i < D; i++) {
                if (attendanceSheet[i] == 'P')
                    actualAttendance++;
                else {
                    if (!(i < 2 || i >= D - 2)) {
                        if (attendanceSheet[i - 1] == 'P' || attendanceSheet[i - 2] == 'P'
                                || attendanceSheet[i + 1] == 'P' || attendanceSheet[i + 2] == 'P')
                            proxyable++;
                    }
                }
            }
            if (actualAttendance < minAttendance) {
                int attendanceNeeded = minAttendance - actualAttendance;
                if (attendanceNeeded <= proxyable)
                    System.out.println(attendanceNeeded);
                else
                    System.out.println(-1);
            } else
                System.out.println(0);
        }

    }
}
