package edu.pdx.cs410J.pbt;

import edu.pdx.cs410J.AbstractAppointment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Appointment class allows for the creation of new appointments, and
 * the getting of the beginning time, end time, and description of
 * an appointment object.
 */

public class Appointment extends AbstractAppointment implements Comparable<Appointment>{

    private Date beginTime;
    private Date endTime;
    private String description;

    /**
     * This constructor instantiates an appointment object.
     * @param newDescription - The description for the appointment as a string.
     * @param newBeginTime - The starting time for the appointment as a string
     *                     in the format of M(M)/d(d)/yyyy HH:mm
     * @param newEndTime - The ending time for the appointment as a string
     *                   in the format of M(M)/d(d)/yyyy HH:mm
     */

    public Appointment(String newDescription, String newBeginTime, String newEndTime) {

        // PROBLEMS BECAUSE
        // NOT USING Dateformat.SHORT
        // with getInstance() and getTimeInstance()

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a");
        dateFormat.setLenient(false);

        // Attempt to parse the begin date and time to ensure that they
        // are valid dates and times.
        try {
            this.beginTime = dateFormat.parse(newBeginTime);
        }
        catch (ParseException e) {
            System.err.println("In appointment Begin date and time format is incorrect.");
            System.exit(0);
        }

        // Attempt to parse the begin date and time to ensure that they
        // are valid dates and times.
        try {
            this.endTime = dateFormat.parse(newEndTime);
        }
        catch (ParseException e) {
            System.err.println("End date and time format is incorrect.");
            System.exit(0);
        }

        this.description = newDescription;

    }

    public int compareTo(Appointment appointment) {

        final int BEFORE = -1;
        final int AFTER = 1;
        final int EQUAL = 0;

        long time = this.beginTime.getTime();
        long moreTime = appointment.beginTime.getTime();

        if(this.beginTime.before(appointment.beginTime)) {
            return BEFORE;
        }

        if(this.beginTime.after(appointment.beginTime)) {
            return AFTER;
        }

        if(this.beginTime.equals(appointment.beginTime)) {

            if(this.endTime.before(appointment.endTime)) {
                return BEFORE;
            }

            if(this.endTime.after(appointment.endTime)) {
                return AFTER;
            }

            if(this.endTime.equals(appointment.endTime)) {

                if(this.description.compareTo(appointment.description) == -1) {
                    return BEFORE;
                }

                if(this.description.compareTo(appointment.description) == 1) {
                    return AFTER;
                }

                if(this.description.equals(appointment.description)) {
                    return EQUAL;
                }

            }
        }

        return EQUAL;
    }

    @Override
    public Date getBeginTime() {
        return null;
    }

    @Override
    public Date getEndTime() {
        return null;
    }
    /**
     * Returns the beginTime field of the appointment class object.
     * @return - Returns a string representing the beginning time of an appointment.
     */
    @Override
    public String getBeginTimeString() {

        // PROBLEMS BECAUSE
        // NOT USING Dateformat.SHORT
        // with getInstance() and getTimeInstance()

        String twelveHourBeginTime = null;

        SimpleDateFormat twelveHourDateFormat = new SimpleDateFormat("MM/dd/yy h:mm a");
        twelveHourDateFormat.setLenient(false);

        twelveHourBeginTime = twelveHourDateFormat.format(this.beginTime);

        return twelveHourBeginTime;
    }

    /**
     * Returns the endTime field of the appointment class object.
     * @return - Returns a string representing the ending time of an appointment.
     */
    @Override
    public String getEndTimeString() {

        // PROBLEMS BECAUSE
        // NOT USING Dateformat.SHORT
        // with getInstance() and getTimeInstance()

        String twelveHourEndTime = null;

        SimpleDateFormat twelveHourDateFormat = new SimpleDateFormat("MM/dd/yy h:mm a");
        twelveHourDateFormat.setLenient(false);

        twelveHourEndTime = twelveHourDateFormat.format(this.endTime);

        return twelveHourEndTime;
    }

    /**
     * Returns the description field of the appointment class object.
     * @return - Returns a string representing the description of an appointment.
     */

    @Override
    public String getDescription() {
        return this.description;
    }
}
