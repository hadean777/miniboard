package com.hadean777.miniboard.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadean777.miniboard.AppConstants;
import com.hadean777.miniboard.exception.DAOException;
import com.hadean777.miniboard.manager.ThreadManager;
import com.hadean777.miniboard.persistence.DaoFacade;
import com.hadean777.miniboard.model.Thread;

@Service(AppConstants.MANAGER_BEAN_THREAD_MANAGER)
public class ThreadManagerImpl implements ThreadManager {
	
	@Autowired
	private DaoFacade daoFacade;
	
	
	public Thread getThreadByUID(Long p_uid) throws DAOException{
		Thread thread = null;
		
		com.hadean777.miniboard.persistence.pojo.Thread pThread = daoFacade.getThreadDao().get(p_uid);
		
		if (pThread != null){
			thread = new Thread();
			thread.setUid(p_uid);
			thread.setMessage(pThread.getMessage());
//			thread.setPosts(pThread.getPosts());
		}
		
		return thread;
	}
	
	public Long saveThread(Thread p_thread) throws DAOException{
		Long threadUID = null;
		
		com.hadean777.miniboard.persistence.pojo.Thread pThread = new com.hadean777.miniboard.persistence.pojo.Thread();
		
		pThread.setUid(p_thread.getUid());
		pThread.setMessage(p_thread.getMessage());
//		pThread.setPosts(p_thread.getPosts());
		
		daoFacade.getThreadDao().saveOrUpdate(pThread);
		
		threadUID = pThread.getUid();
		
		return threadUID;
	}

}
