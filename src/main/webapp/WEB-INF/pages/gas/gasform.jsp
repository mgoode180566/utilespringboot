<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gases</title>
</head>
<spring:url value="/resources/js/jquery-1.11.3.min.js" var="jquery"/>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrap"/>
<spring:url value="/resources/js/rsvp-3.1.0.min.js" var="rsvp"/>
<spring:url value="/resources/js/sha-256.min.js" var="sha"/>
<script src="${jquery}"></script>
<script src="${bootstrap}"></script>
<script src="${rsvp}"></script>
<script src="${sha}"></script>
<body>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="http://www.utileengineering.co.uk/"><b class="text-info">Utile
                    Engineering</b></a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/">Home</a>
                    </li>
                    <li>
                        <a href="/newduty">Duty</a>
                    </li>
                    <li>
                        <a href="/gases">Gases</a>
                    </li>
                    </li>
                    </li>
                    <li>
                        <a href="/machines">Machines</a>
                    </li>
                    <li>
                        <a href="/about">About</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>

<form:form action="/savegas" modelAttribute="gas" method="post" class="form-horizontal">


    <table class="table table-striped">


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Gas name</label>
            <div class="col-md-4">
                <input id="name" name="name" type="text" placeholder="${gas.name}" class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="specificGravity">Specific gravity</label>
            <div class="col-md-4">
                <input id="specificGravity" name="specificGravity" type="text" placeholder="" class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="polytropicIndex">Polytropic index</label>
            <div class="col-md-4">
                <input id="polytropicIndex" name="polytropicIndex" type="text" placeholder="" class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Molecular weight</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="multiplier1">Multiplier 1</label>
            <div class="col-md-4">
                <input id="multiplier1" name="multiplier1" type="text" placeholder="" class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="multiplier2">Multiplier 2</label>
            <div class="col-md-4">
                <input id="multiplier2" name="multiplier2" type="text" placeholder="" class="form-control input-md">
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="gasType">Select type</label>
            <div class="col-md-4">
                <select id="gasType" name="gasType" class="form-control">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                </select>
            </div>
        </div>
    <button class="btn btn-primary">submit</button>

    </table>
</form:form>
</div>
</body>
</html>
