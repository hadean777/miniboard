package com.hadean777.miniboard.persistence.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "THREADS")
@SequenceGenerator(name = "TOTAL_SEQ", sequenceName = "TOTAL_SEQ")
public class Thread implements Serializable {
	
	private static final long serialVersionUID = -834624019241168991L;

	@Id
	@GeneratedValue(generator="TOTAL_SEQ")
	@Column(name = "THREAD_UID", nullable = false)
	private Long uid;
	
	@Column(name = "MESSAGE")
	private String message;
	
	@OrderBy("POST_UID")
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "thread", fetch = FetchType.LAZY)
	private List<Post> posts;
	
	@Column(name = "ADDED_TS", insertable = false, updatable = false)
	private Timestamp  addedTS;
	
	@Column(name = "MODIFIED_TS", insertable = false, updatable = false)
	private Timestamp  modifiedTS;
	
	
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
	public void setPosts(List<Post> p_posts){
		posts = p_posts;
	}
	
	/**
	 * Returns added TS of Thread
	 * @return {@link Timestamp}
	 */
	public Timestamp getAddedTS() {
		return addedTS;
	}
	
	/**
	 * Returns modified TS of Thread
	 * @return {@link Timestamp}
	 */
	public Timestamp getModifiedTS() {
		return modifiedTS;
	}

}
