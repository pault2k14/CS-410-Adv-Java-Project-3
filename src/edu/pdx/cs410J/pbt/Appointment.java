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

public class Appointment extends AbstractAppointment {

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

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm aa");
        dateFormat.setLenient(false);

        // Attempt to parse the begin date and time to ensure that they
        // are valid dates and times.
        try {
            this.beginTime = dateFormat.parse(newBeginTime);
        }
        catch (ParseException e) {
            System.err.println("Begin date and time format is incorrect.");
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
        DateFormat dateFormatter;
        dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
        String shortBeginTime = dateFormatter.format(this.beginTime);

        shortBeginTime += " " + beginTime.getHours() + ":" + beginTime.getMinutes();

        return shortBeginTime;
    }

    /**
     * Returns the endTime field of the appointment class object.
     * @return - Returns a string representing the ending time of an appointment.
     */
    @Override
    public String getEndTimeString() {
        DateFormat dateFormatter;
        dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
        String shortEndTime = dateFormatter.format(this.endTime);

        shortEndTime += " " + endTime.getHours() + ":" + endTime.getMinutes();

        return shortEndTime;
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
