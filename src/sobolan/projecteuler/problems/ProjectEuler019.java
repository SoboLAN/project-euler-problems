package sobolan.projecteuler.problems;

/**
 * @author Radu Murzea
 *
 * @problemstatement
 * You are given the following information, but you may prefer to do some research for yourself.
 * - 1 Jan 1900 was a Monday.
 * - Thirty days has September,
 * - April, June and November.
 * - All the rest have thirty-one,
 * - Saving February alone,
 * - Which has twenty-eight, rain or shine.
 * - And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class ProjectEuler019 extends AbstractExecutableProblem
{
    @Override
    public String getResult()
    {
        int sundaysCount = 0;
        
        //since 1 jan 1990 is a monday,
        //let's start with the next sunday
        int currentDay = 7;
        int currentMonth = 1;
        int currentYear = 1900;
        
        while (true) {
            //go to next sunday
            currentDay += 7;
            
            //if it jumps to another month... then perform the
            //necessary calculations
            int currentDayCount = this.getMonthDayCount(currentYear, currentMonth);
            if (currentDay > currentDayCount) {
                //recalculate day
                currentDay -= currentDayCount;
                
                //if the month change means going to the next
                //year, then make the necessary changes
                currentMonth++;
                if (currentMonth > 12) {
                    currentMonth -= 12;
                    currentYear++;
                }
            }
            
            //if the century is over, stop
            if (currentYear == 2001) {
                break;
            }
            
            //since the count starts only from 1901,
            //a check for this is necessary
            if (currentYear >= 1901) {
                if (currentDay == 1) {
                    sundaysCount++;
                }
            }
        }
    
        return Integer.toString(sundaysCount);
    }
    
    private int getMonthDayCount(int year, int month)
    {
        switch (month) {
            case 4: //april
            case 6: //june
            case 9: //september
            case 11: //november
                return 30;
            case 1: //january
            case 3: //march
            case 5: //may
            case 7: //july
            case 8: //august
            case 10: //october
            case 12: //december
                return 31;
            case 2: //february
                return (this.isLeapYear(year) ? 29 : 28);
            default:
                return 0;
        }
    }
    
    private boolean isLeapYear(int year)
    {
        return year % 100 == 0
            ? year % 400 == 0
            : year % 4 == 0;
    }
}
