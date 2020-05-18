package com.example.conf_booking.api.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TokenEntity implements Parcelable {

    @SerializedName("token")
    private String tokenString;

    public TokenEntity() {};

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tokenString);
    }

    protected TokenEntity(Parcel in) {
        this.tokenString = in.readString();
    }

    public static final Parcelable.Creator<TokenEntity> CREATOR = new Parcelable.Creator<TokenEntity>() {
        @Override
        public TokenEntity createFromParcel(Parcel source) {
            return new TokenEntity(source);
        }

        @Override
        public TokenEntity[] newArray(int size) {
            return new TokenEntity[size];
        }
    };
}
