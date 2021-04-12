package com.giuaki.model;

public class History {
	private  Long id;
	private  String fullname_pay;
	private  String fullname_receive;
	private  Long id_pay;
	private  Long id_receive;
	private  int moneytopaid;
	private Long[] ids;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname_pay() {
		return fullname_pay;
	}
	public void setFullname_pay(String fullname_pay) {
		this.fullname_pay = fullname_pay;
	}
	public String getFullname_receive() {
		return fullname_receive;
	}
	public void setFullname_receive(String fullname_receive) {
		this.fullname_receive = fullname_receive;
	}
	public Long getId_pay() {
		return id_pay;
	}
	public void setId_pay(Long id_pay) {
		this.id_pay = id_pay;
	}
	public Long getId_receive() {
		return id_receive;
	}
	public void setId_receive(Long id_receive) {
		this.id_receive = id_receive;
	}
	public int getMoneytopaid() {
		return moneytopaid;
	}
	public void setMoneytopaid(int moneytopaid) {
		this.moneytopaid = moneytopaid;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	
}
