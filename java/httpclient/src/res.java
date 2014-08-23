package com.erich0929.www;

public class res {
	public static void main (String [] args) {
		ClientWithResponseHandler client = new ClientWithResponseHandler ();
		try {
			String str = client.http2str ();
			System.out.println (str);
		} catch (Exception e) {
		}
	}
}
