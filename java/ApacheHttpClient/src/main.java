package com.erich0929.www;

public class main {
	public static void main (String [] args) {
		httptool obj = new httptool ();
		String str = obj.http2str ();
		System.out.println (str);
	}
}
