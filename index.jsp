<%-- 
    Document   : index
    Created on : Aug 29, 2017, 9:09:45 PM
    Author     : felix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.getSession(false).invalidate(); 
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome</h1>


        <h2>Siu Solutions</h2>
        <form action="/ExpenditureTracker/login" method="DO">
            <fieldset>
                <legend>LOG IN</legend>
                Username:<br /> <input name="username" type="text" /><br /> 
                Password:<br /> <input name="password" type="password" /><br />
                <input type="submit" value="Submit" /></fieldset>
        </form>
        <p>&nbsp;</p>
        <p>Not yet a member?</p>

        <form action="/ExpenditureTracker/createUser" method="DO">
            <fieldset>
                <legend> Create Account</legend>
                <p>
                    Username:<br /> <input name="newUsername" type="text" /><br /> 
                    Password:<br /> <input name="newPassword" type="password" /><br />
                    <input type="submit" value="Submit" />
                </p>
            </fieldset>
        </form>


    </body>
</html>
