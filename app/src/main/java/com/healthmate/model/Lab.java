package com.example.heal_tech.model;

public class Lab {

    private String U_id;
    private String PackageName;
    private String Name,Address, MobileNo;
    private int ServiceCharge;

    private String Booked_date;
    private String Booked_time;

    public Lab() {}

    public String getU_id() {
        return U_id;
    }

    public void setU_id(String u_id) {
        U_id = u_id;
    }

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
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

    public int getServiceCharge() {
        return ServiceCharge;
    }

    public void setServiceCharge(int serviceCharge) {
        ServiceCharge = serviceCharge;
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

    public Lab(String u_id, String packageName, String name, String address, String mobileNo, int serviceCharge, String booked_date, String booked_time)
    {
        U_id=u_id;
        PackageName=packageName;
        Name=name;
        Address=address;
        ServiceCharge=serviceCharge;
        MobileNo=mobileNo;
        Booked_date=booked_date;
        Booked_time=booked_time;
    }

}
