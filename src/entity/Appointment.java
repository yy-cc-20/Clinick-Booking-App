package entity;

import boundary.ConsoleUI;

import java.time.LocalDate;
import java.util.List;

public class Appointment {
    // todo: sql or method?
    private final List<Patient> patients = DataList.getInstance().getPatientList(null, "", "");
    private final List<Allocation> allocations = DataList.getInstance().getAllocationList();

    private int appointmentId;
    private LocalDate appointmentDate;
    private Patient patient;
    private Allocation allocation;
    private Attendance attendance;
    private int startSlot;

    public Appointment(int appointmentId, String appointmentDate, int patientId, int allocationId,
                       String attendance, int startSlot) {
        this.appointmentId = appointmentId;
        this.appointmentDate = LocalDate.parse(appointmentDate, ConsoleUI.DATE_SQL_FORMATTER);
        this.patient = findPatient(patientId);
        this.allocation = findAllocation(allocationId);
        this.attendance = retrieveAttendance(attendance);
        this.startSlot = startSlot;
    }

    public Appointment(String appointmentDate, int patientId, int allocationId, String attendance, int startSlot) {
        this.appointmentDate = LocalDate.parse(appointmentDate, ConsoleUI.DATE_SQL_FORMATTER);
        this.patient = findPatient(patientId);
        this.allocation = findAllocation(allocationId);
        this.attendance = retrieveAttendance(attendance);
        this.startSlot = startSlot;
    }

    public Appointment() {
    }

    // todo connect to database
    private Patient findPatient(int patientId) {
        for (Patient value : patients) {
            if (value.getUserId() == patientId) {
                return value;
            }
        }
        return null;
    }

    private Allocation findAllocation(int appointmentId) {
        for (Allocation value : allocations) {
            if (value.getLinkId() == appointmentId) {
                return value;
            }
        }
        return null;
    }

    private Attendance retrieveAttendance(String attendance) {
        if (attendance.equals("Attended")) {
            return Attendance.ATTENDED;
        } else if (attendance.equals("Absent")) {
            return Attendance.ABSENT;
        } else {
            return Attendance.NAN;
        }
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDateString() {
        return appointmentDate.format(ConsoleUI.DATE_OUTPUT_FORMATTER);
    }

    public Patient getPatient() {
        return patient;
    }

    public Attendance getAttendance() {
        return attendance;
    }


    // todo
    public String getTime() {

        return "";
    }

    public String getDuration() {
        int required = allocation.getService().getTimeSlotRequired();
        return switch (required) {
            case 1 -> "30 mins";
            case 2 -> "1 hour";
            case 3 -> "1 hour 30 mins";
            case 4 -> "2 hours";
            case 5 -> "2 hours 30 mins";
            default -> throw new IllegalStateException("Unexpected value: " + required);
        };
    }

    public int getStartSlot() {
        return startSlot;
    }

    public Allocation getAllocation() {
        return allocation;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }


    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }
}
