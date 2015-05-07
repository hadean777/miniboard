package com.hadean777.miniboard.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		
		String outstr = "";
		
		Thread thread = new Thread();
		
		thread.setMessage("this is test messss");
		
		Long uid = threadManager.saveThread(thread);
		
		thread = new Thread();
		
		thread = threadManager.getThreadByUID(uid);
		
		outstr += thread.getUid() + "  " + thread.getMessage();
		
		
		return new ModelAndView("mainPage", "outstr", outstr);
	}

}
