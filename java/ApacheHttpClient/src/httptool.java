package com.erich0929.www;

import org.apache.http.*;
import org.apache.http.impl.client.*;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import java.io.*;

public class httptool {
	public String http2str () {
		CloseableHttpClient client = HttpClients.createDefault ();
		HttpGet req = new HttpGet ("http://localhost/");
		CloseableHttpResponse res = null; 
		String ret = "";
		try {
			res = client.execute (req);
			HttpEntity entity = res.getEntity ();
			
			if (entity != null) {
				ret = EntityUtils.toString (entity);
				//System.out.println (str);
			}
		} catch (Exception e) {
			e.printStackTrace ();
			try {
				res.close ();
			} catch (Exception e1) {
				e.printStackTrace ();
			}
		}
		return ret;
	}
}
