<%-- 
    Document   : Home
    Created on : Mar 10, 2023, 3:35:32 PM
    Author     : Admin
--%>
<%@page import="java.text.DecimalFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DecimalFormat dcf = new DecimalFormat("#,##0.000");
    request.setAttribute("dcf", dcf);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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

        <!-- =======================================================
        * Template Name: NiceAdmin - v2.5.0
        * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->   
    </head>
    <body>
        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="home" class="logo d-flex align-items-center">
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
                    <a class="nav-link nav-icon" href="Cart.jsp">
                        <i>Cart<span class="badge bg-primary badge-number">${cart_list.size()}</span></i>
                    </a>
                    <a class="nav-link nav-icon" href="Orders.jsp">
                        <i>Order</i>
                    </a>
                    <!-- End Notification Nav -->
                    <!-- End Messages Nav -->
                    <c:if test="${sessionScope.account.userName != null}">
                        <li class="nav-item dropdown pe-3">
                            <a class="nav-link nav-profile d-flex align-items-center pe-0" href="" data-bs-toggle="dropdown">
                                <img src="assets/img/account/${sessionScope.account.userImg}" class="rounded-circle" width="50" height="50">
                                <span>${sessionScope.account.accountName}</span>
                                <span class="d-none d-md-block dropdown-toggle ps-2"></span>
                            </a><!-- End Profile Image Icon -->

                            <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                                <!--                                <li>
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
                    </c:if> 
                </ul>
            </nav><!-- End Icons Navigation -->

        </header><!-- End Header -->

        <!-- ======= Sidebar ======= -->
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
                        <a class="nav-link " href="product">
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
                <h1>Home Page</h1>

            </div><!-- End Page Title -->

            <div class="container">
                <div class="row">
                    <form action="category" method="get">
                        <select name="categoryId">
                            <c:forEach items="${listC}" var="category">
                                <option value="${category.categoryId}">${category.categoryName}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn btn-primary btn-sm">Go</button>
                    </form>
                    <c:forEach var="product" items="${listP}">
                        <div class="col-xs-4 col-md-4">
                            <form action="cart" method="get">
                                <div class="prod-info-main prod-wrap clearfix" style="width: 100%">
                                    <div class="row">
                                        <div class="col-md-7 col-sm-12 col-xs-12" >
                                            <div class="product-image" style="width: 300px; height: 300px">
                                                <img src="assets/img/product/${product.proImg}" style="width: 100%; height: 100%">
                                            </div>
                                        </div>
                                        <div class="col-md-5 col-sm-12 col-xs-12">
                                            <div class="product-deatil">
                                                <h5 class="name" style="text-align:center; padding-right: 10px"><a href="#">${product.proName}</a></h5>
                                                <p name="proPrice" class="price-container" style="text-align:center; padding-right: 10px"><span>${dcf.format(product.proPrice)} VNĐ</span></p>
                                                <span class="tag1"></span>
                                            </div>
                                            <div class="description">
                                                <!--<input type="number" name="soluong" id = "soluong" min="0" class="form-control" required style="width: 100%">-->
                                            </div>
                                            <div class="product-info smart-form">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <input type="hidden" value="${product.proId}" name="id">
                                                        <input type="hidden" value="${product.proName}" name="name">
                                                        <input type="hidden" value="${product.proPrice}" name="proPrice">
                                                        <input type="hidden" value="${product.proImg}" name="image">
                                                        <input type="submit" class="btn btn-danger" herf="cart?id=${product.proId}" value="Add to Cart" style="padding-right: 10px">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form> 
                        </div>
                    </c:forEach>
                </div>
            </div>
            <!-- Left side columns -->

            <!-- Sales Card -->
            <!-- End Sales Card -->

            <!-- Revenue Card -->
            <!-- End Revenue Card -->

            <!-- Customers Card -->
            <!-- End Customers Card -->

            <!-- Reports -->
            <!-- End Reports -->

            <!-- Recent Sales -->
            <!-- End Recent Sales -->

            <!-- Top Selling -->
            <!-- End Top Selling -->

            <!-- End Left side columns -->

            <!-- Right side columns -->

            <!-- Recent Activity -->
            <!-- End Recent Activity -->

            <!-- Budget Report -->
            <!-- End Budget Report -->

            <!-- Website Traffic -->
            <!-- End Website Traffic -->

            <!-- News & Updates Traffic -->
            <!-- End News & Updates -->

            <!-- End Right side columns -->


        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
        <footer id="footer" class="footer">
            <div class="copyright">
                Call us: <strong><span>+999999999</span></strong>.<br>
                Email: <strong><span>petshop.store@gmail.com</span></strong>.
            </div>
            <!--            <div class="credits">
                             All the links in the footer should remain intact. 
                             You can delete the links only if you purchased the pro version. 
                             Licensing information: https://bootstrapmade.com/license/ 
                             Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ 
                            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                        </div>-->
        </footer><!-- End Footer -->

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
