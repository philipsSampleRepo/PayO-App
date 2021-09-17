package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Style implements Parcelable {

    @SerializedName("language")
    @Expose
    private String language;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.language);
    }

    public void readFromParcel(Parcel source) {
        this.language = source.readString();
    }

    public Style() {
    }

    protected Style(Parcel in) {
        this.language = in.readString();
    }

    public static final Parcelable.Creator<Style> CREATOR = new Parcelable.Creator<Style>() {
        @Override
        public Style createFromParcel(Parcel source) {
            return new Style(source);
        }

        @Override
        public Style[] newArray(int size) {
            return new Style[size];
        }
    };
}