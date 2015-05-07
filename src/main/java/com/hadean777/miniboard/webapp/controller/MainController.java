package com.hadean777.miniboard.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hadean777.miniboard.AppConstants;
import com.hadean777.miniboard.manager.ThreadManager;
import com.hadean777.miniboard.model.Thread;
import com.hadean777.miniboard.model.Post;
import com.hadean777.miniboard.persistence.DaoFacade;

@Controller
public class MainController {
	
	@Autowired
	@Qualifier(AppConstants.MANAGER_BEAN_THREAD_MANAGER)
	private ThreadManager threadManager;
	
	@RequestMapping(value = "/common/mainpage.do", method = RequestMethod.GET)
	public ModelAndView showMainPage(){
		
		String outstr = "";
		int i = 0;
		
		Thread thread = new Thread();
		
		thread.setMessage("second thread");
		
		Long uid = threadManager.saveThread(thread);
		
		thread = new Thread();
		
		thread = threadManager.getThreadByUID(uid);
		
		outstr += "Thread: " + thread.getUid() + "  " + thread.getMessage() + " " + thread.getTimestamp() + "<br>";
		
		Post post = new Post();
		post.setMessage("post message");
		uid = threadManager.addPost(post, thread.getUid());
		
		post = new Post();
		post.setMessage("second post message");
		uid = threadManager.addPost(post, thread.getUid());
		
		List<Post> postList = threadManager.getNewPosts(thread.getUid());
		
		if (postList != null){
			for (i = 0; i < postList.size(); i++){
				outstr += "№" + postList.get(i).getUid() + " " + postList.get(i).getMessage() + " " + postList.get(i).getTimestamp();
			}
		}
		
		return new ModelAndView("mainPage", "outstr", outstr);
	}

}
