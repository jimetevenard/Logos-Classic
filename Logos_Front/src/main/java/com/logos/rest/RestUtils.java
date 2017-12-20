package com.logos.rest;

import javax.servlet.http.HttpServletResponse;

public class RestUtils {
	
	
	public static void accessHeader(HttpServletResponse resp){
		resp.addHeader("Access-Control-Allow-Origin", "*");
	}

}
