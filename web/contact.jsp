<%--
  Created by IntelliJ IDEA.
  User: Y08L
  Date: 04-11-2018
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Zyg <span class="glyphicon glyphicon-apple"></span> Store</a>
        </div>
        <ul class="nav navbar-nav">
            <li ><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Strona główna</a></li>
            <li><a href="#">Oferta</a> </li>
            <li class="active"><a href="contact.jsp">Kontakt</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Koszyk </a></li>
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Załóż konto</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Zaloguj się</a></li>
        </ul>
    </div>
</nav>
</nav>




<div class="container">

    <form class="well form-horizontal" action=" " method="post"  id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>Dane kontaktowe</legend>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Firma</label>
                <div class="col-md-4 text-info">
                    <div class="input-group">
                        <span class="input-group-addon"><i>Zyg <span class="glyphicon glyphicon-apple"></span> Store
                            <br>05-500 Warszawa
                            <br>ul. Emilii Plater 123
                        </i></span>
                    </div>
                </div>
            </div>

        <div class="form-group">
                <label class="col-md-4 control-label">Tel</label>
                <div class="col-md-4 text-info">
                    <div class="input-group">
                        <span class="input-group-addon"><i><span class="glyphicon glyphicon-phone-alt"></span> 0-700 800 900
                        </i></span>
                    </div>
                </div>
            </div>

     <div class="form-group">
                <label class="col-md-4 control-label">Email</label>
                <div class="col-md-4 text-info">
                    <div class="input-group">
                        <span class="input-group-addon"><i><span class="glyphicon glyphicon-envelope"></span><a  href="mailto:zygmunt.paczkowski@gmail.com"> zygmunt.paczkowski@gmail.com</a>
                        </i></span>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">Napisz do nas</label>
                <div class="col-md-4 text-info">
                    <div class="input-group">
                        <span class="input-group-addon"><i><span class="glyphicon glyphicon-pencil"></span><a href="contact_form.jsp"> Formularz kontaktowy</a>
                        </i></span>
                    </div>
                </div>
            </div>

            <!-- Text input-->
        </fieldset>
    </form>
</div>

</body>
</html>
