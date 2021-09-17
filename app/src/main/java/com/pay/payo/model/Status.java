package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status implements Parcelable {

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

	public Status() {
	}

	protected Status(Parcel in) {
		this.reason = in.readString();
		this.code = in.readString();
	}

	public static final Parcelable.Creator<Status> CREATOR = new Parcelable.Creator<Status>() {
		@Override
		public Status createFromParcel(Parcel source) {
			return new Status(source);
		}

		@Override
		public Status[] newArray(int size) {
			return new Status[size];
		}
	};
}