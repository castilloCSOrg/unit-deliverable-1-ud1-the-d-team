/********************************************
*	AUTHORS:	Valentine 
* COLLABORATORS: Trevor, Frankie
*	LAST MODIFIED:	10/15/2024
********************************************/

/********************************************
* Deadline Keeper
*********************************************
*	PROGRAM DESCRIPTION:
The program allows the user to input information of an assignment and outputs the time in days and weeks left
to complete the assignment. 
*********************************************
*	ALGORITHM:
*	Print Welcome message
    Obtain user input for today's date
      Convert today's date into a julian day number
      Use date method to format user input
    For every assignment:
      Obtain user input for the name of the assignment
      Obtain user input for the due date of the assignment
        Convert user input to a julian day number
          Calculate difference between assignment julian day number and today's julian day number
            Output difference
            Divide difference by 7 to convert to weeks
            Output time in weeks
      Ask user if they want to continue
        if yes, go to next assignment
        if no say goodbye
        else show error and say goodbye

*********************************************
*	STATIC METHODS:
* <list of static methods and which teammate made each>
"date" Method - Valentine
"calcJulianDate" Method - Valentine
"assignName" Method -     Trevor
"assignDate" Method -     Trevor
"calcDifference" Method - Frankie
"timeWeek" Method -       Frankie
*********************************************/

public class Main 
{

  public static void main(String[] args)
  {
    System.out.println( "Welcome to our project! This program will tell you how many days you have to complete an assignment.\nYou can put up to three assignments into the program.");
    System.out.println( "First we will need today's date.");


    int monthToday, dayToday, yearToday;
    
    monthToday = UtilityBelt.readInt("What month is it today? (Ex. Jan = 1, July = 7)\n", 1, 12); 
    dayToday = UtilityBelt.readInt("What day is it?\n", 1, 31);
    yearToday = 2024;

    int todayJulian= Main.calcJulianDate(monthToday,dayToday,yearToday);
    String todayDate = Main.date(monthToday, dayToday, yearToday);
    System.out.println("Today's date is " + todayDate);

    String assignment1, assignment2, assignment3;
    int assignDate1, assignDate2, assignDate3;
    int difference1, difference2, difference3;

    String yes = "Yes";
    String yesLower = "yes";
    String no = "No";


    //Assignment 1
    assignment1 = Main.assignName();
    assignDate1 = Main.assignDate();
    difference1 = Main.calcDifference(assignDate1,todayJulian);
    System.out.println("You have "+ difference1 +" days left to complete the assignment "+ assignment1);
    Main.timeWeek(assignDate1, todayJulian);
    String yesNo1 = UtilityBelt.readString("Did you want to put in another assignment? (Yes/No)\n", 2, 3);
    if (yesNo1 == yes || yesNo1 == yesLower)
    {
       //Assignment 2
        assignment2 = Main.assignName();
        assignDate2 = Main.assignDate();
        difference2 = Main.calcDifference(assignDate2,todayJulian);
        System.out.println("You have "+ difference2 +" days left to complete the assignment "+ assignment2);
        Main.timeWeek(assignDate2, todayJulian);
        String yesNo2 = UtilityBelt.readString("Did you want to put in another assignment? (Yes/No)\n", 2, 3);
        if (yesNo2 == "Yes")
        {
          //Assignment 3
          assignment3 = Main.assignName();
          assignDate3 = Main.assignDate();
          difference3 = Main.calcDifference(assignDate3,todayJulian);
          System.out.println("You have "+ difference3 +" days left to complete the assignment "+ assignment3);
          Main.timeWeek(assignDate3, todayJulian);
        }
        else if (yesNo2 == "No")
        {
          System.out.println("Goodbye!");
        }
        else
        {
          System.out.println("ERROR not a Yes or No");
          System.out.println("Goodbye!");
        }
    }
    else if (yesNo1 == "No" || yesNo1 == "no")
    {
      System.out.println("Goodbye!");
    }


  }

  /***** STATIC METHODS *****/
  public static String date(int month, int day, int year)
  {
      String date = String.format("%02d/%02d/%4d", month, day, year);
      return date;
  }

  public static int calcJulianDate(int month, int day, int year)
  {
    int a = (14 - month) / 12;
    int m = month + 12 *a -3;
    int y = year + 4800 - a;
    int JDN = day + ((153 * m + 2) / 5) + (365 * y) + (y / 4) - (y / 100) + (y / 400) - 32045;
    return JDN;
  }

  public static String assignName()
  {
    String name = UtilityBelt.readString("What is the name of the assignment?\n", 1, 99);
    return name;
  }

  public static int assignDate()
  {
    int month = UtilityBelt.readInt("What month is the assignment due?\n", 1, 12);
    int day = UtilityBelt.readInt("What day is the assignment due?\n", 1, 31);
    int year = UtilityBelt.readInt("What year is the assignment due?\n", 2024, 2025);

    String date = Main.date(month,day,year);
    System.out.println("This assignment is due on " + date);

    int juliandate = Main.calcJulianDate(month, day, year);
    return juliandate;
  }

  public static int calcDifference(int date1, int date2)
  {
    int difference = date1 - date2;
    return difference;
  }

  public static void timeWeek(int date1, int date2)
  {
    double timeWeek = Main.calcDifference(date1, date2)/7.0;
    System.out.format("You have %2.2f weeks to complete the assignment.", timeWeek);
  }

}



