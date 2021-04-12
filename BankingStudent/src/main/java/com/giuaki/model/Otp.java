package com.giuaki.model;

public class Otp {
	private  Long id;
	private  Long id_pay;
	private  int status;
	private  Long iduserpay;
	private  Long[] ids;
	private  int otp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_pay() {
		return id_pay;
	}
	public void setId_pay(Long id_pay) {
		this.id_pay = id_pay;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getIduserpay() {
		return iduserpay;
	}
	public void setIduserpay(Long iduserpay) {
		this.iduserpay = iduserpay;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	
}
