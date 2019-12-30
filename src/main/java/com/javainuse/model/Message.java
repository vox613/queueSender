package com.javainuse.model;

//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employee.class)
public class Message {

	private String msgText;

	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	@Override
	public String toString() {
		return "Message [msg = " + msgText + " ]";
	}

}
