package com.hadean777.miniboard.model;

import java.util.Date;

public class Post {
	
	private Long uid;
	private String name;
	private String message;
	private String time;
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
	 * Returns name of Post
	 * @return {@link String}
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets name of Post
	 * @param p_name {@link String}
	 */
	public void setName(String p_name){
		name = p_name;
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
	 * @param p_message {@link String}
	 */
	public void setMessage(String p_message){
		message = p_message;
	}
	
	/**
	 * Returns time of Post
	 * @return {@link String}
	 */
	public String getTime(){
		return time;
	}
	
	/**
	 * Sets time of Post
	 * @param p_time {@link String}
	 */
	public void setTime(String p_time){
		time = p_time;
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
