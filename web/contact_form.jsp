<%--
  Created by IntelliJ IDEA.
  User: Y08L
  Date: 05-11-2018
  Time: 06:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

    <form class="well form-horizontal" action=" " method="post"  id="contact_form" data-toggle="validator">
        <fieldset>

            <!-- Form Name -->
            <legend>Formularz kontaktowy</legend>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Imię *</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input  name="first_name" placeholder="Imię" class="form-control" type="text" required="required" data-error="Imię jest wymagane.">
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label" >Nazwisko *</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="last_name" placeholder="Nazwisko" class="form-control" type="text" required="required" data-error="Nazwisko jest wymagane.">
                    </div>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label">E-Mail *</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                        <input id="form_email" name="form_email" type="email" placeholder="Adres E-Mail" class="form-control"  type="text" required="required" data-error-msg="Email jest wymagany." oninvalid="setCustomValidity('Plz enter on Alphabets ')"
                               onchange="try{setCustomValidity('')}catch(e){}">
                    </div>
                </div>
                <div class="help-block with-errors"></div>
            </div>


            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Telefon</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                        <input name="phone" placeholder="+48 600-700-800" class="form-control" type="text">
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label">Typ sprawy</label>
                <div class="col-md-4 selectContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                        <select name="state" class="form-control selectpicker" >
                            <option value=" " >Temat sprawy</option>
                            <option>Płatności</option>
                            <option>Faktury</option>
                            <option>Zamówienia</option>
                            <option>Zapytanie ofertowe</option>
                            <option>Żadne z powyższych</option>


                        </select>
                    </div>
                </div>
            </div>

            <!-- Text input-->


            <div class="form-group">
                <label class="col-md-4 control-label">Jesteś już naszym klientem?</label>
                <div class="col-md-4">
                    <div class="radio">
                        <label>
                            <input type="radio" name="hosting" value="yes" /> Tak
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="hosting" value="no" /> Nie
                        </label>
                    </div>
                </div>
            </div>

            <!-- Text area -->

            <div class="form-group">
                <label class="col-md-4 control-label">Treść wiadomości *</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                        <textarea class="form-control" name="comment" placeholder="Treść wiadomości" required="required" data-error="Wiadomość jest wymagana."></textarea>
                    </div>
                </div>
            </div>

            <!-- Success message -->
            <div class="alert alert-success" role="alert" id="success_message">Sukces! <i class="glyphicon glyphicon-thumbs-up"></i> Dziękujemy za kontakt. Odpowiemy wkrótce.</div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <button type="submit" class="btn btn-warning" >Wyślij <span class="glyphicon glyphicon-send"></span></button>
                </div>
            </div>

            <div class="col-md-12">
                <p class="text-muted">
                    <strong>*</strong> Pola wymagane. Prosimy o wypełnienie
                </p>
            </div>
        </fieldset>
    </form>
</div>
</div><!-- /.container -->



<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js" integrity="sha256-dHf/YjH1A4tewEsKUSmNnV05DDbfGN3g7NMq86xgGh8=" crossorigin="anonymous"></script>--%>
<script src=/resources/css/validator.js ></script>

</body>
</html>
