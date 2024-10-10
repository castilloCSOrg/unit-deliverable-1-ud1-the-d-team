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
  /***** CONSTANT SECTION *****/

  public static void main(String[] args)
  {
    /***** DECLARATION SECTION *****/

    int monthToday, dayToday, yearToday;
   
    /***** INITIALIZATION SECTION *****/
    
    monthToday = UtilityBelt.readInt("What month is it today? (Ex. Jan = 1, July = 7)\n", 1, 12); 
    dayToday = UtilityBelt.readInt("What day is it?\n", 1, 31);
    yearToday = UtilityBelt.readInt("What year?\n", 2020,2024);

    String todayDate = Main.date(monthToday, dayToday, yearToday);

    System.out.println("Today's date is " + todayDate);
    
    
    int jdnToday = Main.calcJulianDate(10,10,2024);
    int jdnOctTwenty = Main.calcJulianDate(11,10,2024);

    int difference = jdnOctTwenty - jdnToday;
    System.out.println(jdnToday);
    System.out.println(jdnOctTwenty);
    System.out.println(difference);
    /***** INTRO SECTION *****/

    /***** PROCESSING SECTION *****/

    /***** OUTPUT SECTION *****/
    
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
}
