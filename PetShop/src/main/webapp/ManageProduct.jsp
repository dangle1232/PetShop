<%-- 
    Document   : ManageProduct
    Created on : Mar 16, 2023, 8:09:53 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet Shop</title>
        <!-- Favicons -->
        <link href="assets/img/icon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
        <!-- JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!-- =======================================================
        * Template Name: NiceAdmin - v2.5.0
        * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>
    <body>
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="/PetShop/home" class="logo d-flex align-items-center">
                    <img src="assets/img/icon.png" alt="">
                    <span class="d-none d-lg-block">Pet Shop</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div><!-- End Logo -->

            <div class="search-bar">
                <form class="search-form d-flex align-items-center" method="POST" action="#">
                    <input type="text" name="query" placeholder="Search" title="Enter search keyword">
                    <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                </form>
            </div><!-- End Search Bar -->

            <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">

                    <li class="nav-item d-block d-lg-none">
                        <a class="nav-link nav-icon search-bar-toggle " href="#">
                            <i class="bi bi-search"></i>
                        </a>
                    </li><!-- End Search Icon-->
                    <!-- End Notification Nav -->
                    <!-- End Messages Nav -->
                    <li class="nav-item dropdown pe-3">
                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="" data-bs-toggle="dropdown">
                            <img src="assets/img/account/${sessionScope.account.userImg}" alt="Profile" class="rounded-circle" width="50" height="50">
                            <span>${sessionScope.account.accountName}</span>

                            <span class="d-none d-md-block dropdown-toggle ps-2"></span>
                        </a><!-- End Profile Image Icon -->

                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <!--                            <li>
                                                            <a class="dropdown-item d-flex align-items-center" href="">
                                                                <i class="bi bi-person"></i>
                                                                <span>Hello ${sessionScope.account.accountName}</span>
                                                            </a>
                                                        </li>-->

                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="loaduser?uid=${sessionScope.account.userId}">
                                    <i class="bi bi-gear"></i>
                                    <span>Account Settings</span>
                                </a>
                            </li>

                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="logout">
                                    <i class="bi bi-box-arrow-right"></i>
                                    <span>Sign Out</span>
                                </a>
                            </li>
                        </ul><!-- End Profile Dropdown Items -->
                    </li><!-- End Profile Nav -->
                </ul>
            </nav><!-- End Icons Navigation -->

        </header><!-- End Header -->
        <aside id="sidebar" class="sidebar">

            <ul class="sidebar-nav" id="sidebar-nav">
                <li class="nav-item">
                    <a class="nav-link " href="home">
                        <i class="bi bi-grid"></i>
                        <span>Home</span>
                    </a>
                </li><!-- End Dashboard Nav -->
                <c:if test="${sessionScope.account.roleId == 1}">
                    <li class="nav-item">
                        <a class="nav-link " href="">
                            <i class="bi bi-grid"></i>
                            <span>Manage Product</span>
                        </a>
                    </li><!-- End Dashboard Nav -->

                    <li class="nav-item">
                        <a class="nav-link " href="account">
                            <i class="bi bi-grid"></i>
                            <span>Manage Account</span>
                        </a>
                    </li><!-- End Dashboard Nav -->
                </c:if>
                <!-- End Components Nav -->

                <!-- End Forms Nav -->

                <!-- End Tables Nav -->

                <!-- End Charts Nav -->

                <!-- End Icons Nav -->


                <!-- End Profile Page Nav -->

                <!-- End F.A.Q Page Nav -->

                <!-- End Contact Page Nav -->
                <c:if test="${sessionScope.account.userName == null}">
                    <li class="nav-item">
                        <a class="nav-link collapsed" href="Signup.jsp">
                            <i class="bi bi-card-list"></i>
                            <span>Register</span>
                        </a>
                    </li><!-- End Register Page Nav -->
                    <li class="nav-item">
                        <a class="nav-link collapsed" href="Login.jsp">
                            <i class="bi bi-box-arrow-in-right"></i>
                            <span>Login</span>
                        </a>
                    </li><!-- End Login Page Nav -->
                </c:if>
                <!-- End Error 404 Page Nav -->

                <!-- End Blank Page Nav -->

            </ul>

        </aside><!-- End Sidebar-->
        <main id="main" class="main">
            <div class="pagetitle">
                <h1>Manage Product</h1>
                <button class="btn btn-primary"><a class="nav-link collapsed" href="add">Add new product</a></button>

                <!--          <nav>
                            <ol class="breadcrumb">
                              <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                              <li class="breadcrumb-item active">Dashboard</li>
                            </ol>
                          </nav>-->
            </div>

            <div class="card">
                <div class="card-body">
                    <table class="table table-stripped">
                        <p class="text-danger">${error}</p>

                        <thead>
                            <tr>
                                <th scope="col" style="text-align: center">Id</th>
                                <th scope="col" style="text-align: center">Name</th>
                                <th scope="col" style="text-align: center">Category</th>
                                <th scope="col" style="text-align: center">Price</th>
                                <th scope="col" style="text-align: center">Amount</th>
                                <th scope="col" style="text-align: center">Image</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${listP}">
                                <tr>
                                    <th scope='row' style="text-align: center">${product.proId}</th>
                                    <th scope='row' style="text-align: center">${product.proName}</th>
                                    <th scope='row' style="text-align: center">${product.proCategory}</th>
                                    <th scope='row' style="text-align: center"><fmt:formatNumber value="${product.proPrice}" type="number" pattern="#,##0.000" /></th>
                                    <th scope='row' style="text-align: center">${product.proAmount}</th>
                                    <th scope='row' style="text-align: center"><img src="${product.proImg}" style="width: 100px; height: 100px"></th>
                                    <td>
                                        <a href="deleteproduct?pid=${product.proId}">DELETE</a>
                                        <a href="load?pid=${product.proId}">EDIT</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.umd.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>
        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>
</html>
