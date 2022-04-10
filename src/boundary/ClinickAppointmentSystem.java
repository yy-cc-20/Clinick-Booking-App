/**
 * @subject 	UECS2344 SOFTWARE DESIGN 
 * @trimester 	January 2022
 * 
 * @system 		Clinik Appointment System
 * @date 		15/04/2022
 * 
 * @author 		Ling Sun Shuai      2004562 P2 
 * @author 		Kong Suet Hua       2005756 P5
 * @author 		Olivia Ong Yee Ming 2004564 P5
 * @author 		Tan Jia Qi          1904022 P2
 * @author 		Yang Chu Yan        2005912 P2
 * 
 * @database 	MySQL, using JDBC API (driver class version 8.0.28)
 * @see 		entity.DatabaseConnection (username: root password: root)
 * 
 * @description A console program that aims to digitize the process of making an appointment. 
 * 				Applying object-oriented programming concept, using entity-boundary-controller design pattern.
 **/

package boundary;

import java.sql.SQLException;

import entity.*;

public class ClinickAppointmentSystem {
	public static void main(String[] args) throws SQLException {
		// the login test data is created in DataList
		// role: doctor
		// userid: 1
		// username: username
		// password: password
		
		ConsoleUI.displaySystemName("Clinic Booking System");
		User systemUser = new LoginUI().login(); // Suspend the user to login for 10 seconds after 3 failed login attempts
		// From systemUser can know the username, id, password, user type

		ConsoleUI.clearScreen();

		int choiceNo; // the action that user wants to perform
		final int beginChoiceNo = 1; 
		final int endChoiceNo = 3;

		while (true) {
			ConsoleUI.displaySystemName("System Name");
			//ConsoleUI.displayMenu(); // need to change the menu
			choiceNo = KeyboardInput.askChoice(beginChoiceNo, endChoiceNo, "Your choice");

			switch (choiceNo) {
				case 1 -> {
					// Just to test the method, you may change the position of the code
					ConsoleUI.displayFunctionName("Account Setting");
					new ManageAccountUI(systemUser).changePassword();
				}
				case 2 -> // Modify Account Info
						ConsoleUI.displayFunctionName(" Modify Account Details ");
				case 3 -> { // logout and exit the program
					ConsoleUI.displayFunctionName(" Program Stopped ");
					SingletonScanner.scanner.close();
					DatabaseConnection.closeConnection(); /** @throws SQLException */
					System.exit(0);
				}
			}
			ConsoleUI.clearScreen();
		}
	}

}
