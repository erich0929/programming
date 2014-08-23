<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.io.*"%>
<%
	String serverName = request.getServerName();
	String serverPort = ""+request.getServerPort();
	String realPath = request.getRealPath("/");
	if((realPath!=null)&&(!realPath.endsWith(File.separator))) {
		realPath += File.separator;
	}
	String sessionId = request.getRequestedSessionId();
	String contextPath = request.getContextPath();

	System.out.println("---------------------------------------------------");
	System.out.println(" serverPort : "+serverPort);
	System.out.println(" serverName : "+serverName);
	System.out.println("   realPath : "+realPath);
	System.out.println("  sessionId : "+sessionId);
	System.out.println("contextPath : "+contextPath);
	System.out.println("---------------------------------------------------");

	String id = "ywpark";
	String serverUrl = "http://"+serverName+":"+serverPort+contextPath;
	String downUrl = "/jsp/DownloadList.jsp?id="+id+"&sessionId="+sessionId;
	String labelUrl = "/jsp/LabelList.jsp?id="+id+"&sessionId="+sessionId;
	String loginUrl = "/jsp/Login.jsp";
	String jnlpName = "fd-"+id+".jnlp";
	String jnlpStr = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
					+"<!-- Java Web Start Test Application -->\n"
					+"<jnlp\n"
					+"	spec=\"1.0\"\n"
					+"	codebase=\"http://"+serverName+":"+serverPort+contextPath+"/jnlp\"\n"
					+"	href=\"fd/"+jnlpName+"\">\n"
					+"    <information>\n"
					+"        <title>FileDownload</title>\n"
					+"        <vendor>RndClub</vendor>\n"
					+"        <offline-allowed/>\n"
					+"        <homepage href=\"FileDownload.html\"/>\n"
					+"        <description>Eclipse SWT FileDownload</description>\n"
					+"        <description kind=\"short\">Description</description>\n"
					+"        <icon href=\"images/fd.jpg\"/>\n"
					+"        <icon kind=\"splash\" href=\"images/idea.jpg\"/>\n"
					+"    </information>\n"
					+"    <security>\n"
					+"        <all-permissions/>\n"
					+"    </security>\n"
					+"    <resources>\n"
					+"        <j2se version=\"1.3+\"\n"
					+"                href=\"http://java.sun.com/products/autodl/j2se\"\n"
					+"                java-vm-args=\"-esa -Xnoclassgc -Xms128m -Xmx256m\"/>\n"
					+"        <jar href=\"fd/FileDownload.jar\"/>\n"
					+"        <jar href=\"fd/avalon-framework-4.1.4.jar\"/>\n"
					+"        <jar href=\"fd/commons-codec-1.3.jar\"/>\n"
					+"        <jar href=\"fd/commons-httpclient-3.0.1.jar\"/>\n"
					+"        <jar href=\"fd/commons-logging-1.1.jar\"/>\n"
					+"        <jar href=\"fd/swt.jar\"/>\n"
					+"        <nativelib href=\"fd/nativelib.jar\"/>\n"
					+"    </resources>\n"
					+"    <application-desc main-class=\"org.rndclub.fd.main.FileDownload\">\n"
					+"	    <argument>id="+id+"</argument>\n"
					+"	    <argument>sessionId="+sessionId+"</argument>\n"
					+"	    <argument>serverUrl="+serverUrl+"</argument>\n"
					+"	    <argument>downUrl="+downUrl+"</argument>\n"
					+"	    <argument>labelUrl="+labelUrl+"</argument>\n"
					+"	    <argument>loginUrl="+loginUrl+"</argument>\n"
					+"    </application-desc>\n"
					+"</jnlp>\n";

	try {
		String jnlpRealPath = realPath + "jnlp"
                            + File.separator + "fd"
                            + File.separator + jnlpName;
		System.out.println("jnlpRealPath : "+jnlpRealPath);

		File jnlpFile = new File(jnlpRealPath);
		FileWriter writer = new FileWriter(jnlpFile);
		PrintWriter fout = new PrintWriter(writer);
		fout.println(jnlpStr);
		fout.close();

		session.setAttribute("id", id);
		session.setAttribute("sessionId", sessionId);
		session.setAttribute("serverUrl", serverUrl);
		session.setAttribute("downUrl", downUrl);
		session.setAttribute("labelUrl", labelUrl);
		session.setAttribute("jnlpName", jnlpName);
		application.setAttribute(sessionId, session);

		String redirectUrl = contextPath+"/jnlp/fd/"+jnlpName;
		System.out.println("redirectUrl : "+redirectUrl);

		response.sendRedirect(redirectUrl);
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
