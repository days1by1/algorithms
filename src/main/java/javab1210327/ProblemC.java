package javab1210327;

import java.util.Calendar;
import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String birthday = sc.nextLine();
        String[] birthdayArr = birthday.split("-");
        int birthYear = Integer.parseInt(birthdayArr[0]);
        int birthMonth = Integer.parseInt(birthdayArr[1]);
        int birthDate = Integer.parseInt(birthdayArr[2]);

        Calendar c = Calendar.getInstance();
        c.set(birthYear, birthMonth-1, birthDate);
        // System.out.println(c.getTime());    // Mon Apr 08 23:02:07 GMT+08:00 2013
        long begin = c.getTimeInMillis();
        c.set(2013, 3-1, 9);
        long end = c.getTimeInMillis();
        long days = (end - begin) / (1000 * 60 * 60 * 24);
        System.out.println(days);
    }
}
