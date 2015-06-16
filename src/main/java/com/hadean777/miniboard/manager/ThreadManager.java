package com.hadean777.miniboard.manager;

import java.util.List;

import com.hadean777.miniboard.exception.BusinessLogicException;
import com.hadean777.miniboard.model.Post;
import com.hadean777.miniboard.model.Thread;


public interface ThreadManager {
	
	/**
	 * Returns Thread by id. <br>
	 * @param p_uid - uid of Thread; {@link Long}
	 * @return {@link Thread}
	 */
	public Thread getThreadByUID(Long p_uid) throws BusinessLogicException;
	
	/**
	 * Returns list of all threads <br>
	 * 
	 * @return {@link List<Thread>}
	 */
    public List<Thread> getAllThreads() throws BusinessLogicException;
	
	/**
	 * Save Thread to DB. <br>
	 * @param p_thread - Thread; {@link Thread}
	 * @return {@link Long}
	 */
	public Long saveThread(Thread p_thread) throws BusinessLogicException;
	
	/**
	 * Create new Thread. <br>
	 * @param p_thread - Thread; {@link Thread}
	 * @return {@link Long}
	 */
	public Long createNewThread(Thread p_thread) throws BusinessLogicException;
	
	/**
	 * Adds post to thread <br>
	 * @param p_post - Post; {@link Post}
	 * @return {@link Long}
	 */
	public Long addPost(Post p_post, Long p_threadUid) throws BusinessLogicException;
	
	/**
	 * Returns list of new posts of the thread <br>
	 * @param p_threadUid - UID of thread; {@link Long}
	 * @param p_lastPostUid - UID of the last post in thread {@link Long}
	 * @return {@link List<Post>}
	 */
	public List<Post> getNewPosts(Long p_threadUid, Long p_lastPostUid) throws BusinessLogicException;

}
