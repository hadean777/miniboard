package com.hadean777.miniboard.persistence.dao;

import java.util.List;

import com.hadean777.miniboard.exception.DAOException;
import com.hadean777.miniboard.persistence.pojo.Thread;

public interface ThreadDAO extends GenericDAO<Thread, Long> {
	
	/**
	 * Returns list of all threads <br>
	 * 
	 * @return {@link List<Thread>}
	 */
    public List<Thread> getAllThreads() throws DAOException;

}
