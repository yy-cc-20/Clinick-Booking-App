package boundary;

import entity.*;

public class ClinickAppointmentSystem {
	public static void main(String[] args) {

		// instantiating the dataList object
		IDataStore dataList = DataStore.getInstance();

		// instantiating the controllers
		LoginController loginController = new LoginController();
		MakeAppointmentController makeAppointmentController = new MakeAppointmentController();
		ManageAppointmentController manageAppointmentController = new ManageAppointmentController();
		ManageAccountController manageAccountController = new ManageAccountController();
		ManagePatientController managePatientController = new ManagePatientController();

		// setting the controllers to the dataList object
		loginController.setDataLists(dataLists);
		makeAppointmentController.setDataLists(dataLists);
		manageAppointmentController.setDataLists(dataLists);
		manageAccountController.setDataLists(dataLists);
		managePatientController.setDataLists(dataLists);

		// instantiating the user interfaces
		LoginUI loginInterface = new LoginUI();
		MakeAppointmentUI makeAppointmentInterface = new MakeAppointmentUI();
		ManageAppointmentUI manageAppointmentInterface = new ManageAppointmentUI();
		ManageAccountUI manageAccountInterface = new ManageAccountUI();
		ManagePatientUI managePatientInterface = new ManagePatientUI();

		// setting the user interfaces to their controllers
		loginInterface.setController(loginController);
		makeAppointmentInterface.setController(makeAppointmentController);
		manageAppointmentInterface.setController(manageAppointmentController);
		manageAccountInterface.setController(manageAccountController);
		managePatientInterface.setController(managePatientController);

		// Retrieve data from database
		IDataStore dataList = DataList.getInstance(); // Already retrieved the data

		// the test data is created in DataList
		// role: doctor
		// userid: 1
		// username: username
		// password: password

		ConsoleUI.displaySystemName("Clinic Booking System");
		User systemUser = new LoginView().login(); // Suspend the user to login for 10 seconds after 3 failed login
													// attempts
		// From systemUser, you can know the username, id, password, user type

		ConsoleUI.clearScreen();

		int eventNo; // the action that user wants to perform
		final int beginEventNo = 1;
		final int endEventNo = 3;

		while (true) {
			ConsoleUI.displaySystemName("System Name");
			// ConsoleUI.displayMenu(); // need to change the menu
			eventNo = ConsoleUI.askEventNo(beginEventNo, endEventNo);

			switch (eventNo) {
<<<<<<< HEAD
			case 1:
				// Just to test the method, you may change the sequence of the code
				ConsoleUI.displayFunctionName("Account Setting");
				new ManageAccountView().modifyAccount(systemUser);
				
				break;
				
			case 2: // Modify Account Info
				ConsoleUI.displayFunctionName(" Modify Account Details ");
				break;
				
			case 3: // logout and exit the program
				ConsoleUI.displayFunctionName(" Program Stopped ");
				KeyboardInput.scanner.close();
				System.exit(0);
=======
				case 1:
					ConsoleUI.displayFunctionName(" Add XX ");
					break;

				case 2: // Modify Account Info
					ConsoleUI.displayFunctionName(" Modify Account Details ");
					break;

				case 3: // logout and exit the program
					ConsoleUI.displayFunctionName(" Program Stopped ");
					KeyboardInput.scanner.close();
					System.exit(0);
>>>>>>> 7705c57b73bab130cb82dfaa01d4cb147909e8e9
			}
			ConsoleUI.clearScreen();
		}
	}
}
/*
package boundary;

import entity.*;

public class ClinickAppointmentSystem {
	public static void main(String[] args) {
		// Retrieve data from database
		IDataStore dataList = DataList.getInstance(); // Already retrieved the data
		
		// the test data is created in DataList
		// role: doctor
		// userid: 1
		// username: username
		// password: password
		
		ConsoleUI.displaySystemName("Clinic Booking System");
		User systemUser = new LoginView().login(); // Suspend the user to login for 10 seconds after 3 failed login attempts
		// From systemUser, you can know the username, id, password, user type
		
		ConsoleUI.clearScreen();
							
		int eventNo; // the action that user wants to perform
		final int beginEventNo = 1; 
		final int endEventNo = 3;
			
		while (true) {
			ConsoleUI.displaySystemName("System Name");
			//ConsoleUI.displayMenu(); // need to change the menu
			eventNo = ConsoleUI.askEventNo(beginEventNo, endEventNo);
			
			switch (eventNo) {
			case 1:
				// Just to test the method, you may change the sequence of the code
				ConsoleUI.displayFunctionName("Account Setting");
				new ManageAccountView().modifyAccount(systemUser);
				
				break;
				
			case 2: // Modify Account Info
				ConsoleUI.displayFunctionName(" Modify Account Details ");
				break;
				
			case 3: // logout and exit the program
				ConsoleUI.displayFunctionName(" Program Stopped ");
				KeyboardInput.scanner.close();
				System.exit(0);
			}
			ConsoleUI.clearScreen();
		}
	}
}
*/