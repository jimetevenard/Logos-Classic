package com.logos.rest;

import javax.servlet.http.HttpServletResponse;

public class RestUtils {
	
	
	public static void accessHeader(HttpServletResponse resp){
		
		// inutile, on utilise le filter tomcat
		// resp.addHeader("Access-Control-Allow-Origin", "*");
	}

}
