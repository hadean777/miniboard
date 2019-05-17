package com.hadean777.miniboard.persistence.dao;

import java.util.List;

import com.hadean777.miniboard.exception.DAOException;
import com.hadean777.miniboard.persistence.pojo.Post;

public interface PostDAO extends GenericDAO<Post, Long>  {
	
	/**
	 * Returns list of new posts of the thread <br>
	 * @param p_threadUid - UID of thread; {@link Post}
	 * @return {@link List<Post>}
	 */
    public List<Post> getNewPosts(Long p_threadUid, Long p_lastPostUid) throws DAOException;

}
