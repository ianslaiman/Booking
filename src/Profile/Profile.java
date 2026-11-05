package Profile;

import Facade.BookingMediator;

public class Profile {
    private static Profile profile;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String passportNumber;
    private int points; // <-- Add points field
    
    private BookingMediator mediator;

    private Profile() {
    }

    public static Profile getProfile() {
        if (profile == null) {
            profile = new Profile();
            return profile;
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
    public int getPoints() { return points; } // <-- Add getter

    // Setters
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }
    public void getDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; } // Note: keep your existing setter name if it was setDateOfBirth
    public void setGender(String gender) { this.gender = gender; }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
        if (this.mediator != null) {
            this.mediator.notify(this, "PROFILE_UPDATED");
        }
    }
    
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
    public void setPoints(int points) { this.points = points; } // <-- Add setter

    // Make sure your setDateOfBirth is correctly named:
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    @Override 
    public String toString() {
        return "Profile{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", nationality='" + nationality + '\'' +
                ", points=" + points +
                '}';
    }
}