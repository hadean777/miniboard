package com.hadean777.miniboard.model;

import java.util.Date;

public class Post {
	
	private Long uid;
	private String message;
	private Date timestamp;
	
	/**
	 * Default constructor
	 */
	public Post(){
	}
	
	/**
	 * Returns UID of Post
	 * @return {@link Long}
	 */
	public Long getUid(){
		return uid;
	}
	
	/**
	 * Sets UID of Post
	 * @param p_uid {@link Long}
	 */
	public void setUid(Long p_uid){
		uid = p_uid;
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
	 * Returns timestamp of Post
	 * @return {@link Date}
	 */
	public Date getTimestamp(){
		return timestamp;
	}
	
	/**
	 * Sets timestamp of Post
	 * @param p_timestamp {@link Date}
	 */
	public void setTimestamp(Date p_timestamp){
		timestamp = p_timestamp;
	}

}
