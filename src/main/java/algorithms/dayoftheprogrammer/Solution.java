package algorithms.dayoftheprogrammer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution {

  private static final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    int year = in.nextInt();
    System.out.println(solve(year));
  }

  static String solve(int year) {
    GregorianCalendar calendar = new GregorianCalendar();
    LocalDate localDate = LocalDate.ofYearDay(1918, 1);
    Date switchDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    calendar.setGregorianChange(switchDate);
    calendar.set(year, GregorianCalendar.JANUARY, 0);
    calendar.add(Calendar.DAY_OF_YEAR, 256);
    Instant instant = calendar.toInstant();
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Kaliningrad"));
    java.util.Date from = Date.from(instant);
    return localDateTime.format(DateTimeFormatter.ofPattern("d.MM.uuuu"));
  }
}
