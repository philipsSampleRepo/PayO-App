package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Interaction implements Parcelable {

	@SerializedName("reason")
	@Expose
	private String reason;

	@SerializedName("code")
	@Expose
	private String code;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.reason);
		dest.writeString(this.code);
	}

	public void readFromParcel(Parcel source) {
		this.reason = source.readString();
		this.code = source.readString();
	}

	public Interaction() {
	}

	protected Interaction(Parcel in) {
		this.reason = in.readString();
		this.code = in.readString();
	}

	public static final Parcelable.Creator<Interaction> CREATOR = new Parcelable.Creator<Interaction>() {
		@Override
		public Interaction createFromParcel(Parcel source) {
			return new Interaction(source);
		}

		@Override
		public Interaction[] newArray(int size) {
			return new Interaction[size];
		}
	};
}