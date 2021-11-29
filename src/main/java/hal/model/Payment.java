package hal.model;

public class Payment {

    private Long id;
    private Long personId;
    private String personalCode;
    private String income;
    private String sum;
    private String status;

    public Payment() {
    }

    public Payment(Long id, Long personId, String personalCode, String income, String sum, String status) {
        this.id = id;
        this.personId = personId;
        this.income = income;
        this.sum = sum;
        this.status = status;
    }

    public Payment(Long personId, String personalCode, String income, String sum, String status) {
        this.personId = personId;
        this.income = income;
        this.sum = sum;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
