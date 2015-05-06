package com.hadean777.miniboard.persistence.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Post implements Serializable {
	
	@Id
	@GeneratedValue(generator="TOTAL_SEQ")
	@Column(name = "POST_UID", nullable = false)
	private long uid;
	
	//TODO: replace long with Thread entity
	private long threadUid;
	
	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "ADDED_TS", insertable = false, updatable = false)
	private Timestamp  addedTS;
	
	@Column(name = "MODIFIED_TS", insertable = false, updatable = false)
	private Timestamp  modifiedTS;
	
	/**
	 * Default constructor
	 */
	public Post(){
	}
	
	/**
	 * Returns UID of Post
	 * @return {@link long}
	 */
	public long getUid(){
		return uid;
	}
	
	/**
	 * Sets UID of Post
	 * @param p_uid {@link long}
	 */
	public void setUid(long p_uid){
		uid = p_uid;
	}
	
	/**
	 * Returns threadUid of Post
	 * @return {@link long}
	 */
	public long getThreadUid(){
		return threadUid;
	}
	
	/**
	 * Sets threadUid of Post
	 * @param p_uid {@link long}
	 */
	public void setThreadUid(long p_threadUid){
		threadUid = p_threadUid;
	}
	
	/**
	 * Returns message of Post
	 * @return {@link String}
	 */
	public String getMessage(){
		return message;
	}
	
	/**
	 * Sets message of Post
	 * @param p_uid {@link String}
	 */
	public void setMessage(String p_message){
		message = p_message;
	}
	
	/**
	 * Returns added TS of Post
	 * @return {@link Timestamp}
	 */
	public Timestamp getAddedTS() {
		return addedTS;
	}
	
	/**
	 * Returns modified TS of Post
	 * @return {@link Timestamp}
	 */
	public Timestamp getModifiedTS() {
		return modifiedTS;
	}

}
