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
    <title>Machine</title>
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
                <li class="active">
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
<form:form action="/savemachine" modelAttribute="machine" method="post" class="form-horizontal">
    <table>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="name">Name</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" placeholder="${machine.name}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="actualMinSpeed">Actual min speed</label>
                <div class="col-md-4">
                    <input id="actualMinSpeed" name="actualMinSpeed" type="text" placeholder="${machine.actual_Min_Speed}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="actualMaxSpeed">Actual max speed</label>
                <div class="col-md-4">
                    <input id="actualMaxSpeed" name="actualMaxSpeed" type="text" placeholder="${machine.actual_Max_Speed}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="minSpeed">Min speed</label>
                <div class="col-md-4">
                    <input id="minSpeed" name="minSpeed" type="text" placeholder="${machine.min_Speed}"
                           class="form-control input-md">

                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="maxSpeed">Max speed</label>
                <div class="col-md-4">
                    <input id="maxSpeed" name="maxSpeed" type="text" placeholder="${machine.max_Speed}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="minPressure">Min pressure</label>
                <div class="col-md-4">
                    <input id="minPressure" name="minPressure" type="text" placeholder="${machine.min_Pressure}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="maxPressure">Max pressure</label>
                <div class="col-md-4">
                    <input id="maxPressure" name="maxPressure" type="text" placeholder="${machine.max_Pressure}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="originalDisplacement">Original Displacement</label>
                <div class="col-md-4">
                    <input id="originalDisplacement" name="originalDisplacement" type="text" placeholder="${machine.original_Displacement}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="originalDisplacementSpeed">Original Displacement Speed</label>
                <div class="col-md-4">
                    <input id="originalDisplacementSpeed" name="originalDisplacementSpeed" type="text" placeholder="${machine.original_Displacement_Speed}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="bladeThickness">Blade Thickness</label>
                <div class="col-md-4">
                    <input id="bladeThickness" name="bladeThickness" type="text" placeholder="${machine.blade_Thickness}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="bore">Bore</label>
                <div class="col-md-4">
                    <input id="bore" name="bore" type="text" placeholder="${machine.bore}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="dryNatGas">Dry Natural Gas</label>
                <div class="col-md-4">
                    <input id="dryNatGas" name="dryNatGas" type="text" placeholder="${machine.dry_Nat_Gas}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="blower">Blower</label>
                <div class="col-md-4">
                    <input id="blower" name="blower" type="text" placeholder="${machine.blower}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="cooling">Cooling</label>
                <div class="col-md-4">
                    <input id="cooling" name="cooling" type="text" placeholder="${machine.cooling}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="vacuum">Vacuum</label>
                <div class="col-md-4">
                    <input id="vacuum" name="vacuum" type="text" placeholder="${machine.vacuum}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="rotorDiameter">Rotor Diameter</label>
                <div class="col-md-4">
                    <input id="rotorDiameter" name="rotorDiameter" type="text" placeholder="${machine.rotor_Diameter}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="cylinderDiameter">Cylinder Diameter</label>
                <div class="col-md-4">
                    <input id="cylinderDiameter" name="cylinderDiameter" type="text" placeholder="${machine.cylinder_Diameter}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="cylinderLength">Cylinder Length</label>
                <div class="col-md-4">
                    <input id="cylinderLength" name="cylinderLength" type="text" placeholder="${machine.cylinder_Length}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="numberOfBlades">Number Of Blades</label>
                <div class="col-md-4">
                    <input id="numberOfBlades" name="numberOfBlades" type="text" placeholder="${machine.number_Of_Blades}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="currentInletPortAngle">Current Inlet Port Angle</label>
                <div class="col-md-4">
                    <input id="currentInletPortAngle" name="currentInletPortAngle" type="text" placeholder="${machine.current_Inlet_Port_Angle}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="currentOutletPortAngle">Current Outlet Port Angle </label>
                <div class="col-md-4">
                    <input id="currentOutletPortAngle" name="currentOutletPortAngle" type="text" placeholder="${machine.current_Outle_Port_Angle}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="lubrication">Lubrication</label>
                <div class="col-md-4">
                    <input id="lubrication" name="lubrication" type="text" placeholder="${machine.lubrication}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="lubrication8020">Lubrication 8020</label>
                <div class="col-md-4">
                    <input id="lubrication8020" name="lubrication8020" type="text" placeholder="${machine.lubrication8020}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="lubricationDome">Lubrication Dome</label>
                <div class="col-md-4">
                    <input id="lubricationDome" name="lubricationDome" type="text" placeholder="${machine.lubrication_Dome}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="lubricationOriginalSpeed">Lubrication Original Speed</label>
                <div class="col-md-4">
                    <input id="lubricationOriginalSpeed" name="lubricationOriginalSpeed" type="text" placeholder="${machine.lubrication_Original_Speed}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="lubricationPoints">Lubrication Points</label>
                <div class="col-md-4">
                    <input id="lubricationPoints" name="lubricationPoints" type="text" placeholder="${machine.lubrication_Points}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label class="col-md-4 control-label" for="lubricationK">Lubrication K</label>
                <div class="col-md-4">
                    <input id="lubricationK" name="lubricationK" type="text" placeholder="${machine.lubricationTK}"
                           class="form-control input-md">
                </div>
            </td>
        </tr>
        <button class="btn btn-primary">submit</button>

    </table>
</form:form>
</body>
</html>
