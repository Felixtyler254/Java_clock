
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] arg) throws InterruptedException{
        int sec_prev=0;
        while (true){
            LocalTime now = LocalTime.now();
            int nano_sec = now.getNano();
            int sec = now.getSecond();
            int min = now.getMinute();
            int hours= now.getHour();

            String str = hours >= 12 ? "PM":"AM";
            hours = hours > 12 ?  hours - 12 : (hours == 0 ? 12 : hours);
            if (sec == sec_prev + 1 || (sec_prev == 59 && sec == 0)) {
                // Clear the console (not always possible in Java in the same way as system("CLS"))
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Print the time in a formatted way
                System.out.printf("%02d:%02d:%02d %s\n", nano_sec,hours, min, sec, str);
            }
            sec_prev = sec;
            Thread.sleep(1000); // Wait for 1 second

        }


    }
}