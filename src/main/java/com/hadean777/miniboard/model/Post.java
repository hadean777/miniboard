package com.hadean777.miniboard.model;

public class Post {
	
	private long uid;
	private String message;
	
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

}
