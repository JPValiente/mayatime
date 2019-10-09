package Calendar;

import java.util.Date;


public interface Calendario {
    
    public Calendario getToday();
    public Calendario getTomorrow();
    public Calendario getYesterday();
    public Calendario[][] getMatrix();
    public Calendario parseDate(Date date);
    
}