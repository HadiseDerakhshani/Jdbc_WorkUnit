package maktab58.practice_1.model;

import java.sql.Date;

public class Employee {
    private int id;
    private String nameEmploy;
    private String familyEmploy;
    private int idPersonnel = 1000;
    private Date dateBirth;
    private WorkUnit workUnit;

    public Employee() {
    }
    public Employee(String nameEmploy, String familyEmploy, Date dateBirth, WorkUnit workUnit) {
        this.nameEmploy = nameEmploy;
        this.familyEmploy = familyEmploy;
        this.dateBirth = dateBirth;
        this.workUnit = workUnit;
    }
    public Employee(int id, String nameEmploy, String familyEmploy, int idPersonnel, Date dateBirth) {
        this.id = id;
        this.nameEmploy = nameEmploy;
        this.familyEmploy = familyEmploy;
        this.idPersonnel = idPersonnel;
        this.dateBirth = dateBirth;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameEmploy() {
        return nameEmploy;
    }
    public void setNameEmploy(String nameEmploy) {
        this.nameEmploy = nameEmploy;
    }
    public String getFamilyEmploy() {
        return familyEmploy;
    }
    public void setFamilyEmploy(String familyEmploy) {
        this.familyEmploy = familyEmploy;
    }
    public int getIdPersonnel() {
        return idPersonnel;
    }
    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }
    public Date getDateBirth() {
        return dateBirth;
    }
    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }
    public WorkUnit getWorkUnit() {
        return workUnit;
    }
    public void setWorkUnit(WorkUnit workUnit) {
        this.workUnit = workUnit;
    }
}
