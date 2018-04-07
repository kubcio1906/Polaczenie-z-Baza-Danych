import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {

        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                LocalDate.of(2013, 3, 31),
                LocalTime.of(2, 30),
                ZoneId.of("Europe/Berlin")
        );
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(
                LocalDate.of(2016, 10, 30),
                LocalTime.of(3, 30),
                ZoneId.of("Europe/Berlin")
        );
        System.out.println(zonedDateTime1);
    }
}
