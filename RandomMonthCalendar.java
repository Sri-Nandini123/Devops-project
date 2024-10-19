import java.util.Calendar;
import java.util.Random;

public class RandomMonthCalendar {
    public static void main(String[] args) {
        // Create a random number generator
        Random random = new Random();
        
        // Randomly select a month (0-based index: January is 0, December is 11)
        int month = random.nextInt(12);
        int year = 2024; // You can change the year as needed

        // Create a Calendar instance
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1); // Set the calendar to the first day of the random month
        
        // Get the number of days in the selected month
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        // Display the month and year
        System.out.println("Calendar for " + getMonthName(month) + " " + year + ":");
        
        // Print the days of the week
        System.out.println("Su Mo Tu We Th Fr Sa");
        
        // Print leading spaces for the first day of the month
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("   "); // Print space for empty days
        }
        
        // Print the days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            // Move to the next line after Saturday
            if ((day + firstDayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // Print a newline at the end
    }

    // Method to get the month name from the month index
    private static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[month];
    }
}
