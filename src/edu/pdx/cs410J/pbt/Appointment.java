package edu.pdx.cs410J.pbt;

import edu.pdx.cs410J.AbstractAppointment;

/**
 * Appointment class allows for the creation of new appointments, and
 * the getting of the beginning time, end time, and description of
 * an appointment object.
 */

public class Appointment extends AbstractAppointment {

    private String beginTime;
    private String endTime;
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

        this.description = newDescription;
        this.beginTime = newBeginTime;
        this.endTime = newEndTime;
    }

    /**
     * Returns the beginTime field of the appointment class object.
     * @return - Returns a string representing the beginning time of an appointment.
     */
    @Override
    public String getBeginTimeString() {
        return this.beginTime;
    }

    /**
     * Returns the endTime field of the appointment class object.
     * @return - Returns a string representing the ending time of an appointment.
     */
    @Override
    public String getEndTimeString() {
        return this.endTime;
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
