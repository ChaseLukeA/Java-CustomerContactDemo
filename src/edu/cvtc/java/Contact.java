/**
 * 
 */
package edu.cvtc.java;

import java.security.InvalidParameterException;

/**
 * @author ChaseLukeA
 *
 */
public class Contact extends Person {

	String emailAddress, phoneNumber;
	
	public Contact(String firstName, String lastName, String birthDate,
			String emailAddress, String phoneNumber) {
		super(firstName, lastName, birthDate);
		if (!emailAddressIsValid(emailAddress)) {
			throw new InvalidParameterException(
					"Invalid Email Address Format\n" +
					"Email addresses must be entered in\n" +
					"the format \"yourname@domain.com\".");
		} else if (!phoneNumberIsValid(phoneNumber)) {
			throw new InvalidParameterException(
					"Invalid phone number format.\n" +
					"Phone numbers do not need a country\n" +
					"code and the numbers must be entered\n" +
					"separated by dashes: \"###-###-####\"");
		} else {
			this.emailAddress = emailAddress;
			this.phoneNumber = phoneNumber;
		}
	}
	
	private boolean emailAddressIsValid(String emailAddress) {
		return emailAddress.matches(
				"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+" +
				"(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	private boolean phoneNumberIsValid(String phoneNumber) {
		return phoneNumber.matches("^(\\d{3}-\\d{3}-\\d{4})$");
	}

	@Override
	public String toString() {
		return super.toString() + "\nEmail Address: " + emailAddress +
				"\nPhone Number: " + phoneNumber;
	}

}
