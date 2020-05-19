package com.example.conf_booking.api.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserEntity implements Parcelable {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("username")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("organization_name")
    private String orgName;

    @SerializedName("organization_nr")
    private String orgNumber;

    @SerializedName("street")
    private String street;

    @SerializedName("city_name")
    private String cityName;

    @SerializedName("zipCode")
    private String zipCode;

    //----- Constructors -----//
    public UserEntity() {
        // Empty no-args constructor
    }

    public UserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;



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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.userName);
        dest.writeString(this.password);
        dest.writeString(this.email);
        dest.writeString(this.phoneNumber);
        dest.writeString(this.orgName);
        dest.writeString(this.orgNumber);
        dest.writeString(this.street);
        dest.writeString(this.cityName);
        dest.writeString(this.zipCode);
    }

    protected UserEntity(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.userName = in.readString();
        this.password = in.readString();
        this.email = in.readString();
        this.phoneNumber = in.readString();
        this.orgName = in.readString();
        this.orgNumber = in.readString();
        this.street = in.readString();
        this.cityName = in.readString();
        this.zipCode = in.readString();
    }

    public static final Creator<UserEntity> CREATOR = new Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel source) {
            return new UserEntity(source);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };
}
