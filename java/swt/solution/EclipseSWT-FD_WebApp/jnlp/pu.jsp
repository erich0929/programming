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
	String modelId = "60PY3DRF";
	String serverUrl = "http://"+serverName+":"+serverPort+contextPath;
	String photoUrl = "/jsp/PhotoList.jsp?id="+id+"&modelId="+modelId+"&sessionId="+sessionId;
	String labelUrl = "/jsp/LabelList.jsp?id="+id+"&sessionId="+sessionId;
	String loginUrl = "/jsp/Login.jsp";
	String jnlpName = "pu-"+id+".jnlp";
	String jnlpStr = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
					+"<!-- Java Web Start Test Application -->\n"
					+"<jnlp\n"
					+"	spec=\"1.0\"\n"
					+"	codebase=\"http://"+serverName+":"+serverPort+contextPath+"/jnlp\"\n"
					+"	href=\"pu/"+jnlpName+"\">\n"
					+"    <information>\n"
					+"        <title>PhotoUpload</title>\n"
					+"        <vendor>RndClub</vendor>\n"
					+"        <offline-allowed/>\n"
					+"        <homepage href=\"PhotoUpload.html\"/>\n"
					+"        <description>Eclipse SWT PhotoUpload</description>\n"
					+"        <description kind=\"short\">Description</description>\n"
					+"        <icon href=\"images/pu.jpg\"/>\n"
					+"        <icon kind=\"splash\" href=\"images/idea.jpg\"/>\n"
					+"    </information>\n"
					+"    <security>\n"
					+"        <all-permissions/>\n"
					+"    </security>\n"
					+"    <resources>\n"
					+"        <j2se version=\"1.3+\"\n"
					+"                href=\"http://java.sun.com/products/autodl/j2se\"\n"
					+"                java-vm-args=\"-esa -Xnoclassgc -Xms128m -Xmx256m\"/>\n"
					+"        <jar href=\"pu/PhotoUpload.jar\"/>\n"
					+"        <jar href=\"pu/avalon-framework-4.1.4.jar\"/>\n"
					+"        <jar href=\"pu/commons-codec-1.3.jar\"/>\n"
					+"        <jar href=\"pu/commons-httpclient-3.0.1.jar\"/>\n"
					+"        <jar href=\"pu/commons-logging-1.1.jar\"/>\n"
					+"        <jar href=\"pu/swt.jar\"/>\n"
					+"        <nativelib href=\"pu/nativelib.jar\"/>\n"
					+"    </resources>\n"
					+"    <application-desc main-class=\"org.rndclub.pu.main.PhotoUpload\">\n"
					+"	    <argument>id="+id+"</argument>\n"
					+"	    <argument>modelId="+modelId+"</argument>\n"
					+"	    <argument>sessionId="+sessionId+"</argument>\n"
					+"	    <argument>serverUrl="+serverUrl+"</argument>\n"
					+"	    <argument>downUrl="+photoUrl+"</argument>\n"
					+"	    <argument>labelUrl="+labelUrl+"</argument>\n"
					+"	    <argument>loginUrl="+loginUrl+"</argument>\n"
					+"    </application-desc>\n"
					+"</jnlp>\n";

	try {
		String jnlpRealPath = realPath + "jnlp"
                            + File.separator + "pu"
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
		session.setAttribute("photoUrl", downUrl);
		session.setAttribute("labelUrl", labelUrl);
		session.setAttribute("jnlpName", jnlpName);
		application.setAttribute(sessionId, session);

		String redirectUrl = contextPath+"/jnlp/pu/"+jnlpName;
		System.out.println("redirectUrl : "+redirectUrl);

		response.sendRedirect(redirectUrl);
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
