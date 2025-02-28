package main;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactID);
    }

    // Update an existing contact's fields
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }

        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    // Get a contact by ID (optional for validation in tests)
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
