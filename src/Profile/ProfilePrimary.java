package Profile;

import Facade.BookingMediator;

public class ProfilePrimary {
    private static ProfilePrimary profile;
    private String fullName;
    private String email;
    // Stored as text: phone numbers can have a leading 0 or '+', and can be longer than an int allows.
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String passportNumber;
    private int points;

    private BookingMediator mediator;

    private ProfilePrimary() {
    }

    public static ProfilePrimary getProfile() {
        if (profile == null) {
            profile = new ProfilePrimary();
        }
        return profile;
    }

    public void setMediator(BookingMediator mediator) {
        this.mediator = mediator;
    }

    // Getters
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getGender() { return gender; }
    public String getNationality() { return nationality; }
    public String getPassportNumber() { return passportNumber; }
    public int getPoints() { return points; }

    // Setters
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setGender(String gender) { this.gender = gender; }

    public void setNationality(String nationality) {
        this.nationality = nationality;
        if (this.mediator != null) {
            this.mediator.notify(this, "PROFILE_UPDATED");
        }
    }

    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
    public void setPoints(int points) { this.points = points; }

    @Override
    public String toString() {
        return "Profile{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", points=" + points +
                '}';
    }
}
