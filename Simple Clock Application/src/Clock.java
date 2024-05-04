import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * The Clock class is responsible for displaying the current time and date.
 * It implements the Runnable interface to be executed as a thread.
 */
public class Clock implements Runnable {
    // Formatter for displaying the time and date in a specific format
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    /**
     * This method continuously updates and prints the current time in the specified format.
     */
    @Override
    public void run() {
        // Infinite loop to continuously update and print the time
        while (true) {
            System.out.println(formatter.format(LocalDateTime.now())); // Print current time and date
            try {
                TimeUnit.SECONDS.sleep(1); // Sleep for 1 second to update the time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status if needed
            }
        }
    }

    /**
     * The main method where the Clock thread is created and started.
     * It sets the priority of the Clock thread to maximum for better timekeeping precision.
     */
    public static void main(String[] args) {
        // Create a new thread for the Clock and start it
        Thread clockThread = new Thread(new Clock());
        clockThread.setPriority(Thread.MAX_PRIORITY); // Set maximum priority for better precision
        clockThread.start();
    }
}
