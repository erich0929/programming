<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.util.Enumeration" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>i3 실행 페이지</TITLE>
<META http-equiv=Content-Type content="text/html; charset=ks_c_5601-1987">
<META content=exclude name=collection>
<META content="MSHTML 6.00.2900.2180" name=GENERATOR></HEAD>

<BODY>
<H1>i3 실행 페이지</H1>
<br>
<H2>Parameter List</H2>
<UL>
<%
	Enumeration e = request.getParameterNames();
	while(e.hasMoreElements()) {
		String name = (String)e.nextElement();
		String value = request.getParameter(name);
%>
	<LI><%=name%> : <%=value%></A> 
<%
	}
%>

  </UL>
<HR>

<ADDRESS><A href="mailto:yongwoopark@paran.com">Yongwoo Park</A></ADDRESS>
</BODY></HTML>
