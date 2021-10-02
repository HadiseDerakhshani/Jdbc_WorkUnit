package maktab58.practice_1.model;

public class WorkUnit {
    private int idUnit;
    private String nameUnit;
    private String phoneNumber;


    public WorkUnit() {
    }
    public WorkUnit(String nameUnit, String phoneNumber) {
        this.nameUnit = nameUnit;
        this.phoneNumber = phoneNumber;

    }
    public WorkUnit(int idUnit, String nameUnit, String phoneNumber) {
        this.idUnit = idUnit;
        this.nameUnit = nameUnit;
        this.phoneNumber = phoneNumber;
    }
    public int getIdUnit() {
        return idUnit;
    }
    public void setIdUnit(int idUnit) {
        this.idUnit = idUnit;
    }
    public String getNameUnit() {
        return nameUnit;
    }
    public void setNameUnit(String nameUnit) {
        this.nameUnit = nameUnit;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
