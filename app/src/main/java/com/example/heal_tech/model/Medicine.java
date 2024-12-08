package com.example.heal_tech.model;

public class Medicine {
    private String U_id;
    private String MedicalIssue;
    private String Name,Address, MobileNo;
    private String Rating;

    private String Booked_date;
    private String Booked_time;

    public Medicine(){}

    public String getU_id() {
        return U_id;
    }

    public void setU_id(String u_id) {
        U_id = u_id;
    }

    public String getMedicalIssue() {
        return MedicalIssue;
    }

    public void setMedicalIssue(String medicalIssue) {
        MedicalIssue = medicalIssue;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getBooked_date() {
        return Booked_date;
    }

    public void setBooked_date(String booked_date) {
        Booked_date = booked_date;
    }

    public String getBooked_time() {
        return Booked_time;
    }

    public void setBooked_time(String booked_time) {
        Booked_time = booked_time;
    }

    public Medicine(String u_id, String medicalIssue, String name, String address, String mobileNo, String rating, String booked_date, String booked_time)
    {
        U_id=u_id;
        MedicalIssue=medicalIssue;
        Name=name;
        Address=address;
        Rating=rating;
        MobileNo=mobileNo;
        Booked_date=booked_date;
        Booked_time=booked_time;
    }
}