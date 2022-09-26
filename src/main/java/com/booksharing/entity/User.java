package com.booksharing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + ", value=" + value + ", favbooks=" + favbooks + ", favsongs=" + favsongs
				+ ", favplaces=" + favplaces + ", profilephoto=" + profilephoto + "]";
	}

	@Column(name = "username")
	private String userName;
	private String email;
	private String password;
	private String fullName;
	@Value("true")
	private boolean value;
	private String favbooks;
	private String favsongs;
	private String favplaces;
	private String profilephoto = "Default.png";

	public User(String fullName, String userName, String email, String password, boolean value, String favbooks,
			String favsongs, String favplaces, String profilephoto) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.value = value;
		this.favbooks = favbooks;
		this.favsongs = favsongs;
		this.favplaces = favplaces;
		this.profilephoto = profilephoto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFavbooks() {
		return favbooks;
	}

	public void setFavbooks(String favbooks) {
		this.favbooks = favbooks;
	}

	public String getFavsongs() {
		return favsongs;
	}

	public void setFavsongs(String favsongs) {
		this.favsongs = favsongs;
	}

	public String getFavplaces() {
		return favplaces;
	}

	public void setFavplaces(String favplaces) {
		this.favplaces = favplaces;
	}

	public String getProfilephoto() {
		return profilephoto;
	}

	public void setProfilephoto(String profilephoto) {
		this.profilephoto = profilephoto;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String fullName, String userName, String email, String password, boolean value) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.value = value;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
