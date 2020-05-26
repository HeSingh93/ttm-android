package com.example.conf_booking.api.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GetCityEntity implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("name_en")
    private String nameEn;

    @SerializedName("topLocation")
    private String topLocation;

    @SerializedName("region")
    private String region;

    @SerializedName("county")
    private String county;

    @SerializedName("geoCoordinate")
    private int geoCoordinate;

    @SerializedName("title")
    private String title;

    @SerializedName("h1")
    private String h1;

    @SerializedName("seo_text")
    private String seoText;

    public GetCityEntity(){}

    protected GetCityEntity(Parcel in) {
        id = in.readInt();
        name = in.readString();
        nameEn = in.readString();
        topLocation = in.readString();
        region = in.readString();
        county = in.readString();
        geoCoordinate = in.readInt();
        title = in.readString();
        h1 = in.readString();
        seoText = in.readString();
    }

    public static final Creator<GetCityEntity> CREATOR = new Creator<GetCityEntity>() {
        @Override
        public GetCityEntity createFromParcel(Parcel in) {
            return new GetCityEntity(in);
        }

        @Override
        public GetCityEntity[] newArray(int size) {
            return new GetCityEntity[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getTopLocation() {
        return topLocation;
    }

    public String getRegion() {
        return region;
    }

    public String getCounty() {
        return county;
    }

    public int getGeoCoordinate() {
        return geoCoordinate;
    }

    public String getTitle() {
        return title;
    }

    public String getH1() {
        return h1;
    }

    public String getSeoText() {
        return seoText;
    }

    @Override
    public String toString() {
        return "GetCityEntity{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", English Name='" + nameEn + '\'' +
                ", topLocation='" + topLocation + '\'' +
                ", region='" + region + '\'' +
                ", county='" + county + '\'' +
                ", geoCoordinate=" + geoCoordinate +
                ", title='" + title + '\'' +
                ", h1='" + h1 + '\'' +
                ", seoText='" + seoText + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(nameEn);
        dest.writeString(topLocation);
        dest.writeString(region);
        dest.writeString(county);
        dest.writeInt(geoCoordinate);
        dest.writeString(title);
        dest.writeString(h1);
        dest.writeString(seoText);
    }


}
