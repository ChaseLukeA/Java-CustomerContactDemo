/**
 * 
 */
package edu.cvtc.java;

import java.security.InvalidParameterException;

/**
 * @author ChaseLukeA
 *
 */
public class Person {

	String firstName, lastName, birthDate;
	
	public Person(String firstName, String lastName, String birthDate) {
		if (!nameIsValid(firstName) || !nameIsValid(lastName)) {
			throw new InvalidParameterException(
					"Invalid Name Format\n" +
					"Name fields cannot be left blank.");
		} else if (!dateIsValid(birthDate)) {
		    throw new InvalidParameterException(
		    		"Invalid Date Format\n" +
		    		"Birth Date must be in the format \"MM/DD/YYYY\"\n" +
					"where months, days and years are separated by\n" +
		    		"a forward slash \"/\" and where months and days\n" +
					"that are 1 thru 9 have a leading \"0\" on them.\n" +
		    		"Example: 01/01/2000");
		} else {
			this.firstName = firstName;
			this.lastName = lastName;
			this.birthDate = birthDate;
		}
	}

	private boolean nameIsValid(String name) {
		return name.matches(".+");
	}

	private boolean dateIsValid(String date) {
		return date.matches("(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])/((19|20|21)\\d\\d)");
	}
	
	@Override
	public String toString() {
		return "First Name: " + firstName + "\nLast Name: " + lastName
				+ "\nBirth Date: " + birthDate;
	}

}
