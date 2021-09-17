package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class Networks implements Parcelable {

	@SerializedName("applicable")
	@Expose
	@Setter
	@Getter
	private List<ApplicableItem> applicable;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(this.applicable);
	}

	public void readFromParcel(Parcel source) {
		this.applicable = source.createTypedArrayList(ApplicableItem.CREATOR);
	}

	public Networks() {
	}

	protected Networks(Parcel in) {
		this.applicable = in.createTypedArrayList(ApplicableItem.CREATOR);
	}

	public static final Parcelable.Creator<Networks> CREATOR = new Parcelable.Creator<Networks>() {
		@Override
		public Networks createFromParcel(Parcel source) {
			return new Networks(source);
		}

		@Override
		public Networks[] newArray(int size) {
			return new Networks[size];
		}
	};
}