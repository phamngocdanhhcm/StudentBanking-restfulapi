package com.giuaki.model;

public class Pay {
	private  Long id;
	private  Long id_ifuser;
	private  int moneytopaid;
	private  int status;
	private  Long[] ids;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_ifuser() {
		return id_ifuser;
	}
	public void setId_ifuser(Long id_ifuser) {
		this.id_ifuser = id_ifuser;
	}
	public int getMoneytopaid() {
		return moneytopaid;
	}
	public void setMoneytopaid(int moneytopaid) {
		this.moneytopaid = moneytopaid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	
	
}
