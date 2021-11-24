package hal.model;

public class Payment {

    private Long id;
    private Long personId;
    private Double income;
    private Double sum;
    private String status;

    public Payment() {
    }

    public Payment(Long id, Long personId, Double income, Double sum, String status) {
        this.id = id;
        this.personId = personId;
        this.income = income;
        this.sum = sum;
        this.status = status;
    }

    public Payment(Long personId, Double income, Double sum, String status) {
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

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
