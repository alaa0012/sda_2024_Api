package day04;

import java.util.HashMap;
import java.util.Map;

public class c18Getrequestnestedmap {

    public static Map<String, Object> bookingDatesMapper(String checkin, String checkout) {
        Map<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", checkin);
        bookingDates.put("checkout", checkout);
        return bookingDates;
    }

    public static Map<String, Object> bookingMapper(String firstname, String lastname, int totalprice,
                                                    boolean depositpaid, Map<String, Object> bookingDates,
                                                    String additionalneeds) {
        Map<String, Object> bookingData = new HashMap<>();
        bookingData.put("firstname", firstname);
        bookingData.put("lastname", lastname);
        bookingData.put("totalprice", totalprice);
        bookingData.put("depositpaid", depositpaid);
        bookingData.put("bookingdates", bookingDates);
        bookingData.put("additionalneeds", additionalneeds);
        return bookingData;
    }
}
