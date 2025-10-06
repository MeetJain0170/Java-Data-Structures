import java.util.Map.Entry;
import java.util.TreeMap;

public class MyCalendar {
    private final TreeMap<Integer, Integer> bookings = new TreeMap<>();

    public MyCalendar() {
        bookings.put(Integer.MAX_VALUE, Integer.MAX_VALUE); // Sentinel value
    }

    public boolean book(int start, int end){
        Entry<Integer, Integer> nextBooking = bookings.higherEntry(start);
        boolean canBook=end <= nextBooking.getValue();
        if (canBook) {
            bookings.put(start, end);
        }
        return canBook;
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20)); // true  
    }
}
