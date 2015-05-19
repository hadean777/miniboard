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
		int j = 0;
				
		List<Thread> allThreads = threadManager.getAllThreads();
		
		if (allThreads != null){
			for (i = 0; i < allThreads.size(); i++){
				outstr += "Thread №" + allThreads.get(i).getUid() + " " + allThreads.get(i).getTimestamp() + " " + allThreads.get(i).getMessage() + "<br>";
				if (allThreads.get(i).getPosts() != null){
					for (j = 0; j < allThreads.get(i).getPosts().size(); j++){
						outstr += "    Post №" + allThreads.get(i).getPosts().get(j).getUid() + " " + allThreads.get(i).getPosts().get(j).getTimestamp() + " " + allThreads.get(i).getPosts().get(j).getMessage() + "<br>";
					}
				}
			}
		}
		
		
		return new ModelAndView("mainPage", "outstr", outstr);
	}

}
