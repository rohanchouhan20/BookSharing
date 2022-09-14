package com.booksharing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Component
@Entity
@Table(name = "Requests")
public class Requests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "reciever")
	private int reciever;

	@OneToOne
	@JoinColumn(name = "sender")
	private User sender;

	@Column(name = "accepted")
	private boolean accepted;

	private boolean followBack;

	public int getReciever() {
		return reciever;
	}

	public void setReciever(int reciever) {
		this.reciever = reciever;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean getFollowBack() {
		return followBack;
	}

	@Override
	public String toString() {
		return "Requests [id=" + id + ", reciever=" + reciever + ", sender=" + sender + ", accepted=" + accepted
				+ ", followBack=" + followBack + "]";
	}

	public void setFollowBack(boolean followBack) {
		this.followBack = followBack;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
