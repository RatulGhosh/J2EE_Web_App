<center>
    <h2>WELCOME HOME : <%
        HttpSession s = request.getSession(false);
        String message = (String) s.getAttribute("uid");
        //String message = (String) request.getAttribute("uid");
        if (message != null) {
            out.print(message + "  ");
        }
        %>
    </h2>
</center>
<hr>
<marquee>this is a user home page to access user profile and perform user based action on our web application..</marquee>
<hr>
<pre>
USER MENU
------------
<a href="#">HOME</a>
------------
<a href="#">CONTACT US</a>
------------
<a href="#">CHANGE PHOTO</a>
------------
<a href="#">VIEW PROFILE</a>
------------
<a href="change_password.html">CHANGE PASSWORD</a>
------------
<a href="LogOut">LOGOUT</a>
------------
</pre>

