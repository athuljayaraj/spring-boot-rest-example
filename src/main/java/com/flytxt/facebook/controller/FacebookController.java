/**
 * 
 */
package com.flytxt.facebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flytxt.facebook.service.FacebookService;

/**
 * @author athul
 *
 */
@RestController
@RequestMapping(value = "/facebook")
public class FacebookController {

	@Autowired
	private FacebookService facebookService;

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody int verify(@RequestParam("hub.mode") String mode,
			@RequestParam("hub.challenge") String challenge, @RequestParam("hub.verify_token") String verify_token,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int hubChallenge = facebookService.register(mode, verify_token, challenge);
		return hubChallenge;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void event(HttpEntity<String> httpEntity) {
		facebookService.recordEvent(httpEntity.getBody());
	}
}
