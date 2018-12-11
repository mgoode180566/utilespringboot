<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div align="center">
    <div class="container">
        <table class="table table-striped">
            <th>Duty</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <tr>
                <td>Machine type : Compressor</td>
                <td>Flowrate : ${duty.flowRate}</td>
                <td>Compression Ratio : ${duty.compressionRatio}</td>
                <td>Inlet temperature : ${duty.inletTemp}</td>
            </tr>
            <tr>
                <td>Inlet volume : xxx.xxx</td>
                <td>Inlet pressure : ${duty.pressureIn}</td>
                <td>Outlet pressure : ${duty.pressureOut}</td>
                <td>Altitude : ${duty.altitude}</td>
                <td>Barometric Pressure : ${duty.barometricPressure}</td>
            </tr>
        </table>
    </div>
    <div class="container">
        <table class="table table-striped">
            <th>Matching machines</th>
            <c:forEach var="machine" items="${list}" varStatus="status">
                <tr>
                    <td>${machine.name}</td>
                    <td>
                        <table class="table table-striped">
                            <tr>
                                <td>Min actual speed : ${machine.actualMinSpeed}</td>
                                <td>Max actual speed : ${machine.actualMaxSpeed}</td>
                            <tr>
                                <td>Current inlet angle : ${machine.currentInletPortAngle}</td>
                                <td>Current outlet angle : ${machine.currentOutlePortAngle}</td>
                            </tr>
                            <tr>
                                <td>Minimum pressure : ${machine.minPressure}</td>
                                <td>Maximum pressure : ${machine.maxPressure}</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

