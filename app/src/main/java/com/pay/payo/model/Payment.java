package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payment implements Parcelable {

	@SerializedName("reference")
	@Expose
	private String reference;

	@SerializedName("amount")
	@Expose
	private int amount;

	@SerializedName("currency")
	@Expose
	private String currency;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.reference);
		dest.writeInt(this.amount);
		dest.writeString(this.currency);
	}

	public void readFromParcel(Parcel source) {
		this.reference = source.readString();
		this.amount = source.readInt();
		this.currency = source.readString();
	}

	public Payment() {
	}

	protected Payment(Parcel in) {
		this.reference = in.readString();
		this.amount = in.readInt();
		this.currency = in.readString();
	}

	public static final Parcelable.Creator<Payment> CREATOR = new Parcelable.Creator<Payment>() {
		@Override
		public Payment createFromParcel(Parcel source) {
			return new Payment(source);
		}

		@Override
		public Payment[] newArray(int size) {
			return new Payment[size];
		}
	};
}