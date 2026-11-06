package Profile;

public class ProfileDemonstration {
    public static void main(String[] args) {
        ProfileBuilder profileBuilder = new ProfileBuilder();
        profileBuilder.setFullName("Jane Doe");
        profileBuilder.setEmail("jane.doe@example.com");
        profileBuilder.setPhoneNumber("612345678");
        profileBuilder.setAddress("Spain, Madrid, Madrid, Gran Via 1");
        profileBuilder.setDateOfBirth("01/01/1990");
        profileBuilder.setGender("Female");
        profileBuilder.setNationality("Spanish");
        profileBuilder.setPassportNumber("12345678A");
        ProfilePrimary profile = profileBuilder.getProfile();
        System.out.println(profile.toString());

        // Singleton Pattern Demonstration
        ProfilePrimary profile2 = ProfilePrimary.getProfile();
        System.out.println(profile2.toString());
    }
}
