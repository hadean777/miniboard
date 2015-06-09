package com.hadean777.miniboard.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadean777.miniboard.AppConstants;
import com.hadean777.miniboard.exception.BusinessLogicException;
import com.hadean777.miniboard.exception.DAOException;
import com.hadean777.miniboard.manager.ThreadManager;
import com.hadean777.miniboard.manager.TextConverterService;
import com.hadean777.miniboard.persistence.DaoFacade;
import com.hadean777.miniboard.model.Thread;
import com.hadean777.miniboard.model.Post;

@Service(AppConstants.MANAGER_BEAN_THREAD_MANAGER)
public class ThreadManagerImpl implements ThreadManager {
	
	@Autowired
	private DaoFacade daoFacade;
	
	@Autowired
	private TextConverterService tcs;
	
	
	public Thread getThreadByUID(Long p_uid) throws BusinessLogicException{
		Thread thread = null;
		try {
			com.hadean777.miniboard.persistence.pojo.Thread pThread = daoFacade.getThreadDao().get(p_uid);
			
			if (pThread != null){
				thread = new Thread();
				thread.setUid(p_uid);
				thread.setName(pThread.getName());
				thread.setMessage(pThread.getMessage());
				if (pThread.getPosts() != null){
					List<Post> posts = new ArrayList<Post>();
					Post element = null;
					for (int i = 0; i < pThread.getPosts().size(); i++){
						element = new Post();
						element.setUid(pThread.getPosts().get(i).getUid());
						element.setName(pThread.getPosts().get(i).getName());
						element.setMessage(pThread.getPosts().get(i).getMessage());
						element.setTime(tcs.dateToString(pThread.getPosts().get(i).getAddedTS()));
						element.setTimestamp(pThread.getPosts().get(i).getAddedTS());
						posts.add(element);
					}
					thread.setPosts(posts);
				}
				thread.setTime(tcs.dateToString(pThread.getAddedTS()));
				thread.setTimestamp(pThread.getAddedTS());
			}
		
		} catch (DAOException ex) {
			throw new BusinessLogicException(ex.getMessage());
		}
		return thread;
	}
	
	public List<Thread> getAllThreads() throws BusinessLogicException{
		
		List<Thread> result = null;
		
		try {
			List<com.hadean777.miniboard.persistence.pojo.Thread> pThreadList = daoFacade.getThreadDao().getAllThreads();
			
			if (pThreadList != null){
				int i = 0;
				int j = 0;
				result = new ArrayList<Thread>();
				Thread element = null;
				for (i = 0; i < pThreadList.size(); i++){
					element = new Thread();
					element.setUid(pThreadList.get(i).getUid());
					element.setName(pThreadList.get(i).getName());
					element.setMessage(pThreadList.get(i).getMessage());
					element.setTime(tcs.dateToString(pThreadList.get(i).getAddedTS()));
					element.setTimestamp(pThreadList.get(i).getAddedTS());
					
					if (pThreadList.get(i).getPosts() != null){
						List<Post> posts = new ArrayList<Post>();
						Post singlePost = null;
						for (j = 0; j < pThreadList.get(i).getPosts().size(); j++){
							singlePost = new Post();
							singlePost.setUid(pThreadList.get(i).getPosts().get(j).getUid());
							singlePost.setName(pThreadList.get(i).getPosts().get(j).getName());
							singlePost.setMessage(pThreadList.get(i).getPosts().get(j).getMessage());
							singlePost.setTime(tcs.dateToString(pThreadList.get(i).getPosts().get(j).getAddedTS()));
							singlePost.setTimestamp(pThreadList.get(i).getPosts().get(j).getAddedTS());
							posts.add(singlePost);
						}
						element.setPosts(posts);
					}
					result.add(element);
				}
			}
		} catch (DAOException ex) {
			throw new BusinessLogicException(ex.getMessage());
		}
		
		return result;
	}
	
	public Long saveThread(Thread p_thread) throws BusinessLogicException{
		Long threadUID = null;
		try {
			if (p_thread != null){
				com.hadean777.miniboard.persistence.pojo.Thread pThread = new com.hadean777.miniboard.persistence.pojo.Thread();
				pThread.setUid(p_thread.getUid());
				pThread.setName(p_thread.getName());
				pThread.setMessage(p_thread.getMessage());
				
				if (p_thread.getPosts() != null) {
					List<com.hadean777.miniboard.persistence.pojo.Post> posts = new ArrayList<com.hadean777.miniboard.persistence.pojo.Post>();
					com.hadean777.miniboard.persistence.pojo.Post element = null;
					for (int i = 0; i < p_thread.getPosts().size(); i++){
						element = new com.hadean777.miniboard.persistence.pojo.Post();
						element.setUid(p_thread.getPosts().get(i).getUid());
						element.setName(p_thread.getPosts().get(i).getName());
						element.setMessage(p_thread.getPosts().get(i).getMessage());
						element.setThread(pThread);
						posts.add(element);
					}
					pThread.setPosts(posts);
				}
			daoFacade.getThreadDao().saveOrUpdate(pThread);
			
			threadUID = pThread.getUid();
			}		
		} catch (DAOException ex) {
			throw new BusinessLogicException(ex.getMessage());
		}
		return threadUID;
	}
	
	public Long createNewThread(Thread p_thread) throws BusinessLogicException{
		
		Long threadUID = null;
		try {
			if (p_thread != null){
				com.hadean777.miniboard.persistence.pojo.Thread pThread = new com.hadean777.miniboard.persistence.pojo.Thread();
				pThread.setUid(p_thread.getUid());
				pThread.setName(p_thread.getName());
				pThread.setMessage(p_thread.getMessage());
				
				daoFacade.getThreadDao().saveOrUpdate(pThread);
			
				threadUID = pThread.getUid();
			}		
		} catch (DAOException ex) {
			throw new BusinessLogicException(ex.getMessage());
		}
		return threadUID;
	}
	
	public Long addPost(Post p_post, Long p_threadUid) throws BusinessLogicException{
		
		Long postUID = null;
		try {
			if (p_post != null && p_threadUid != null){
				com.hadean777.miniboard.persistence.pojo.Thread pThread = daoFacade.getThreadDao().get(p_threadUid);
				com.hadean777.miniboard.persistence.pojo.Post post = new com.hadean777.miniboard.persistence.pojo.Post();
				post.setName(p_post.getName());
				post.setMessage(p_post.getMessage());
				post.setThread(pThread);
				daoFacade.getPostDao().saveOrUpdate(post);
				postUID = post.getUid();
			}		
		} catch (DAOException ex) {
			throw new BusinessLogicException(ex.getMessage());
		}
		return postUID;
	}
	
	public List<Post> getNewPosts(Long p_threadUid) throws BusinessLogicException{
		//TODO: return only new posts
		
		List<Post> result = null;
		try {
			if (p_threadUid != null){
				List<com.hadean777.miniboard.persistence.pojo.Post> postList = daoFacade.getPostDao().getNewPosts(p_threadUid);
				if (postList != null){
					result = new ArrayList<Post>();
					Post element = null;
					for (int i = 0; i < postList.size(); i++){
						element = new Post();
						element.setUid(postList.get(i).getUid());
						element.setName(postList.get(i).getName());
						element.setMessage(postList.get(i).getMessage());
						element.setTime(tcs.dateToString(postList.get(i).getAddedTS()));
						element.setTimestamp(postList.get(i).getAddedTS());
						result.add(element);
					}
				}
			}		
		} catch (DAOException ex) {
			throw new BusinessLogicException(ex.getMessage());
		}
		return result;
	}

}
