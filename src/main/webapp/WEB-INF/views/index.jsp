<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 16.02.2018
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Graur's app</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Please, log in here!</h1>
</div>


    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Login:</h2>
        </div>
        <form name='loginForm' action="" method='POST' class="w3-selection w3-light-grey w3-padding">
            <label>Login:
                <input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Password:
                <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
<a href="/">Logout</a>
</body>
</html>