package com.example.heal_tech.model;

public class Doctor
{
    private String U_id;
    private String doctorType;
    private String Name,Hospital,MobileNo;
    private int ConsultationFee;
    private String booked_date;
    private String booked_time;

    public Doctor(){}
    public String getU_id() {
        return U_id;
    }

    public void setU_id(String u_id) {
        U_id = u_id;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHospital() {
        return Hospital;
    }

    public void setHospital(String hospital) {
        Hospital = hospital;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public int getConsultationFee() {
        return ConsultationFee;
    }

    public void setConsultationFee(int consultationFee) {
        ConsultationFee = consultationFee;
    }

    public String getBooked_date() {
        return booked_date;
    }

    public void setBooked_date(String booked_date) {
        this.booked_date = booked_date;
    }

    public String getBooked_time() {
        return booked_time;
    }

    public void setBooked_time(String booked_time) {
        this.booked_time = booked_time;
    }

    public Doctor(String u_id, String doctorType, String name, String hospital, String mobileNo, int consultationFee, String booked_date, String booked_time) {
        U_id = u_id;
        this.doctorType = doctorType;
        Name = name;
        Hospital = hospital;
        MobileNo = mobileNo;
        ConsultationFee = consultationFee;
        this.booked_date = booked_date;
        this.booked_time = booked_time;
    }
}
