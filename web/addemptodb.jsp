<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="Entity.*"%>
<%@page errorPage="error.html" %>

<jsp:useBean id="e1" class="Entity.Employee"/>

<jsp:setProperty name="e1" property="*"/>

<%
 Session s = hibdao.Hib_DAO_Layer.getSession();
 Transaction t = s.beginTransaction();
 s.save(e1);
 t.commit();
%>
<pre>
NAME : <jsp:getProperty name="e1" property="name"/>
DEPT : <jsp:getProperty name="e1" property="dept"/>
SAL  : <jsp:getProperty name="e1" property="salary"/>
</pre>

<script>
    alert('DATA SAVED!!!');
</script>