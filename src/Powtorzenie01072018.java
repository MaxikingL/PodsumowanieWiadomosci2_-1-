import java.util.Calendar;
import java.util.Scanner;

public class Powtorzenie01072018 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("podaj pesel: ");
        String pesel = sc.nextLine();

        int year = 1900 + Integer.parseInt(pesel.substring(0, 2));
        int month = Integer.parseInt(pesel.substring(2, 4));
        int day = Integer.parseInt(pesel.substring(4, 6));

        System.out.println(day + "." + month + "." + year);

        int todayMonth=7;
        int todayYear=2018;
        int todayDay=1;

        Calendar current = Calendar.getInstance();
        int currentYear = current.get(Calendar.YEAR);
        int currentMonth = current.get(Calendar.MONTH) + 1;
        int currentDay = current.get(Calendar.DAY_OF_MONTH);

        int counter = 0;

        // ZLICZAM DNI W PEŁNYCH LATACH
        for (int year1 = year + 1; year1 < currentYear; year1++) {
            counter += isLeap(year1) ? 366 : 365;
        }

        // TABLICA Z LICZBA DNI W MIESIACU
        int Monthlenght[] = {0, 31, 28, 31, 30, 31, 30, 31,
                31, 30, 31, 30, 31};

        // ZLICZAM DNI W ROKU OBECNYM I ROKU URODZENIA
        // rok urodzenia - do końca roku
        for (int month1 = month + 1; month1 <= 12; month1++) {
            counter += (month1 == 2 && isLeap(year)) ?
                    Monthlenght[month1] + 1 :
                    Monthlenght[month1];
        }
        // rok obecny - od początku roku
        for (int miesiac = 1; miesiac < currentMonth; miesiac++) {
            counter += (miesiac == 2 && isLeap(currentYear)) ?
                    Monthlenght[miesiac] + 1 :
                    Monthlenght[miesiac];
        }
        // dni w obecnym miesiacu
        counter += currentDay;

        // dni w miesiacu urodzenia
        counter += Monthlenght[month] - day;

        System.out.println("Jestem na świecie " + counter + " dni");
        System.out.println(counter + " modulo 2= " + counter%2 );

    }

    public static boolean isLeap(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
}

