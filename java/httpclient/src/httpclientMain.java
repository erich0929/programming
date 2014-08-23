import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class httpclientMain {
	public static void main (String[] args) {
		HttpClient httpclient = new DefaultHttpClient ();
		HttpGet httpget = new HttpGet ("www.daum.net");

		try {
			httpclient.execute (httpget, new BasicResponseHandler () {
				@Override
				public String handleResponse (HttpResponse res) throws HttpResponseException, IOException {
					String str = new String (super.handleResponse (res).getBytes ("8859_1"), "uft-8");
					System.out.println (str);
					return str;
				}
			});
		} catch (ClientProtocolException e) {
			e.printStackTrace ();
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}
}
