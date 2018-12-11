<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Utile Engineering</title>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="../navbar.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <!-- Static navbar -->
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
                    <li class="active">
                        <a href="/newduty">Duty</a>
                    </li>
                    <li>
                        <a href="/gases">Gases</a>
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
    <form:form action="findmachine" modelAttribute="duty" method="post" class="form-horizontal">
    <div>
            <h2 class="text-success">New Duty</h2>
        <table class="table table-striped">
        <tr><td><label class="text">Cooling Type</label></td>
            <td><label><input type="radio" name="coolingType" value="Water" checked="checked"> Water</label></td>
            <td><label><input type="radio" name="coolingType" value="Air" checked="checked"> Air</label></td></tr>
            <tr><td><label class="text">Flowrate</label></td><td><input type="text" name="flowRate" value="450"></td><td>UNIT</td></tr>
            <tr><td><label class="text">Inlet pressure</label></td><td><input type="text" name="pressureIn" value="0.2"></td><td>UNIT</td></tr>
            <tr><td><label class="text">Outlet pressure</label></td><td><input type="text" name="pressureOut" value="3.2"></td><td>UNIT</td></tr>
            <tr><td><label class="text">Inlet temperature</label></td><td><input type="text" name="inletTemp" value="25"></td><td>UNIT</td></tr>
            <tr><td><label class="text">Altitude</label></td><td><input type="text" name="altitude" value="1500"></td><td>UNIT</td></tr>
            <tr><td><input type="submit"></td><td></td><td></td></tr>
        </table>
    </div>
    </form:form>
</body>