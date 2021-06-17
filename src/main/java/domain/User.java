package domain;

public class User {
	private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    
    public User() {
    	
    }
    
    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public User(Long id, String firstName, String lastName, String email, int age) {
    	this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public Long getId() {
    	return id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
    
    public String getEmail() {
    	return email;
    }
}

