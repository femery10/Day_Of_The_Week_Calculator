import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static int day;
    static int month;
    static int year;
    static String[] numbers = new String[3];
    static int doomsday;
    static int century;
    static int justYear;
    static int answer;
    static int monthDoomsDay;
    static String dayOfTheWeek;

    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter Date (DD/MM/YYYY): ");

        String date = myScanner.nextLine();  // Read user input
        //System.out.println("Date is: " + date);  // Output user input

        numbers = date.split("/");

        day = Integer.parseInt(numbers[0]);
        month = Integer.parseInt(numbers[1]);
        year = Integer.parseInt(numbers[2]);


        //if month is 4 6 9 11, must be 30 days or less and greater than 0
        //if month is 1 3 5 7 8 10 12, must be 31 days or less and greater than 0
        //if (year % 4 == 0 && not year % 100 = 0 || year % 100 = 0 && year % 400 = 0) && month == 2, must be 29 or less and greater than 0
        //if year % 4 != 0 && month == 2, must be 28 or less and greater than 0

        if ((((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30 && day >= 1) ||
                ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31 && day >= 1) ||
                (month == 2 && year % 4 == 0 && year % 100 != 0 && day <= 29 && day >= 1) ||
                (month == 2 && year % 100 == 0 && year % 400 == 0 && day <= 29 && day >= 1) ||
                (month == 2 && year % 4 != 0 && day <= 28 && day >= 1)) &&
                        year >= 1000 && month >= 0 && month <= 12)
        {
            //System.out.println(day);
            //System.out.println(month);
            //System.out.println(year);

            //set century
            century = Integer.parseInt(Integer.toString(year).substring(0,2));
            justYear = Integer.parseInt(Integer.toString(year).substring(2,4));

            /*
            0 fri
            1 wed
            2 tue
            3 sun
            4 fri
            5 wed
            6 tue
            7 sun
            8 fri
            9 wed
            10 tue
            11 sun
             */

            //determine doomsDay
            if ((century - 13) % 4 == 0)
            {
                doomsday = 0 + (justYear + (justYear / 4));

                doomsday = doomsday % 7;
            }

            if ((century - 12) % 4 == 0)
            {
                doomsday = 2 + (justYear + (justYear / 4));

                doomsday = doomsday % 7;
            }

            if ((century - 11) % 4 == 0)
            {
                doomsday = 3 + (justYear + (justYear / 4));

                doomsday = doomsday % 7;
            }

            if ((century - 10) % 4 == 0)
            {
                doomsday = 5 + (justYear + (justYear / 4));

                doomsday = doomsday % 7;
            }


            //System.out.println("doomsDay: " + doomsday);

            //determine monthDoomsday
            if (month == 1 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)))
            {
                monthDoomsDay = 4;
            }

            if (month == 1 && ((year % 4 == 0 && year % 100 == 0 && year % 400 != 0)))
            {
                monthDoomsDay = 3;
            }

            if (month == 1 && ((year % 4 != 0)))
            {
                monthDoomsDay = 3;
            }

            if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)))
            {
                monthDoomsDay = 29;
            }

            if (month == 2 && ((year % 4 == 0 && year % 100 == 0 && year % 400 != 0)))
            {
                monthDoomsDay = 28;
            }

            if (month == 2 && ((year % 4 != 0)))
            {
                monthDoomsDay = 28;
            }

            if (month == 3)
            {
                monthDoomsDay = 14;
            }

            if (month == 4)
            {
                monthDoomsDay = 4;
            }

            if (month == 5)
            {
                monthDoomsDay = 9;
            }

            if (month == 6)
            {
                monthDoomsDay = 6;
            }

            if (month == 7)
            {
                monthDoomsDay = 11;
            }

            if (month == 8)
            {
                monthDoomsDay = 8;
            }

            if (month == 9)
            {
                monthDoomsDay = 5;
            }

            if (month == 10)
            {
                monthDoomsDay = 10;
            }

            if (month == 11)
            {
                monthDoomsDay = 7;
            }

            if (month == 12)
            {
                monthDoomsDay = 12;
            }

            //System.out.println("monthDoomsDay: " + monthDoomsDay);

            //find day
            if (day == monthDoomsDay)
            {
                answer = doomsday;
            }

            if (day < monthDoomsDay)
            {
                answer = doomsday - ((monthDoomsDay - day) % 7);
            }

            if (day > monthDoomsDay)
            {
                answer = doomsday + ((day - monthDoomsDay) % 7);
            }

            //change to word
            if (answer == -6)
            {
                dayOfTheWeek = "Monday";
            }

            if (answer == -5)
            {
                dayOfTheWeek = "Tuesday";
            }

            if (answer == -4)
            {
                dayOfTheWeek = "Wednesday";
            }

            if (answer == -3)
            {
                dayOfTheWeek = "Thursday";
            }

            if (answer == -2)
            {
                dayOfTheWeek = "Friday";
            }

            if (answer == -1)
            {
                dayOfTheWeek = "Saturday";
            }

            if (answer == 0)
            {
                dayOfTheWeek = "Sunday";
            }

            if (answer == 1)
            {
                dayOfTheWeek = "Monday";
            }

            if (answer == 2)
            {
                dayOfTheWeek = "Tuesday";
            }

            if (answer == 3)
            {
                dayOfTheWeek = "Wednesday";
            }

            if (answer == 4)
            {
                dayOfTheWeek = "Thursday";
            }

            if (answer == 5)
            {
                dayOfTheWeek = "Friday";
            }

            if (answer == 6)
            {
                dayOfTheWeek = "Saturday";
            }

            if (answer == 7)
            {
                dayOfTheWeek = "Sunday";
            }

            if (answer == 8)
            {
                dayOfTheWeek = "Monday";
            }

            if (answer == 9)
            {
                dayOfTheWeek = "Tuesday";
            }

            if (answer == 10)
            {
                dayOfTheWeek = "Wednesday";
            }

            if (answer == 11)
            {
                dayOfTheWeek = "Thursday";
            }

            if (answer == 12)
            {
                dayOfTheWeek = "Friday";
            }

            System.out.println(dayOfTheWeek);
        }
        else
        {
            System.out.println("error: invalid date");
        }

    }
}