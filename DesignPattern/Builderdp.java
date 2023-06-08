package DesignPattern;

class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    
    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
    }
    
    // Getters for all fields go here...
    
    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        
        public User build() {
            return new User(this);
        }
    }

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ "]";
	}
    
}


public class Builderdp {

	public static void main(String[] args) {
		User user = new User.Builder()
                .firstName("Shiva")
                .lastName("priya")
                .email("shiva.priya@example.com")
                .phone("555-666-888")
                .build();
		System.out.println(user);

	}

}