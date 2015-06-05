package com.hadean777.miniboard.webapp.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

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
import com.hadean777.miniboard.model.Thread;


@Controller
public class MainController {
	
	@Autowired
	@Qualifier(AppConstants.MANAGER_BEAN_THREAD_MANAGER)
	private ThreadManager threadManager;
	
	@RequestMapping(value = "/common/mainpage.do", method = RequestMethod.GET)
	public ModelAndView showMainPage(){
		
		List<Thread> allThreads = threadManager.getAllThreads();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonThreads = "{}";
		
		try {
			jsonThreads = mapper.writeValueAsString(allThreads);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("mainPage", "threadsObj", jsonThreads);
	}
	
	@RequestMapping(value = "/common/create_thread.do", method = RequestMethod.GET)
	public ModelAndView showCreateThreadForm(){
		
		
		return new ModelAndView("createThread");
	}
	
	@RequestMapping(value = "/common/createThread.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult createThread(@RequestParam String name,
									@RequestParam String data) throws UnsupportedEncodingException {
		
		AjaxResult result = new AjaxResult();
		
		try {
			Thread thread = new Thread();
			thread.setName(name);
			thread.setMessage(data);
			Long uid = threadManager.createNewThread(thread);
			result.setData(uid);
			result.setSuccess(true);
		} catch (BusinessLogicException ex) {
			result.setSuccess(false);
			result.setMessage(ex.getMessage());
		}
		
		return result;
	}
	

}
