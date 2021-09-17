package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identification implements Parcelable {

	@SerializedName("shortId")
	@Expose
	private String shortId;

	@SerializedName("longId")
	@Expose
	private String longId;

	@SerializedName("transactionId")
	@Expose
	private String transactionId;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.shortId);
		dest.writeString(this.longId);
		dest.writeString(this.transactionId);
	}

	public void readFromParcel(Parcel source) {
		this.shortId = source.readString();
		this.longId = source.readString();
		this.transactionId = source.readString();
	}

	public Identification() {
	}

	protected Identification(Parcel in) {
		this.shortId = in.readString();
		this.longId = in.readString();
		this.transactionId = in.readString();
	}

	public static final Parcelable.Creator<Identification> CREATOR = new Parcelable.Creator<Identification>() {
		@Override
		public Identification createFromParcel(Parcel source) {
			return new Identification(source);
		}

		@Override
		public Identification[] newArray(int size) {
			return new Identification[size];
		}
	};
}