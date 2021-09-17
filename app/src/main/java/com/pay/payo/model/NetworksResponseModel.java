package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

@Entity(tableName = "payment_info")
public class NetworksResponseModel implements Parcelable {

    @SerializedName("resultCode")
    @Expose
    @PrimaryKey
    @NonNull
    @Setter
    @Getter
    public String resultCode;

    @SerializedName("networks")
    @Expose
    @ColumnInfo(name = "networks")
    @Getter
    @Setter
    public Networks networks;

    @SerializedName("resultInfo")
    @Expose
    @ColumnInfo(name = "resultInfo")
    @Getter
    @Setter
    public String resultInfo;

    @SerializedName("returnCode")
    @Expose
    @ColumnInfo(name = "returnCode")
    @Getter
    @Setter
    public ReturnCode returnCode;

    @SerializedName("identification")
    @Expose
    @ColumnInfo(name = "identification")
    @Getter
    @Setter
    public Identification identification;

    @SerializedName("integrationType")
    @Expose
    @ColumnInfo(name = "integrationType")
    @Getter
    @Setter
    public String integrationType;

    @SerializedName("interaction")
    @Expose
    @ColumnInfo(name = "interaction")
    @Getter
    @Setter
    public Interaction interaction;

    @SerializedName("links")
    @Expose
    @ColumnInfo(name = "links")
    @Getter
    @Setter
    public Links links;

    @SerializedName("operationType")
    @Expose
    @ColumnInfo(name = "operationType")
    @Getter
    @Setter
    public String operationType;

    @SerializedName("style")
    @Expose
    @ColumnInfo(name = "style")
    @Getter
    @Setter
    public Style style;

    @SerializedName("payment")
    @Expose
    @ColumnInfo(name = "payment")
    @Getter
    @Setter
    public Payment payment;

    @SerializedName("operation")
    @Expose
    @ColumnInfo(name = "operation")
    @Getter
    @Setter
    public String operation;

    @SerializedName("timestamp")
    @Expose
    @ColumnInfo(name = "timestamp")
    @Getter
    @Setter
    public String timestamp;

    @SerializedName("status")
    @Expose
    @ColumnInfo(name = "status")
    @Getter
    @Setter
    public Status status;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resultCode);
        dest.writeParcelable(this.networks, flags);
        dest.writeString(this.resultInfo);
        dest.writeParcelable(this.returnCode, flags);
        dest.writeParcelable(this.identification, flags);
        dest.writeString(this.integrationType);
        dest.writeParcelable(this.interaction, flags);
        dest.writeParcelable(this.links, flags);
        dest.writeString(this.operationType);
        dest.writeParcelable(this.style, flags);
        dest.writeParcelable(this.payment, flags);
        dest.writeString(this.operation);
        dest.writeString(this.timestamp);
        dest.writeParcelable(this.status, flags);
    }

    public void readFromParcel(Parcel source) {
        this.resultCode = source.readString();
        this.networks = source.readParcelable(Networks.class.getClassLoader());
        this.resultInfo = source.readString();
        this.returnCode = source.readParcelable(ReturnCode.class.getClassLoader());
        this.identification = source.readParcelable(Identification.class.getClassLoader());
        this.integrationType = source.readString();
        this.interaction = source.readParcelable(Interaction.class.getClassLoader());
        this.links = source.readParcelable(Links.class.getClassLoader());
        this.operationType = source.readString();
        this.style = source.readParcelable(Style.class.getClassLoader());
        this.payment = source.readParcelable(Payment.class.getClassLoader());
        this.operation = source.readString();
        this.timestamp = source.readString();
        this.status = source.readParcelable(Status.class.getClassLoader());
    }

    public NetworksResponseModel() {
    }

    protected NetworksResponseModel(Parcel in) {
        this.resultCode = in.readString();
        this.networks = in.readParcelable(Networks.class.getClassLoader());
        this.resultInfo = in.readString();
        this.returnCode = in.readParcelable(ReturnCode.class.getClassLoader());
        this.identification = in.readParcelable(Identification.class.getClassLoader());
        this.integrationType = in.readString();
        this.interaction = in.readParcelable(Interaction.class.getClassLoader());
        this.links = in.readParcelable(Links.class.getClassLoader());
        this.operationType = in.readString();
        this.style = in.readParcelable(Style.class.getClassLoader());
        this.payment = in.readParcelable(Payment.class.getClassLoader());
        this.operation = in.readString();
        this.timestamp = in.readString();
        this.status = in.readParcelable(Status.class.getClassLoader());
    }

    public static final Parcelable.Creator<NetworksResponseModel> CREATOR = new Parcelable.Creator<NetworksResponseModel>() {
        @Override
        public NetworksResponseModel createFromParcel(Parcel source) {
            return new NetworksResponseModel(source);
        }

        @Override
        public NetworksResponseModel[] newArray(int size) {
            return new NetworksResponseModel[size];
        }
    };
}