package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class ReturnCode implements Parcelable {

    @SerializedName("name")
    @Expose
    @Getter
    @Setter
    private String name;

    @SerializedName("source")
    @Expose
    @Getter
    @Setter
    private String source;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.source);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.source = source.readString();
    }

    public ReturnCode() {
    }

    protected ReturnCode(Parcel in) {
        this.name = in.readString();
        this.source = in.readString();
    }

    public static final Parcelable.Creator<ReturnCode> CREATOR = new Parcelable.Creator<ReturnCode>() {
        @Override
        public ReturnCode createFromParcel(Parcel source) {
            return new ReturnCode(source);
        }

        @Override
        public ReturnCode[] newArray(int size) {
            return new ReturnCode[size];
        }
    };
}