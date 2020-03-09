package ConsoleInput;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ConsoleInput {
    private final static String DOT_SPLITERATOR = ".";
    private final static int YEAR_INDEX = 0;
    private final static int MONTH_INDEX = 1;
    private final static int DAY_INDEX = 2;
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public double readDouble() {
        return scanner.nextDouble();
    }

    public String readString() {
        return scanner.next();
    }
}