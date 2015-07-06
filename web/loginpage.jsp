
<head>
    <title>Registration Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/Site.css">
</head>
<body>
<center>
    <h1>HPES LOGIN PAGE</h1>
</center>
<div>
    <form method="POST" action="auth">
        <table align="center">
            <tr><th colspan="2">LOGIN HERE</th></tr>
            <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
            <tr><td>Login ID</td><td><input type="text" name="name" placeholder="name"/></td></tr>
            <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
            <tr><td>Password</td><td><input type="password" name="password" placeholder="password"/></td></tr>
            <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
            <center>
                <div>
                    <td><input type="submit" value="Login"  class="button green"/></td>
                    <td><input type="reset" value="Reset" class="button red"/></td>
                </div>
            </center>
            </tr>
        </table>
        <br><br>
        <center>
            <a href="signup.html">new user register here</a>
        </center
        <hr><br>

    </form>
    <font color ="red">
    <header>
    <%
    String message =(String) request.getAttribute("msg");
    if(message!= null)
    out.print(message);
    %>
    </header>
</div>
<hr>
<a href="SendCookie">SEND COOKIE</a>
<br><br><br>
<a href="ReceiveCookie">VIEW SAVED COOKIES</a>
</body>
