<%@ page import="Bitlab_Shop.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container" style="width: 65%;">
        <nav class="navbar navbar-expand-lg sticky-bottom bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand fw-bold" href="/task1">BITLAB SHOP</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-tasks">
                            <a class="nav-link active" aria-current="page" href="#">Top Sales</a>
                        </li>
                        <li class="nav-tasks">
                            <a class="nav-link" href="#">New Sales</a>
                        </li>
                        <li class="nav-tasks">
                            <a class="nav-link" href="#">By Category</a>
                        </li>
                        <li class="nav-tasks">
                            <a class="nav-link" href="/signin">Sign In</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <%
            Users user = (Users) request.getAttribute("user");
        %>
        <h2 class="text-center fw-bold">Hello <%=user.getFullName()%></h2>
        <p class="text-center opacity-75">This is your profile page</p>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
