package Profile;

public class ProfileBuilder {
    private ProfilePrimary profile;

    public ProfileBuilder() {
        this.profile = ProfilePrimary.getProfile();
    }
    public void setFullName(String name) {
        profile.setFullName(name);
    }
    public void setEmail(String email) {
        profile.setEmail(email);
    }
    public void setPhoneNumber(String phoneNumber) {
        profile.setPhoneNumber(phoneNumber);
    }
    public void setAddress(String Address) {
        profile.setAddress(Address);
    }
    public void setDateOfBirth(String birth) {
        profile.setDateOfBirth(birth);
    }
    public void setGender(String gender) {
        profile.setGender(gender);
    }
    public void setNationality(String nationality) {
        profile.setNationality(nationality);
    }
    public void setPassportNumber(String passportNumber) {
        profile.setPassportNumber(passportNumber);
    }
    public void setPoints(int points) {
        profile.setPoints(points);
    }
    public ProfilePrimary getProfile() {
        return profile;
    }
}
