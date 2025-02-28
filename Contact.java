package main;

public class Contact {
    private final String contactID; // Cannot be updated after creation
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID. It must not be null and must be 10 characters or less.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name. It must not be null and must be 10 characters or less.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name. It must not be null and must be 10 characters or less.");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number. It must be exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address. It must not be null and must be 30 characters or less.");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters for updatable fields
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name. It must be 10 characters or less.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name. It must be 10 characters or less.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number. It must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address. It must be 30 characters or less.");
        }
        this.address = address;
    }
}
