package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DownloadList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/xml; charset=euc-kr");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"euc-kr\" ?>\r\n");

	String serverName = request.getServerName();
	String serverPort = ""+request.getServerPort();
	String contextPath = request.getContextPath();
	System.out.println("[DownloadList.jsp] serverName : "+serverName);
	System.out.println("[DownloadList.jsp] serverPort : "+serverPort);
	System.out.println("[DownloadList.jsp] contextPath : "+contextPath);

	String prefix = "http://"+serverName+":"+serverPort+contextPath;
	System.out.println("[DownloadList.jsp] prefix : "+prefix);

      out.write("\r\n");
      out.write("<root>\r\n");
      out.write("\t<file>\r\n");
      out.write("\t\t<name>commons-httpclient-3.0.1.jar</name> \r\n");
      out.write("\t\t<size>279781</size> \r\n");
      out.write("\t\t<type>jar</type> \r\n");
      out.write("\t\t<path>");
      out.print(contextPath);
      out.write("/down/commons-httpclient-3.0.1.jar</path>\r\n");
      out.write("\t\t<url>");
      out.print(prefix);
      out.write("/down/commons-httpclient-3.0.1.jar</url>\r\n");
      out.write("\t</file>\r\n");
      out.write(" \t<file>\r\n");
      out.write("\t\t<name>swt.jar</name> \r\n");
      out.write("\t\t<size>1490613</size> \r\n");
      out.write("\t\t<type>jar</type> \r\n");
      out.write("\t\t<path>");
      out.print(contextPath);
      out.write("/down/swt.jar</path>\r\n");
      out.write("\t\t<url>");
      out.print(prefix);
      out.write("/down/swt.jar</url>\r\n");
      out.write("\t</file>\r\n");
      out.write("\t<file>\r\n");
      out.write("\t\t<name>Tony Bennet - Fly Me To The Moon.mp3</name> \r\n");
      out.write("\t\t<size>6112319</size> \r\n");
      out.write("\t\t<type>mp3</type> \r\n");
      out.write("\t\t<path>");
      out.print(contextPath);
      out.write("/down/Tony Bennet - Fly Me To The Moon.mp3</path> \r\n");
      out.write("\t\t<url>");
      out.print(prefix);
      out.write("/down/Tony Bennet - Fly Me To The Moon.mp3</url>\r\n");
      out.write("\t</file>\r\n");
      out.write("\t<file>\r\n");
      out.write("\t\t<name>보성녹차밭.jpg</name> \r\n");
      out.write("\t\t<size>60933</size> \r\n");
      out.write("\t\t<type>jpg</type> \r\n");
      out.write("\t\t<path>");
      out.print(contextPath);
      out.write("/down/A20070331.jpg</path> \r\n");
      out.write("\t\t<url>");
      out.print(prefix);
      out.write("/down/A20070331.jpg</url>\r\n");
      out.write("\t</file>\r\n");
      out.write("</root>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
