package com.hadean777.miniboard.manager;

import com.hadean777.miniboard.exception.DAOException;
import com.hadean777.miniboard.model.Thread;


public interface ThreadManager {
	
	/**
	 * Returns Thread by id. <br>
	 * @param p_uid - uid of Thread; {@link Long}
	 * @return {@link Thread}
	 */
	public Thread getThreadByUID(Long p_uid) throws DAOException;
	
	/**
	 * Save Thread to DB. <br>
	 * @param p_thread - Thread; {@link Thread}
	 * @return {@link Long}
	 */
	public Long saveThread(Thread p_thread) throws DAOException;

}
