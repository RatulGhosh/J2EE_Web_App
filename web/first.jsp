<h2 align ="center">UNDERSTANDING JSP DOCUMENTS</h2>
<hr>
<link rel="stylesheet" type="text/css" href="css/Site.css">

HTML COMMENTS : <!-- This is HTML Comment(donot runs on client but runs on server see view source in browser html comments will be visible but jsp comments will not be visible)-->
<br>
<br>
JSP COMMENTS : <%--This is JSP Comment(donot runs on server)--%>
<hr>
<%!
    int a = 5;
%>
<%
    a = a * 2;
    out.println(a);
%>
<h2>Value of a is :<%=a%></h2>
<center>
    <form action="dob.jsp">
        <b>SELECT YOUR DATE OF BIRTH : </b> <br><br>

        DATE : 
        <select name ="date">
            <option value="-1">------SELECT DATE------</option>
            <%for (int i = 1; i <= 31; i++) {%>
            <option value="<%=i%>"><%=i%></option>
            <%}%>
        </select>
        MONTH : 
        <select name ="month">
            <option value="-1">------SELECT MONTH------</option>
            <%for (int i = 1; i <= 12; i++) {%>
            <option value="<%=i%>"><%=i%></option>
            <%}%>
        </select>
        YEAR : 
        <select name ="year">
            <option value="-1">------SELECT YEAR------</option>
            <%for (int i = 1980; i <= 2015; i++) {%>
            <option value="<%=i%>"><%=i%></option>
            <%}%>
        </select>
        <br>
        <br>
        <input type="submit" value="SUBMIT"  class="button green"/>
        <input type="reset" value="RESET" class="button red"/>
    </form>
</center>
