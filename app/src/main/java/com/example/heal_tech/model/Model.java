package com.example.heal_tech.model;
public class Model {

    String name,hospital, doctorType, mobileNo;

    Model(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }



    public Model(String name, String hospital, String doctorType, String mobileNo, String consultationFee) {
        this.name = name;
        this.hospital = hospital;
        this.doctorType = doctorType;
        this.mobileNo = mobileNo;
    }
}
