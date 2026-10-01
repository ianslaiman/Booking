package Profile;

public class ProfileDemonstration {
    public static void main(String[] args) {
        ProfileBuilder profileBuilder = new ProfileBuilder();
        profileBuilder.setFullName();
        profileBuilder.setEmail();
        profileBuilder.setPhoneNumber();
        profileBuilder.setAddress();
        profileBuilder.setDateOfBirth();
        profileBuilder.setGender();
        profileBuilder.setNationality();
        profileBuilder.setPassportNumber();
        Profile profile = profileBuilder.getProfile();
        System.out.println(profile.toString());
        
        // Singleton Pattern Demonstration
        Profile profile2 = Profile.getProfile();
        System.out.println(profile2.toString());
    }
}
