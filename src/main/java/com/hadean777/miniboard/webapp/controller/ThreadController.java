package com.hadean777.miniboard.webapp.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hadean777.miniboard.AppConstants;
import com.hadean777.miniboard.exception.BusinessLogicException;
import com.hadean777.miniboard.manager.ThreadManager;
import com.hadean777.miniboard.model.AjaxResult;
import com.hadean777.miniboard.model.Post;
import com.hadean777.miniboard.model.Thread;

@Controller
public class ThreadController {
	
	@Autowired
	@Qualifier(AppConstants.MANAGER_BEAN_THREAD_MANAGER)
	private ThreadManager threadManager;
	
	@RequestMapping(value = "/common/viewThread.do", method = RequestMethod.GET)
	public ModelAndView viewThread(@RequestParam Long uid){
		
		ModelAndView model = new ModelAndView("viewThread");
		
		Thread thread = threadManager.getThreadByUID(uid);
		
		if (thread != null) {
			model.addObject("threadUid", thread.getUid());
			model.addObject("threadName", thread.getName());
			model.addObject("threadMessage", thread.getMessage());
			if (thread.getPosts() != null){
				ObjectMapper mapper = new ObjectMapper();
				String jsonPosts = "{}";
				try {
					jsonPosts = mapper.writeValueAsString(thread.getPosts());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				model.addObject("postsObj", jsonPosts);
			}
		}
		
		return model;
	}
	
	@RequestMapping(value = "/common/viewThread.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult addPost(@RequestParam Long threaduid,
								@RequestParam String name,
								@RequestParam String data) throws UnsupportedEncodingException {
		
		AjaxResult result = new AjaxResult();
		
		try {
			//Long uid = Long.parseLong(threaduid);
			Post post = new Post();
			post.setName(name);
			post.setMessage(data);
			Long postUid = threadManager.addPost(post, threaduid);
			result.setData(threaduid);
			result.setSuccess(true);
		} catch (BusinessLogicException ex) {
			result.setSuccess(false);
			result.setMessage(ex.getMessage());
		}
		
		return result;
	}

}
