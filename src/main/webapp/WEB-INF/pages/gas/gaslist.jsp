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
    <div >
        <h2 class="text-success"><b>Gases</b></h2>
        <table class="table table-striped">
            <th>Name</th>
            <th>Specific Gravity</th>
            <th>Molecular Weight</th>
            <th>Polytropic Index</th>
            <th>Multiplier 1</th>
            <th>Multiplier 2</th>
            <th>Type</th>
            <th>Action</th>
            <c:forEach var="value" items="${page.content}" varStatus="status">
                <tr>
                    <td>${value.name}</td>
                    <td>${value.specificGravity}</td>
                    <td>${value.molecularWeight}</td>
                    <td>${value.polytropicIndex}</td>
                    <td>${value.multiplier1}</td>
                    <td>${value.multiplier2}</td>
                    <td>${value.gasType}</td>
                    <td align="center">
                        <button type="button" class="btn btn-primary" onclick="location.href='updategas/${value.id}'">
                            Edit
                        </button>
                    </td>
                    <td align="center">
                        <button type="button" class="btn btn-danger" onclick="location.href='deletegas/${value.id}'">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <ul class="nav nav-pills">
            <c:forEach var="i" begin="0" end="${lastPageNo-1}">
                <li class="nav-item" th:classappend="'active'">
                    <a class="nav-link"  href="/gases?pageNo=${i}">${i+1}</a>
                </li>
            </c:forEach>
        <button type="button" class="btn btn-primary" onclick="location.href='addgas'">Add new gas</button>
        </ul>
    </div>
</div>
</body>
</html>
