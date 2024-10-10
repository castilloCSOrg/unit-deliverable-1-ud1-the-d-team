/********************************************
*	AUTHORS:	Valentine 
* COLLABORATORS: Trevor, Frankie
*	LAST MODIFIED:	10/08/2024
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
    System.out.println( "Welcome to our project! This program will tell you how many dyas you have to complete an asiignment. You can put up to five assingnemts into the program.");
    System.out.println( " first we will need todays date.");


    int monthToday, dayToday, yearToday;
    
    monthToday = UtilityBelt.readInt("What month is it today? (Ex. Jan = 1, July = 7)\n", 1, 12); 
    dayToday = UtilityBelt.readInt("What day is it?\n", 1, 31);
    yearToday = UtilityBelt.readInt("What year?\n", 2020,2024);
    String todayDate = Main.date(monthToday, dayToday, yearToday);
    int todayjulian= Main.calcJulianDate(monthToday,dayToday,yearToday);
    System.out.println("Today's date is " + todayDate);

     String assignment1= Main.AssignName();
     int assigndate1=Main.AssignDate();
     int differnce1=Main.calcdifference(assigndate1,todayjulian);
     System.out.println(" You have "+ differnce1 +" days left to complete the assignment"+assignment1);

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

  public static String AssignName()
  {
    String Name = UtilityBelt.readString("What is the name of the assignment?", 1, 99);
    return Name;
  }

  public static int AssignDate()
  {
    int month = UtilityBelt.readInt("What month is the assingment due?", 1, 12);
    int day = UtilityBelt.readInt("What day is the assignment due?", 1, 31);
    int year = UtilityBelt.readInt("What year is the assignment due?", 2024, 2025);

    int juliandate = Main.calcJulianDate(month, day, year);
    return juliandate;
  }
  public static int calcdifference(int date1,int date2)
  {
    int difference= date1 - date2;
    return difference;
  }
}


