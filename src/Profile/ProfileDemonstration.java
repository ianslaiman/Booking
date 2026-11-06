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
        ProfilePrimary profile = profileBuilder.getProfile();
        System.out.println(profile.toString());
        
        // Singleton Pattern Demonstration
        ProfilePrimary profile2 = ProfilePrimary.getProfile();
        System.out.println(profile2.toString());
    }
}
