package util;

import java.text.SimpleDateFormat;
import java.util.*;

public class Utiles {

    public static List<String> getNextDays(int count){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date start = new Date();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, count);
        Date end = cal.getTime();

        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(start);
        List<String> nextDays = new ArrayList<String>();
        while (!gcal.getTime().after(end)){
            Date d = gcal.getTime();
            gcal.add(Calendar.DATE, 1);
            nextDays.add(sdf.format(d));
        }
        return nextDays;
    }
}
