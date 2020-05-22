package com.example.conf_booking.api.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AvailabilityEntity implements Parcelable {

    @SerializedName("fullDayPrice")
    private String fullDayPrice;

    @SerializedName("preNoonPrice")
    private String morningPrice;

    @SerializedName("afternoonPrice")
    private String afternoonPrice;

    @SerializedName("start")
    private String startDate;

    @SerializedName("id31")
    private int bookedMorning;

    @SerializedName("id32")
    private int bookedAfternoon;

    @SerializedName("room_id")
    private int roomId;

    @SerializedName("plant_id")
    private int facilityId;

    @SerializedName("org_id")
    private int organizationId;

    @SerializedName("city_id")
    private int cityId;

    public AvailabilityEntity() {}

    public String getFullDayPrice() {
        return fullDayPrice;
    }

    public void setFullDayPrice(String fullDayPrice) {
        this.fullDayPrice = fullDayPrice;
    }

    public String getMorningPrice() {
        return morningPrice;
    }

    public void setMorningPrice(String morningPrice) {
        this.morningPrice = morningPrice;
    }

    public String getAfternoonPrice() {
        return afternoonPrice;
    }

    public void setAfternoonPrice(String afternoonPrice) {
        this.afternoonPrice = afternoonPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getBookedMorning() {
        return bookedMorning;
    }

    public void setBookedMorning(int bookedMorning) {
        this.bookedMorning = bookedMorning;
    }

    public int getBookedAfternoon() {
        return bookedAfternoon;
    }

    public void setBookedAfternoon(int bookedAfternoon) {
        this.bookedAfternoon = bookedAfternoon;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "AvailabilityEntity{" +
                "fullDayPrice='" + fullDayPrice + '\'' +
                ", morningPrice='" + morningPrice + '\'' +
                ", afternoonPrice='" + afternoonPrice + '\'' +
                ", startDate='" + startDate + '\'' +
                ", bookedMorning=" + bookedMorning +
                ", bookedAfternoon=" + bookedAfternoon +
                ", roomId=" + roomId +
                ", facilityId=" + facilityId +
                ", organizationId=" + organizationId +
                ", cityId=" + cityId +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fullDayPrice);
        dest.writeString(this.morningPrice);
        dest.writeString(this.afternoonPrice);
        dest.writeString(this.startDate);
        dest.writeInt(this.bookedMorning);
        dest.writeInt(this.bookedAfternoon);
        dest.writeInt(this.roomId);
        dest.writeInt(this.facilityId);
        dest.writeInt(this.organizationId);
        dest.writeInt(this.cityId);
    }

    protected AvailabilityEntity(Parcel in) {
        this.fullDayPrice = in.readString();
        this.morningPrice = in.readString();
        this.afternoonPrice = in.readString();
        this.startDate = in.readString();
        this.bookedMorning = in.readInt();
        this.bookedAfternoon = in.readInt();
        this.roomId = in.readInt();
        this.facilityId = in.readInt();
        this.organizationId = in.readInt();
        this.cityId = in.readInt();
    }

    public static final Parcelable.Creator<AvailabilityEntity> CREATOR = new Parcelable.Creator<AvailabilityEntity>() {
        @Override
        public AvailabilityEntity createFromParcel(Parcel source) {
            return new AvailabilityEntity(source);
        }

        @Override
        public AvailabilityEntity[] newArray(int size) {
            return new AvailabilityEntity[size];
        }
    };
}
