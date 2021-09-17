package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class Links implements Parcelable {

    @SerializedName("self")
    @Expose
    private String self;

    @SerializedName("lang")
    @Expose
    private String lang;

    @SerializedName("logo")
    @Expose
    @Getter
    @Setter
    private String logo;

    @SerializedName("operation")
    @Expose
    private String operation;

    @SerializedName("validation")
    @Expose
    private String validation;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.self);
        dest.writeString(this.lang);
        dest.writeString(this.logo);
        dest.writeString(this.operation);
        dest.writeString(this.validation);
    }

    public void readFromParcel(Parcel source) {
        this.self = source.readString();
        this.lang = source.readString();
        this.logo = source.readString();
        this.operation = source.readString();
        this.validation = source.readString();
    }

    public Links() {
    }

    protected Links(Parcel in) {
        this.self = in.readString();
        this.lang = in.readString();
        this.logo = in.readString();
        this.operation = in.readString();
        this.validation = in.readString();
    }

    public static final Parcelable.Creator<Links> CREATOR = new Parcelable.Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel source) {
            return new Links(source);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };
}