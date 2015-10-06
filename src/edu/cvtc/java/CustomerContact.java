/**
 * 
 */
package edu.cvtc.java;

import java.awt.*;
import java.awt.event.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author ChaseLukeA
 *
 */
public class CustomerContact extends JFrame {

	private JPanel pnlFirstName, pnlLastName, pnlBirthDate,
			pnlEmailAddress, pnlPhoneNumber, pnlButtons, pnlShowAll;
	private JLabel lblFirstName, lblLastName, lblBirthDate,
			lblEmailAddress, lblPhoneNumber;
	private JTextField txtFirstName, txtLastName, txtBirthDate,
			txtEmailAddress, txtPhoneNumber;
	private JButton btnAdd, btnClear, btnShowAll;
	private final int WINDOW_WIDTH = 260;
	private final int WINDOW_HEIGHT = 260;

	Contact newContact;
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	int contactID;
	
	public CustomerContact() {
		super("Customer Contact");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(7, 1));
		
		lblFirstName = new JLabel("First Name:");
		lblLastName = new JLabel("Last Name:");
		lblBirthDate = new JLabel("Birth Date:");
		lblEmailAddress = new JLabel("Email Address");
		lblPhoneNumber = new JLabel("Phone Number:");
		
		txtFirstName = new JTextField(10);
		txtLastName = new JTextField(10);
		txtBirthDate = new JTextField(10);
		txtEmailAddress = new JTextField(10);
		txtPhoneNumber = new JTextField(10);
		
		btnAdd = new JButton("Add Customer");
		btnAdd.addActionListener(new ButtonListener());
		btnClear = new JButton("Clear Form");
		btnClear.addActionListener(new ButtonListener());
		btnShowAll = new JButton("Show All Contacts");
		btnShowAll.addActionListener(new ButtonListener());
		
		pnlFirstName = new JPanel();
		pnlFirstName.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlFirstName.add(lblFirstName);
		pnlFirstName.add(txtFirstName);

		pnlLastName = new JPanel();
		pnlLastName.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlLastName.add(lblLastName);
		pnlLastName.add(txtLastName);

		pnlBirthDate = new JPanel();
		pnlBirthDate.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlBirthDate.add(lblBirthDate);
		pnlBirthDate.add(txtBirthDate);

		pnlEmailAddress = new JPanel();
		pnlEmailAddress.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlEmailAddress.add(lblEmailAddress);
		pnlEmailAddress.add(txtEmailAddress);

		pnlPhoneNumber = new JPanel();
		pnlPhoneNumber.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlPhoneNumber.add(lblPhoneNumber);
		pnlPhoneNumber.add(txtPhoneNumber);

		pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlButtons.add(btnAdd);
		pnlButtons.add(btnClear);
		
		pnlShowAll = new JPanel();
		pnlShowAll.add(btnShowAll);
		
		add(pnlFirstName);
		add(pnlLastName);
		add(pnlBirthDate);
		add(pnlEmailAddress);
		add(pnlPhoneNumber);
		add(pnlButtons);
		add(pnlShowAll);
		
		setVisible(true);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			switch (e.getActionCommand()) {
			case "Add Customer":
				try {
					newContact = new Contact(
							txtFirstName.getText(),
							txtLastName.getText(),
							txtBirthDate.getText(),
							txtEmailAddress.getText(),
							txtPhoneNumber.getText());

					// Note to self: created contactID as just the array index
					// so I didn't have to modify the Person or Contact classes
					// to add data the final did not request; this is for fun
					contactID = saveContact(newContact, contacts);

					printContact(newContact, contactID);

					JOptionPane.showMessageDialog(null,
							"The customer contact was successfully created!",
							"Success!", JOptionPane.INFORMATION_MESSAGE);

					clearForm();
				} catch (InvalidParameterException error) {
					System.out.println(
							".---------------------------------------------.\n" +
							"| Error in contact creation! Could not create |\n" +
							"|   a contact using the information provided. |\n" +
							"'---------------------------------------------'\n");
					JOptionPane.showMessageDialog(null, error.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}

				break;
			case "Clear Form":
				clearForm();

				break;
			case "Show All Contacts":
				System.out.println("All Contacts:\n");

				for (int contactID = 0; contactID < contacts.size(); contactID++) {
					printContact(contacts.get(contactID), contactID + 1);
				}
				
				break;
			default:
				// Note to self: in case I create more buttons & forget to add to switch!
				JOptionPane.showMessageDialog(null, "This button does nothing yet!",
						"Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("This button does nothing yet!");
			}

		}	
		
		private int saveContact(Contact contact, ArrayList<Contact> contacts) {
			// Note to self: I'm using a method for future development
			// with adding contacts to a database or saving the data;
			// for now I'm just doing this with an array :)
			contacts.add(contact);
			return contacts.size();
		}
		
		private void printContact(Contact contact, int contactID) {
			System.out.println("\n=================================");
			System.out.println("Customer Contact " + contactID + "\n");
			System.out.println(contact);
			System.out.println("=================================\n");
		}
		
		private void clearForm() {
			txtFirstName.setText("");
			txtLastName.setText("");
			txtBirthDate.setText("");
			txtEmailAddress.setText("");
			txtPhoneNumber.setText("");
			txtFirstName.requestFocus();
		}

	}	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new CustomerContact();

	}

}
