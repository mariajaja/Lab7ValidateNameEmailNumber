import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Mariah
 *
 */
public class ValidNameEmailPhone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		if (isValidName("Please enter your first name: ", userInput)) {
			System.out.println("Name is valid!");
		} else {
			System.out.println("Sorry, name is not valid!");
		}

		if (isValidDate(userInput, "Enter a valid date (dd/mm/yyyy): ")) {
			System.out.println("Date is valid!");
		} else {
			System.out.println("Sorry, date is not valid!");
		}

		if (isValidEmail(userInput, "Enter a valid email: ")) {
			System.out.println("Email is valid!");
		} else {
			System.out.println("Sorry, email is not valid!");
		}

		if (isValidNumber(userInput, "Enter a valid phone number (###) ###-####: ")) {
			System.out.println("Number is valid!");
		} else {
			System.out.println("Sorry, number is not valid!");
		}

	}

	// method to validate user's name
	public static boolean isValidName(String prompt, Scanner userInput) {
		System.out.print(prompt);
		String userNameInput = userInput.nextLine();

		if (userNameInput.matches("[A-Z][a-z]*")) {
			// continue to next check
			if ((userNameInput.length() <= 30) && (userNameInput.length() > 0)) {
				// continue to next check
				if (Character.isUpperCase(userNameInput.charAt(0))) {
					return true;
				}
			}
		}
		return false;
	}

	// method to validate an email
	public static boolean isValidEmail(Scanner userInput, String prompt) {
		System.out.println(prompt);
		String userEmailInput = userInput.nextLine();
		boolean acceptedCharacters = userEmailInput.matches("^[a-zA-Z0-9]{5,30}@[a-zA-Z0-9]{5,10}.[a-zA-Z0-9]{2,3}$");

		if (acceptedCharacters) {
			return true;
		} else {
			return false;
		}

	}

	// method to validate phone number (###) ###-####
	public static boolean isValidNumber(Scanner userInput, String prompt) {
		System.out.println(prompt);
		String userNumberInput = userInput.nextLine();
		boolean acceptedCharacters = userNumberInput.matches("\\(\\d{3}\\) \\d{3}-\\d{4}");

		if (acceptedCharacters) {
			return true;
		} else {
			return false;
		}
	}

	// method that validates user's input for date (DD/MM/YYYY)
	public static boolean isValidDate(Scanner userInput, String prompt) {

		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		format.setLenient(false); // format that date must match
		Date date = null;
		String userDateInput;

		System.out.println(prompt);
		// get the date the use wants to return
		userDateInput = userInput.nextLine();
		try {
			// format.parse throws an exception, converting String to date
			date = format.parse(userDateInput);
			// If exception doesn't occur, it's valid.
			return true;
		} catch (ParseException ex) {
			// If exception occurs, it's invalid.
			return false;
		}

	}
}
