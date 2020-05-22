package com.example.conf_booking.api.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SearchResponseEntity implements Parcelable {

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private List<AvailabilityEntity> searchResult = new ArrayList<>();

    public SearchResponseEntity() {};

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AvailabilityEntity> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<AvailabilityEntity> searchResult) {
        this.searchResult = searchResult;
    }

    @Override
    public String toString() {
        return "SearchResponseEntity{" +
                "message='" + message + '\'' +
                ", searchResult=" + searchResult.toString() +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.message);
        dest.writeTypedList(this.searchResult);
    }

    protected SearchResponseEntity(Parcel in) {
        this.message = in.readString();
        this.searchResult = in.createTypedArrayList(AvailabilityEntity.CREATOR);
    }

    public static final Parcelable.Creator<SearchResponseEntity> CREATOR = new Parcelable.Creator<SearchResponseEntity>() {
        @Override
        public SearchResponseEntity createFromParcel(Parcel source) {
            return new SearchResponseEntity(source);
        }

        @Override
        public SearchResponseEntity[] newArray(int size) {
            return new SearchResponseEntity[size];
        }
    };
}
