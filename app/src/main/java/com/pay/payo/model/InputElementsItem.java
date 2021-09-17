package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class InputElementsItem implements Parcelable {

	@SerializedName("name")
	@Expose
	@Getter
	@Setter
	public String name;

	@SerializedName("type")
	@Expose
	private String type;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeString(this.type);
	}

	public void readFromParcel(Parcel source) {
		this.name = source.readString();
		this.type = source.readString();
	}

	public InputElementsItem() {
	}

	protected InputElementsItem(Parcel in) {
		this.name = in.readString();
		this.type = in.readString();
	}

	public static final Parcelable.Creator<InputElementsItem> CREATOR = new Parcelable.Creator<InputElementsItem>() {
		@Override
		public InputElementsItem createFromParcel(Parcel source) {
			return new InputElementsItem(source);
		}

		@Override
		public InputElementsItem[] newArray(int size) {
			return new InputElementsItem[size];
		}
	};
}