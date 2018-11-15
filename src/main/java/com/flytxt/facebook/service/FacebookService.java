/**
 * 
 */
package com.flytxt.facebook.service;

import org.springframework.stereotype.Service;

/**
 * @author athul
 *
 */
@Service
public class FacebookService {

	/**
	 * @return
	 */
	public int getHubChallenge() {
		// TODO Auto-generated method stub
		return 1158201444;
	}
	
	public int register(String mode, String verify_token, String challenge ) {
		System.out.println("hub.mode: " + mode);
		System.out.println("hub.verify_token: " + verify_token);
		System.out.println("hub.challenge: " + challenge);
		return Integer.parseInt(challenge);
	}
	
	public void recordEvent(String event) {
		System.out.println(event);
	}
}
