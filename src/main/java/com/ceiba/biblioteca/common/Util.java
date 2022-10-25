package com.ceiba.biblioteca.common;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

    /**
     * today get today date
     * @return Today date
     */
    public static LocalDate today(){
        return LocalDate.now();
    }

    /**
     * addDaysSkippingWeekends calculate max days return
     * @param days int of days for calculate max days return
     * @return Today date
     */
    public static LocalDate addDaysSkippingWeekends(int days) {
        LocalDate result = LocalDate.now();
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

    /**
     * dateFormat get date format
     * @param date date for change format
     * @return date format
     */
    public static String dateFormat(LocalDate date){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(format);
    }

}
