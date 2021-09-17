package com.pay.payo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContractData implements Parcelable {

	@SerializedName("PAGE_ENVIRONMENT")
	@Expose
	private String pAGEENVIRONMENT;

	@SerializedName("JAVASCRIPT_INTEGRATION")
	@Expose
	private String jAVASCRIPTINTEGRATION;

	@SerializedName("PAGE_BUTTON_LOCALE")
	@Expose
	private String pAGEBUTTONLOCALE;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.pAGEENVIRONMENT);
		dest.writeString(this.jAVASCRIPTINTEGRATION);
		dest.writeString(this.pAGEBUTTONLOCALE);
	}

	public void readFromParcel(Parcel source) {
		this.pAGEENVIRONMENT = source.readString();
		this.jAVASCRIPTINTEGRATION = source.readString();
		this.pAGEBUTTONLOCALE = source.readString();
	}

	public ContractData() {
	}

	protected ContractData(Parcel in) {
		this.pAGEENVIRONMENT = in.readString();
		this.jAVASCRIPTINTEGRATION = in.readString();
		this.pAGEBUTTONLOCALE = in.readString();
	}

	public static final Parcelable.Creator<ContractData> CREATOR = new Parcelable.Creator<ContractData>() {
		@Override
		public ContractData createFromParcel(Parcel source) {
			return new ContractData(source);
		}

		@Override
		public ContractData[] newArray(int size) {
			return new ContractData[size];
		}
	};
}