package com.hadean777.miniboard.persistence.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "POSTS")
@SequenceGenerator(name = "TOTAL_SEQ", sequenceName = "TOTAL_SEQ")
public class Post implements Serializable {
	
	private static final long serialVersionUID = -8201830392031508449L;

	@Id
	@GeneratedValue(generator="TOTAL_SEQ")
	@Column(name = "POST_UID", nullable = false)
	private Long uid;
	
	@ManyToOne
	@JoinColumn(name = "THREAD_UID", nullable = false)
	private Thread thread;
	
	@Column(name = "NAME")
	private String name;
	
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
	 * Returns thread of Post
	 * @return {@link Thread}
	 */
	public Thread getThread(){
		return thread;
	}
	
	/**
	 * Sets thread of Post
	 * @param p_thread {@link Thread}
	 */
	public void setThread(Thread p_thread){
		thread = p_thread;
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
