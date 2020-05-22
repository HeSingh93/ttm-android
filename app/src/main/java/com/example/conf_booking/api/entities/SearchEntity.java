package com.example.conf_booking.api.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class SearchEntity implements Parcelable {

    @SerializedName("objectIds")
    private String objectId;

    @SerializedName("objectType")
    private String objectType;

    @SerializedName("fromDate")
    private String fromDate;

    @SerializedName("toDate")
    private String toDate;


    //----- Constructors -----//
    public SearchEntity() {
        // Empty no-args constructor
    }


    public SearchEntity(String objectId, String objectType, String fromDate, String toDate) {
        this.objectId = objectId;
        this.objectType = objectType;
        this.fromDate = fromDate;
        this. toDate = toDate;
    }


    @Override
    public String toString() {
        return "SearchEntity{" +
                "objectId='" + objectId + '\'' +
                ", objectType='" + objectType + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    protected SearchEntity(Parcel in) {
        this.objectId = in.readString();
        this.objectType = in.readString();
        this.fromDate = in.readString();
        this.toDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.objectId);
        dest.writeString(this.objectType);
        dest.writeString(this.fromDate);
        dest.writeString(this.toDate);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SearchEntity> CREATOR = new Creator<SearchEntity>() {
        @Override
        public SearchEntity createFromParcel(Parcel in) {
            return new SearchEntity(in);
        }

        @Override
        public SearchEntity[] newArray(int size) {
            return new SearchEntity[size];
        }
    };
}
