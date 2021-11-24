package hal.model;

public class Illness {

    private Long id;
    private Long personId;
    private String startDate;
    private String endDate;
    private String diagnosis;
    private String medicalDoctor;
    private String notes;

    public Illness() {
    }

    public Illness(Long id, Long personId, String startDate, String endDate, String diagnosis, String medicalDoctor, String notes) {
        this.id = id;
        this.personId = personId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.diagnosis = diagnosis;
        this.medicalDoctor = medicalDoctor;
        this.notes = notes;
    }

    public Illness(Long personId, String startDate, String endDate, String diagnosis, String medicalDoctor, String notes) {
        this.personId = personId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.diagnosis = diagnosis;
        this.medicalDoctor = medicalDoctor;
        this.notes = notes;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicalDoctor() {
        return medicalDoctor;
    }

    public void setMedicalDoctor(String medicalDoctor) {
        this.medicalDoctor = medicalDoctor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
