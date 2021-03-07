package com.cestar.model;

public class Client {


	private int ClientID;
	private String Contact;
	private String ItemShipped;
	private String Date_Recieved;
	private String Date_Shipped;
	public int getClientID() {
		return ClientID;
	}
	public void setClientID(int clientID) {
		ClientID = clientID;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getItemShipped() {
		return ItemShipped;
	}
	public void setItemShipped(String itemShipped) {
		ItemShipped = itemShipped;
	}
	public String getDate_Recieved() {
		return Date_Recieved;
	}
	public void setDate_Recieved(String date_Recieved) {
		Date_Recieved = date_Recieved;
	}
	public String getDate_Shipped() {
		return Date_Shipped;
	}
	public void setDate_Shipped(String date_Shipped) {
		Date_Shipped = date_Shipped;

	}
	public Client(int clientID, String contact, String itemShipped, String date_Recieved, String date_Shipped) {
		super();
		ClientID = clientID;
		Contact = contact;
		ItemShipped = itemShipped;
		Date_Recieved = date_Recieved;
		Date_Shipped = date_Shipped;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Client [ClientID=" + ClientID + ", Contact=" + Contact + ", ItemShipped=" + ItemShipped
				+ ", Date_Recieved=" + Date_Recieved + ", Date_Shipped=" + Date_Shipped + "]";
	}
	
}

