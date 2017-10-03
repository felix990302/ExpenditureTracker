<%-- 
    Document   : updateExp
    Created on : 6-Sep-2017, 7:56:55 PM
    Author     : chang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expenditure Updater</title>
    </head>
    <body>
        <h1>Update Your Expenditure</h1>



        <form action="/ExpenditureTracker/update" method="GET">
            <fieldset>
                <legend>Enter your expenditure</legend>
                Amount:<br /> <input name="amount" type="number" /><br /> 

                <input type="radio" name="ExpType" value="fixedExp" checked> Fixed Expenditure <br>
                <input type="radio" name="ExpType" value="flexibleExp"> Flexible Expenditure <br>
                <input type="radio" name="ExpType" value="discretionaryExp"> Discretionary Expenditure <br>



                <input type="submit" value="Submit" />

        </form>
        <p>&nbsp;</p>

        <%
            response.setContentType("text/html");
            out.println("<p><a href='/ExpenditureTracker/login'>Cancel</p>");
        %>



    </body>
</html>


