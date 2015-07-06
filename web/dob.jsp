<%@page import="java.util.Date"%>

<h2 align="center">HPES USER PAGE</h2>
<jsp:include page="menu.jsp"/>

<%
 String d = request.getParameter("date");
 String m = request.getParameter("month");
 String y = request.getParameter("year");
 
 int year = Integer.parseInt(y);
 int age  = 2015-year;
 
 Date now = new Date();
%>

<center>
<hr>
<h3>DATE-TIME : <%=now%></h3>
<h4>DATE  : <%=d%><BR>
MONTH : <%=m%><BR>
YEAR  : <%=y%></h4>

<h2>YOUR AGE IS : <%=age%> Year(s)</h2>
</center>

CLIENT TIME : <script>
    document.write(new Date());
</script>














