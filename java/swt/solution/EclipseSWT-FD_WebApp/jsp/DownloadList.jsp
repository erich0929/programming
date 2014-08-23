<%@ page contentType="text/xml; charset=euc-kr" %><?xml version="1.0" encoding="euc-kr" ?>
<%
	String serverName = request.getServerName();
	String serverPort = ""+request.getServerPort();
	String contextPath = request.getContextPath();
	System.out.println("[DownloadList.jsp] serverName : "+serverName);
	System.out.println("[DownloadList.jsp] serverPort : "+serverPort);
	System.out.println("[DownloadList.jsp] contextPath : "+contextPath);

	String prefix = "http://"+serverName+":"+serverPort+contextPath;
	System.out.println("[DownloadList.jsp] prefix : "+prefix);
%>
<root>
	<file>
		<name>commons-httpclient-3.0.1.jar</name> 
		<size>279781</size> 
		<type>jar</type> 
		<path><%=contextPath%>/down/commons-httpclient-3.0.1.jar</path>
		<url><%=prefix%>/down/commons-httpclient-3.0.1.jar</url>
	</file>
 	<file>
		<name>swt.jar</name> 
		<size>1490613</size> 
		<type>jar</type> 
		<path><%=contextPath%>/down/swt.jar</path>
		<url><%=prefix%>/down/swt.jar</url>
	</file>
	<file>
		<name>Tony Bennet - Fly Me To The Moon.mp3</name> 
		<size>6112319</size> 
		<type>mp3</type> 
		<path><%=contextPath%>/down/Tony Bennet - Fly Me To The Moon.mp3</path> 
		<url><%=prefix%>/down/Tony Bennet - Fly Me To The Moon.mp3</url>
	</file>
	<file>
		<name>보성녹차밭.jpg</name> 
		<size>60933</size> 
		<type>jpg</type> 
		<path><%=contextPath%>/down/A20070331.jpg</path> 
		<url><%=prefix%>/down/A20070331.jpg</url>
	</file>
</root>
