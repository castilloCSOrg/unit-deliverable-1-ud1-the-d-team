/********************************************
*	AUTHORS:	Valentine 
* COLLABORATORS: Trevor, Frankie
*	LAST MODIFIED:	10/10/2024
********************************************/

/********************************************
*	<TITLE OF PROGRAM>
*********************************************
*	PROGRAM DESCRIPTION:
*	<1-2 sentences describing overall program>
*********************************************
*	ALGORITHM:
*	<Pseudocode here>
*********************************************
*	STATIC METHODS:
* <list of static methods and which teammate made each>
*********************************************/


public class Main 
{

  public static void main(String[] args)
  {
    System.out.println( "Welcome to our project! This program will tell you how many days you have to complete an assignment.\n You can put up to five assignments into the program.");
    System.out.println( "First we will need today's date.");


    int monthToday, dayToday, yearToday;
    
    monthToday = UtilityBelt.readInt("What month is it today? (Ex. Jan = 1, July = 7)\n", 1, 12); 
    dayToday = UtilityBelt.readInt("What day is it?\n", 1, 31);
    yearToday = 2024;

    int todayJulian= Main.calcJulianDate(monthToday,dayToday,yearToday);
    String todayDate = Main.date(monthToday, dayToday, yearToday);
    System.out.println("Today's date is " + todayDate);

    String assignment1, assignment2, assignment3, assignment4, assignment5;
    int assignDate1, assignDate2, assignDate3, assignDate4, assignDate5;
    int difference1, difference2, difference3, difference4, difference5;


    //Assignment 1
    assignment1 = Main.assignName();
    assignDate1 = Main.assignDate();
    difference1 = Main.calcDifference(assignDate1,todayJulian);
    System.out.println("You have "+ difference1 +" days left to complete the assignment "+assignment1);
  
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
    int month = UtilityBelt.readInt("What month is the assingment due?\n", 1, 12);
    int day = UtilityBelt.readInt("What day is the assignment due?\n", 1, 31);
    int year = UtilityBelt.readInt("What year is the assignment due?\n", 2024, 2025);

    String date = Main.date(month,day,year);
    System.out.println("This assignment is due on " + date);

    int juliandate = Main.calcJulianDate(month, day, year);
    return juliandate;
  }
  public static int calcDifference(int date1,int date2)
  {
    int difference = date1 - date2;
    return difference;
  }
  public static void daysleft( int difference, String assignent )
  {
        System.out.println("You have "+ difference +" days left to complete the assignment "+assignment);
      
  }
}



