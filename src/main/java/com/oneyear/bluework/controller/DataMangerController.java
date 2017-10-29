/***********************************************************
 * 
 * @Copyright: 2017 One Year Studio All rights reserved. 
 *
 ***********************************************************/
package com.oneyear.bluework.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.oneyear.bluework.model.Msg;

/**
 * @ClassName DataMangerController
 * @Description: TODO
 * @author willie
 * @Date: 2017年6月18日 
 */
@RestController
public class DataMangerController {
	@RequestMapping("/")
	public ModelAndView mangerIndex() {
		ModelAndView mv = new ModelAndView("home");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		Msg msg = new Msg("测试标题", "测试内容", "欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
		// model.addAttribute("userName", username);
		mv.addObject("userName", username);
		mv.addObject("msg", msg);
		return mv;
	}

	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView("admin");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}
