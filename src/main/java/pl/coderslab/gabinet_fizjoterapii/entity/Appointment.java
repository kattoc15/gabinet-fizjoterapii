package pl.coderslab.gabinet_fizjoterapii.entity;

import org.hibernate.validator.constraints.Range;


public class Appointment {

    public static String dayOfWeek[] =
            {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    private static String hourOfAptm[] =
            {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"};

    @Range(max = 1, message = "1 patient allowed")
    private int persons;



    public Appointment(String[] dayOfWeek, String[] hourOfAptm, int persons) {
        this.dayOfWeek = dayOfWeek;
        this.hourOfAptm = hourOfAptm;
        this.persons = persons;
    }


    public static String[] getDayOfWeek() {
        return dayOfWeek;
    }

    public static void setDayOfWeek(String[] dayOfWeek) {
        Appointment.dayOfWeek = dayOfWeek;
    }

    public static String[] getHourOfAptm() {
        return hourOfAptm;
    }

    public static void setHourOfAptm(String[] hourOfAptm) {
        Appointment.hourOfAptm = hourOfAptm;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }
}
