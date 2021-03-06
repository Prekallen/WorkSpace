package com.iot1.sql.vendor.dto;

import org.springframework.stereotype.Component;

@Component
public class VendorInfo {
	private int viNum;
	private String viName;
	private String viDesc;
	private String viAddress;
	private String viPhone;
	private String viCreDat;
	private String viCreTim;
	public int getViNum() {
		return viNum;
	}
	public void setViNum(int viNum) {
		this.viNum = viNum;
	}
	public String getViName() {
		return viName;
	}
	public void setViName(String viName) {
		this.viName = viName;
	}
	@Override
	public String toString() {
		return "VendorInfo [viNum=" + viNum + ", viName=" + viName + ", viDesc=" + viDesc + ", viAddress=" + viAddress
				+ ", viPhone=" + viPhone + ", viCreDat=" + viCreDat + ", viCreTim=" + viCreTim + "]";
	}
	public String getViDesc() {
		return viDesc;
	}
	public void setViDesc(String viDesc) {
		this.viDesc = viDesc;
	}
	public String getViAddress() {
		return viAddress;
	}
	public void setViAddress(String viAddress) {
		this.viAddress = viAddress;
	}
	public String getViPhone() {
		return viPhone;
	}
	public void setViPhone(String viPhone) {
		this.viPhone = viPhone;
	}
	public String getViCreDat() {
		return viCreDat;
	}
	public void setViCreDat(String viCreDat) {
		this.viCreDat = viCreDat;
	}
	public String getViCreTim() {
		return viCreTim;
	}
	public void setViCreTim(String viCreTim) {
		this.viCreTim = viCreTim;
	}
}
