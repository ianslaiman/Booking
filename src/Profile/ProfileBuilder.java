package Profile;

public class ProfileBuilder {
    private Profile profile;

    public ProfileBuilder() {
        this.profile = Profile.getProfile();
    }
    public void setFullName() {
        profile.setFullName("John Doe");
    }
    public void setEmail() {
        profile.setEmail("john.doe@gmail.com");
    }
    public void setPhoneNumber() {
        profile.setPhoneNumber("123456789");
    }
    public void setAddress() {
        profile.setAddress("CEU San Pablo, Madrid");
    }
    public void setDateOfBirth() {
        profile.setDateOfBirth("01/01/1990");
    }
    public void setGender() {
        profile.setGender("Male");
    }
    public void setNationality() {
        profile.setNationality("Spanish");
    }
    public void setPassportNumber() {
        profile.setPassportNumber("123456789");
    }
    public Profile getProfile() {
        return profile;
    }
}
