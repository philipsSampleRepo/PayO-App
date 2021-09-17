package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class ApplicableItem implements Parcelable {

    @SerializedName("recurrence")
    @Expose
    @Setter
    @Getter
    public String recurrence;

    @SerializedName("redirect")
    @Expose
    @Setter
    @Getter
    public boolean redirect;

    @SerializedName("code")
    @Expose
    @Setter
    @Getter
    public String code;

    @SerializedName("method")
    @Expose
    @Setter
    @Getter
    public String method;

    @SerializedName("registration")
    @Expose
    @Setter
    @Getter
    public String registration;

    @SerializedName("links")
    @Expose
    @Setter
    @Getter
    public Links links;

    @SerializedName("operationType")
    @Expose
    @Setter
    @Getter
    public String operationType;

    @SerializedName("label")
    @Expose
    @Setter
    @Getter
    public String label;

    @SerializedName("grouping")
    @Expose
    @Setter
    @Getter
    public String grouping;

    @SerializedName("selected")
    @Expose
    @Setter
    @Getter
    public boolean selected;

    @SerializedName("inputElements")
    @Expose
    @Setter
    @Getter
    public List<InputElementsItem> inputElements;

    @SerializedName("contractData")
    @Expose
    @Setter
    @Getter
    public ContractData contractData;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.recurrence);
        dest.writeByte(this.redirect ? (byte) 1 : (byte) 0);
        dest.writeString(this.code);
        dest.writeString(this.method);
        dest.writeString(this.registration);
        dest.writeParcelable(this.links, flags);
        dest.writeString(this.operationType);
        dest.writeString(this.label);
        dest.writeString(this.grouping);
        dest.writeByte(this.selected ? (byte) 1 : (byte) 0);
        dest.writeList(this.inputElements);
        dest.writeParcelable(this.contractData, flags);
    }

    public void readFromParcel(Parcel source) {
        this.recurrence = source.readString();
        this.redirect = source.readByte() != 0;
        this.code = source.readString();
        this.method = source.readString();
        this.registration = source.readString();
        this.links = source.readParcelable(Links.class.getClassLoader());
        this.operationType = source.readString();
        this.label = source.readString();
        this.grouping = source.readString();
        this.selected = source.readByte() != 0;
        this.inputElements = new ArrayList<InputElementsItem>();
        source.readList(this.inputElements, InputElementsItem.class.getClassLoader());
        this.contractData = source.readParcelable(ContractData.class.getClassLoader());
    }

    public ApplicableItem() {
    }

    protected ApplicableItem(Parcel in) {
        this.recurrence = in.readString();
        this.redirect = in.readByte() != 0;
        this.code = in.readString();
        this.method = in.readString();
        this.registration = in.readString();
        this.links = in.readParcelable(Links.class.getClassLoader());
        this.operationType = in.readString();
        this.label = in.readString();
        this.grouping = in.readString();
        this.selected = in.readByte() != 0;
        this.inputElements = new ArrayList<InputElementsItem>();
        in.readList(this.inputElements, InputElementsItem.class.getClassLoader());
        this.contractData = in.readParcelable(ContractData.class.getClassLoader());
    }

    public static final Parcelable.Creator<ApplicableItem> CREATOR = new Parcelable.Creator<ApplicableItem>() {
        @Override
        public ApplicableItem createFromParcel(Parcel source) {
            return new ApplicableItem(source);
        }

        @Override
        public ApplicableItem[] newArray(int size) {
            return new ApplicableItem[size];
        }
    };
}