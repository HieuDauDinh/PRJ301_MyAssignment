<%-- 
    Document   : loginc
    Created on : Feb 29, 2024, 4:02:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
        
    </head>
    <body>
        <h3 style="color: red">${requestScope.err}</h3>
        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
                width: 50%;
                margin-top: 50px;
                margin-left: 20%;
                display: flex;
                align-items: center;
                justify-content: center;
            }
            form {
                border: 3px solid #f1f1f1;
            }

            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            button {
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
            }

            img.avatar {
                width: 40%;
                border-radius: 50%;
            }

            .container {
                padding: 16px;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }
        </style>
    </head>

<body>


    
    <form action="login" method="post">


        <div class="container">
            <label for="uname"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="username" required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" required>

            <button type="submit">Login</button>
            <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" class="cancelbtn">Cancel</button>
            <span class="psw">Forgot <a href="#">password?</a></span>
        </div>
    </form>
</body>
</html>
