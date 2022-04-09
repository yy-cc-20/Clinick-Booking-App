// general.UI.java

package boundary;

// display message on the screen

public class ConsoleUI { // UI: user interface
	// only static variable can be used in static method
	private static int headingWidth = 50; // the number of characters
	private static int screenHeight = 22; // the number of lines
	
	// clear screen
	public static void clearScreen() { 
		System.out.printf("%n[Enter] to continue...");
		 KeyboardInput.scanner.nextLine(); // pause, wait for user to continue
		 for (int i = 0; i < screenHeight; ++i) {
			 System.out.println();
		 }
	}
	
	// display the program name and menu name
	public static void displaySystemName(String heading) {
		int field = headingWidth - heading.length();
		
		for(int i = 0; i < headingWidth; ++i) {
			System.out.print('#');
		}
		System.out.printf("%n%n");
		
		for(int i = 0; i < field / 2; ++i) { // display the heading in the center
			System.out.print(' ');
		}
		System.out.print(heading);
		for(int i = 0; i < field / 2; ++i) {
			System.out.print(' ');
		}
		System.out.printf("%n%n");
		
		for(int i = 0; i < headingWidth; ++i) {
			System.out.print('#');
		}
		System.out.printf("%n%n");
	}
	
	public static void displayFunctionName(String heading) {
		int field = headingWidth - heading.length();
		
		System.out.printf("%n");
		
		for(int i = 0; i < field / 2; ++i) { // display the heading in the center
			System.out.print('-');
		}
		System.out.print(heading);
		for(int i = 0; i < field / 2; ++i) {
			System.out.print('-');
		}
		System.out.printf("%n%n");
	}
	
	// display the functions provided in this program
	public static void displayMenu() {
		System.out.println("[1]Add XX");
		System.out.println("[2]Modify Account Info");
		System.out.println("[3]Exit");
	}
	
	// let user chose which eventNo he/she wants to perform
	// assumption: the menu will be listed in numbered sentence each number between the range has an eventNo
	public static int askEventNo(int beginEventNo, int endEventNo) throws IllegalArgumentException { 
		if (beginEventNo > endEventNo) {
			throw new IllegalArgumentException();
		}
		
		int eventNo;
		final String errorMessage = "Sorry, input failed. Please enter the number of choice you want.%n";
				
		while (true) {
			try {
				System.out.printf("%n> ");
				eventNo = Integer.parseInt(KeyboardInput.scanner.nextLine());
				
				if(eventNo >= beginEventNo && eventNo <= endEventNo) {
					break;
				} else {
					System.out.printf(errorMessage);
				}
			}
			catch(NumberFormatException e) {
				System.out.printf(errorMessage);
				// 1. Apologise, the application should accept the responsibility for the problem
				// 2. What happened (what went wrong / the problem, why / the cause)
				// 3. How to fix it (where to find the bug / the solution)
			}
		} 
		return eventNo;
	}

	// let user chose which eventNo he/she wants to perform
	// return the valid input
	// assumption: the menu will be listed in sentence
	// 				index is alphabet
	// 				each alphabet between the range has an eventNo
	public static char askEventNo2(char beginEventNo, char endEventNo) throws IllegalArgumentException{ 
		char eventNo = '?';
		String input = "";
		boolean isChar = false;
		boolean isInRange = eventNo >= beginEventNo && eventNo <= endEventNo; // to form readable code
		
		if (beginEventNo > endEventNo) {
			throw new IllegalArgumentException();
		}
		
		do {
			try {
				isChar = false;
				System.out.printf("%n> ");
				input = KeyboardInput.scanner.nextLine();
				if(input.length() == 1 && Character.isLetter(input.charAt(0))) {
					eventNo = input.charAt(0);
					isChar = true;
				}
				isInRange = eventNo >= beginEventNo && eventNo <= endEventNo; // write after the value is known
				if(!isInRange) {
					System.out.println("Sorry, input failed. Please enter the letter of the corresponding action you want to perform.");
				}
			} catch(NumberFormatException e) {
				System.out.println("Sorry, input failed. Please enter the letter of the corresponding action you want to perform.");
				// 1. Apologize, the application should accept the responsibility for the problem
				// 2. What happened (what went wrong / the problem, why / the cause)
				// 3. How to fix it (where to find the bug / the solution)
			}
		} while(!isChar || !isInRange);
		return eventNo;
	}
}