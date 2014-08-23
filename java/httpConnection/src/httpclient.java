import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class httpclient  {
 
    public static void main (String args[]) {
  
        httpclient net = new httpclient ();
        String strHtmlSource = net.strGetData();
        System.out.println("※Recieve HTML ("+getCurrentDate24() +") \n"+strHtmlSource);
  
    }
 
    private String strGetData() {
  
        BufferedReader    oBufReader = null;
        HttpURLConnection httpConn   = null;
        String strBuffer = "";
        String strRslt   = "";
      
        try
        {
            String strEncodeUrl = "http://kyoboaxa.ktspeedway.co.kr/traf?refresh=15&unit=K";
            URL oOpenURL = new URL(strEncodeUrl);
          
            httpConn =  (HttpURLConnection) oOpenURL.openConnection();          
            httpConn.setRequestMethod("POST");          
            httpConn.connect();          
            oBufReader = new BufferedReader(new InputStreamReader(oOpenURL.openStream()));
  
            //Buffer에 있는 내용을 읽어 차례로 화면에 뿌려준다.
            while((strBuffer = oBufReader.readLine()) != null)
            {
                if(strBuffer.length() > 1)
                {
                    strRslt += strBuffer;
                }
            }
          
        } catch( Exception ee) {
          ee.getMessage();
        }
  
        return strRslt;
    }
 
    /**
     * <p>현재날짜시간가져오기</p>
     * @return
     */
    private static String getCurrentDate24()
    {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.KOREA);
        return formatter.format(new java.util.Date());
    }
} 
