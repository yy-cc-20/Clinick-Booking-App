/**
 * @subject 	UECS2344 SOFTWARE DESIGN 
 * @trimester 	January 2022
 * 
 * @system 		Clinick Appointment System
 * @date 		15/04/2022
 * 
 * @author 		Ling Sun Shuai      2004562 P2 
 * @author 		Kong Suet Hua       2005756 P5
 * @author 		Olivia Ong Yee Ming 2004564 P5
 * @author 		Tan Jia Qi          1904022 P2
 * @author 		Yang Chu Yan        2005912 P2
 * 
 * @database 	MySQL, using JDBC API (driver class version 8.0.28)
 * @see			database.DatabaseConnection class on how to connect this system to the MySQL database on your computer
 * 
 * @description A console program that aims to digitize the process of making an appointment. 
 * 				Applying object-oriented programming concept, using entity-boundary-controller design pattern.
 */

/**
 * @login User id and password can be found at database.DatabaseSetUp
 */

package boundary;

import database.DatabaseConnection;
import entity.*;

public class ClinickAppointmentSystem {
	public static void main(String... args) {

		boolean toExit = false;
		
		while (true) {
			ConsoleUI.displaySystemName("Clinic Booking System");
			User systemUser = new LoginUI().login(); // Suspend the user to login for 10 seconds after 3 failed login attempts
			// From systemUser can know the username, id, password, user type
	
			ConsoleUI.clearScreen();
			
			if (systemUser instanceof Receptionist) 
				toExit = startReceptionistView(systemUser);
			else if (systemUser instanceof Doctor) 
				toExit = startDoctorView(systemUser);
			else if (systemUser instanceof Patient) 
				toExit = startPatientView(systemUser);
			
			ConsoleUI.clearScreen();
			
			if (toExit) {
				ConsoleUI.displayFunctionName(" Program Stopped ");
				SingletonScanner.scanner.close();
				DatabaseConnection.closeConnection();
				System.exit(0);
			}
		}
	}
		
	/** @return false to logout, true to exit application */
	static boolean startReceptionistView(User systemUser) {
		int choiceNo; // the action that user wants to perform
		MakeAppointmentUI makeAppointmentUI = new MakeAppointmentUI(systemUser);
		ManageAppointmentUI manageAppointmentUI = new ManageAppointmentUI();
		ManagePatientUI managePatientUI = new ManagePatientUI();
		ManageAccountUI manageAccountUI = new ManageAccountUI(systemUser);

		while (true) {
			ConsoleUI.displayMenuForReceptionist();
			choiceNo = ConsoleInput.askChoice(0, 11, "Your choice");

			switch (choiceNo) {
				case 1 -> {
					ConsoleUI.displayFunctionName("View Appointment");
					makeAppointmentUI.viewAppointment();
				}
				case 2 -> {
					ConsoleUI.displayFunctionName("Search Appointment");
					makeAppointmentUI.searchAppointment();
				}
				case 3 -> {
					ConsoleUI.displayFunctionName("Make Appointment");
					makeAppointmentUI.viewAppointment();
				}
				case 4 -> {
					ConsoleUI.displayFunctionName("Update Appointment");
					manageAppointmentUI.updateAppointment();
				}
				case 5 -> {
					ConsoleUI.displayFunctionName("Cancel Appointment");
					manageAppointmentUI.cancelAppointment();
				}
				case 6 -> {
					ConsoleUI.displayFunctionName("Record Attendance");
					manageAppointmentUI.recordAttendance();
				}
				case 7 -> {
					ConsoleUI.displayFunctionName("Create Patient Profile");
					managePatientUI.createPatientProfile();
				}
				case 8 -> {
					ConsoleUI.displayFunctionName("Manage Patient Profile");
					managePatientUI.managePatientProfile();
				}
				case 9 -> {
					ConsoleUI.displayFunctionName("Search Patient");
					managePatientUI.searchPatient();
				}
				case 10 -> {
					ConsoleUI.displayFunctionName("Account Setting");
					manageAccountUI.changePassword();
				}
				case 11 -> {
					ConsoleUI.displayFunctionName("View Services and Time Slots for Booking");
					ViewSlotsUI.getInstance().viewSlots();
				}
				case 0 -> { 
					System.out.println("[1]Switch Account");
					System.out.println("[2]Exit Application");
					return ConsoleInput.askChoice(1, 2, "Select number") != 1;
				}
			}
			ConsoleUI.clearScreen();
		}		
	}
	
	/** @return true to logout, false to exit application */
	static boolean startDoctorView(User systemUser) {
		int choiceNo; // the action that user wants to perform
		
		while (true) {
			ConsoleUI.displayMenuForDoctor();
			choiceNo = ConsoleInput.askChoice(0, 4, "Your choice");

			switch (choiceNo) {
				case 1 -> {
					ConsoleUI.displayFunctionName("View Appointment");
					System.out.println("This feature is coming soon.");	
				}
				case 2 -> {
					ConsoleUI.displayFunctionName("Search Appointment");
					System.out.println("This feature is coming soon.");	
				}
				case 3 -> {
					ConsoleUI.displayFunctionName("Search Patient");
					System.out.println("This feature is coming soon.");	
				}
				case 4 -> {
					ConsoleUI.displayFunctionName("Account Setting");
					new ManageAccountUI(systemUser).changePassword();
				}
				case 0 -> { 
					System.out.println("[1]Switch Account");
					System.out.println("[2]Exit Application");
					return ConsoleInput.askChoice(1, 2, "Select number") != 1;
				}
			}
			ConsoleUI.clearScreen();
		}
	}
	
	/** @return true to logout, false to exit application */
	static boolean startPatientView(User systemUser) {
		int choiceNo; // the action that user wants to perform
		
		while (true) {
			ConsoleUI.displayMenuForPatient();
			choiceNo = ConsoleInput.askChoice(0, 4, "Your choice");

			switch (choiceNo) {
				case 1 -> {
					ConsoleUI.displayFunctionName("View Appointment");
					System.out.println("This feature is coming soon.");	
				}
				case 2 -> {
					ConsoleUI.displayFunctionName("Search Appointment");
					System.out.println("This feature is coming soon.");	
				}
				case 3 -> {
					ConsoleUI.displayFunctionName("Manage Account");
					new ManageAccountUI(systemUser).changePassword();
				}
				case 4 -> {
					ConsoleUI.displayFunctionName("View Services and Time Slots for Booking");
					ViewSlotsUI.getInstance().viewSlots();
				}
				case 0 -> { 
					System.out.println("[1]Switch Account");
					System.out.println("[2]Exit Application");
					return ConsoleInput.askChoice(1, 2, "Select number") != 1;
				}
			}
			ConsoleUI.clearScreen();
		}
	}
	
	/*
	// instantiating the user interfaces
	MakeAppointmentUI makeAppointmentInterface = new MakeAppointmentUI(systemUser);
	ManageAppointmentUI manageAppointmentInterface = new ManageAppointmentUI();
	ManagePatientUI managePatientInterface = new ManagePatientUI();
	*/
}
