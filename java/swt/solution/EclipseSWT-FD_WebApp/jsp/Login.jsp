<%@ page contentType="text/xml; charset=euc-kr" %>
<%@ page import="java.util.Enumeration"%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String sid = request.getParameter("sid");
	System.out.println("id="+id);
	System.out.println("pass="+pass);
	System.out.println("sid="+sid);

	if((sid!=null)&&(!"".equals(sid))) {
		HttpSession hs = (HttpSession) application.getAttribute(sid);
		if(hs != null) {
			application.removeAttribute(sid);
			Enumeration e = hs.getAttributeNames() ;
			while(e.hasMoreElements()) {
				String name = (String)e.nextElement();
				Object value = hs.getAttribute(name);
				System.out.println("name="+name+",value="+value);
				session.setAttribute(name, value);
			}
		}
	}
%>
<h1>Login</h1>
id : <%=id%><br>
pass : <%=pass%><br>
sid : <%=sid%><br>
Session:<br>
<%
	Enumeration e = session.getAttributeNames() ;
	while(e.hasMoreElements()) {
		String name = (String)e.nextElement();
		Object value = session.getAttribute(name);
%>
name=<%=name%>,value=<%=value%><br>
<%
	}
%>
