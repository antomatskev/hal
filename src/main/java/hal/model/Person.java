package hal.model;

public class Person {

    private Long id;
    private String personalCode;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String bankAccount;
    private String insurance;

    public Person() {
    }

    public Person(String personalCode, String firstName, String lastName, String address, String email,
                  String bankAccount, String insurance) {
        this.personalCode = personalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.bankAccount = bankAccount;
        this.insurance = insurance;
    }
    

    public Person(Long id, String personalCode, String firstName, String lastName, String address, String email,
			String bankAccount, String insurance) {
		super();
		this.id = id;
		this.personalCode = personalCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.bankAccount = bankAccount;
		this.insurance = insurance;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}
