package boundary;

import entity.User;
import controller.ManageAccountController;

/*
 * How to use this class:
 * new ManageAccountUI(systemUser).changePassword(); // Just 1 line
 * the new password will be updated to the database
 */

public class ManageAccountUI {
    private ManageAccountController controller;
    private User currentUser;

    public ManageAccountUI(User uc) {
    	this.currentUser = uc;
    	controller = new ManageAccountController(currentUser);
    }
    
    // Exit this method if the user do not want to change the password
    public void changePassword() {
    	if (!ConsoleInput.askBoolean("Change password"))
    		return; // Don't want to change password

        String inputPassword;
        String confirmedPassword;
        
        while (true) {
            System.out.print("New password > ");
            inputPassword = SingletonScanner.scanner.nextLine();
            if (inputPassword.equalsIgnoreCase(ConsoleUI.CANCEL_KEY))
            	return;
            
            if (ManageAccountController.isValidPassword(inputPassword)) {
                break;
            } else {
                System.out.printf(ManageAccountController.PASSWORD_CRITERIA);
                System.out.println(ConsoleUI.CANCEL_OPERATION);
            }
        }
        
        System.out.print("Confirm new password > ");
        confirmedPassword = SingletonScanner.scanner.nextLine();
        
        if (inputPassword.equals(confirmedPassword)) {
        	controller.updatePassword(confirmedPassword);
        	System.out.println("Password changed.");
        } else
        	System.out.println("Password did not match.");
    }
}
