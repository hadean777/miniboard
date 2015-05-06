package com.hadean777.miniboard.model;

import java.util.List;

public class Thread {
	
	private long uid;
	private String message;
	private List<Post> posts;
	
	/**
	 * Default constructor
	 */
	public Thread(){
	}
	
	/**
	 * Returns UID of Thread
	 * @return {@link long}
	 */
	public long getUid(){
		return uid;
	}
	
	/**
	 * Sets UID of Thread
	 * @param p_uid {@link long}
	 */
	public void setUid(long p_uid){
		uid = p_uid;
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
	public void setMessage(List<Post> p_posts){
		posts = p_posts;
	}

}
