package com.hadean777.miniboard.model;

import java.util.Date;
import java.util.List;

public class Thread {
	
	private Long uid;
	private String name;
	private String message;
	private String time;
	private List<Post> posts;
	private Date timestamp;
	
	/**
	 * Default constructor
	 */
	public Thread(){
	}
	
	/**
	 * Returns UID of Thread
	 * @return {@link Long}
	 */
	public Long getUid(){
		return uid;
	}
	
	/**
	 * Sets UID of Thread
	 * @param p_uid {@link Long}
	 */
	public void setUid(Long p_uid){
		uid = p_uid;
	}
	
	/**
	 * Returns name of Thread
	 * @return {@link String}
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets name of Thread
	 * @param p_name {@link String}
	 */
	public void setName(String p_name){
		name = p_name;
	}
	
	/**
	 * Returns message of Thread
	 * @return {@link String}
	 */
	public String getMessage(){
		return message;
	}
	
	/**
	 * Sets message of Thread
	 * @param p_message {@link String}
	 */
	public void setMessage(String p_message){
		message = p_message;
	}
	
	/**
	 * Returns time of Thread
	 * @return {@link String}
	 */
	public String getTime(){
		return time;
	}
	
	/**
	 * Sets time of Thread
	 * @param p_time {@link String}
	 */
	public void setTime(String p_time){
		time = p_time;
	}
	
	/**
	 * Returns posts of Thread
	 * @return {@link List<Post>}
	 */
	public List<Post> getPosts(){
		return posts;
	}
	
	/**
	 * Sets posts of Thread
	 * @param p_posts {@link List<Post>}
	 */
	public void setPosts(List<Post> p_posts){
		posts = p_posts;
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
