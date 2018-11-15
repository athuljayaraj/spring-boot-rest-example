package com.flytxt.facebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author athul
 *
 */

@Controller
public class DemoController {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
}