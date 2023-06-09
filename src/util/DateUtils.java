package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {

    public static String convertToSQLDate(String europeanDate) {
        try {
            DateFormat europeanFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = europeanFormat.parse(europeanDate);

            DateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sqlDate = sqlFormat.format(date);

            return sqlDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertToEuropeanDate(String sqlDate) {
        try {
            DateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sqlFormat.parse(sqlDate);

            DateFormat europeanFormat = new SimpleDateFormat("dd/MM/yyyy");
            String europeanDate = europeanFormat.format(date);

            return europeanDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long dateCalculator(String dateBegin, String dateEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate begin = LocalDate.parse(dateBegin, formatter);
        LocalDate end = LocalDate.parse(dateEnd, formatter);

        long daysBetween = ChronoUnit.DAYS.between(begin, end);

        return daysBetween;
    }
}
