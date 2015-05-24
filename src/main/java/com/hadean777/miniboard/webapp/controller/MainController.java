package com.hadean777.miniboard.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hadean777.miniboard.AppConstants;
import com.hadean777.miniboard.manager.ThreadManager;
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

}
