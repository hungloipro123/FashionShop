<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>VDreamer</title>
        <style>
            /* Reset css */
            body {
                font-family: Arial, Helvetica, sans-serif;
            }
            * {
                box-sizing: border-box;
            }

            .clear {
                clear: both;
            }

            .text-white {
                color: #fff;
            }

            .col {
                float: left;
                padding-left: 8px;
                padding-right: 8px;
            }

            .col-full {
                width: 100%;
            }
            .col-half {
                width: 50%;
            }

            .row {
                margin-left: -8px;
                margin-right: -8px;
            }

            .mt-8 {
                margin-top: 8px;
            }

            .mt-16 {
                margin-top: 16px;
            }

            .mt-40 {
                margin-top: 40px;
            }
            /* main */
            #main {

            }

            #header {
                height: 46px;
                background-color: #000;
                position: fixed;
                top: 0;
                left: 0;
                right: 0;
                z-index: 3;
            }

            /* begin logo-shop */
            #header .logo-shop {
                float: left;
                padding: 0px 21px;

            }

            #header .logo-shop:hover {
                background-color: #f44336;
                cursor: pointer;
            }

            #header .logo-icon {
                color: #fff;
                font-size: 20px;
                line-height: 46px;
            }

            /* begin nav */
            #nav {
                margin-left: 160px;
                display: inline-block;
            }

            #nav, .subnav {
                list-style-type: none;
            }

            #nav > li, #nav .form-search >li {
                display: inline-block;
            }

            #nav li {

                position: relative;

            }

            #nav li:hover .subnav {
                display: block;
            }

            #nav > li > a {
                color: #fff;
                text-transform: uppercase;
            }

            #nav li a{

                text-decoration: none;
                line-height: 46px;
                padding: 0px 24px;
                display: inline-block;
            }

            #nav > li:hover > a,
            #nav .subnav li:hover a {
                color: #000;
                background-color: #ccc;
            }


            #nav .subnav {
                display: none;
                position: absolute;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
                min-width: 160px;
                top: 100%;
                left: 0;
            }

            #nav .subnav a {
                color:  #333;
                padding: 0px 12px;
                line-height: 38px;

            }

            #nav .nav-arround-down {
                font-size: 14px;
            }
            #nav .header-search-btn {
                padding:5px;
            }
            /* begin icon header */
            #header .btn-icon {
                float: right;
                padding: 0px 21px;

            }

            #header .btn-icon a {
                text-decoration: none;
            }

            #header .btn-icon:hover {
                background-color: #555;
                cursor: pointer;
            }

            #header .header-icon {
                color: #fff;
                font-size: 20px;
                line-height: 46px;
            }

            /* Start slider */
            #slider {
                margin-top: 46px;
                position: relative;
            }

            #slider .text-content {
                position: absolute;
                bottom: 48px;
                color: #fff;
                text-align: center;
                width: 100%;
            }


            #slider .text-description {
                border: 2px solid black;
                float: left;
                width: 20%;
                font-size: 15px;
                font-weight: 600;
                background-color: yellow;
                color: #000;
                padding-top: 10px;
                padding-bottom: 10px;
                margin: 0 100px;
            }

            #slider .text-description:hover {
                color: #000;
                background-color: #fff;
            }

            /* content */
            #content {
                min-height: 1000px;
            }

            #content .content-section {

                width: 1200px;
                margin-left: auto;
                margin-right: auto;
                padding: 48px 0 112px;
            }

            #content .background-product {
                background-color: #fff;
            }

            #content .section-heading {
                font-size: 36px;
                font-weight: 700;
                letter-spacing: 1px; /*khoang cach cac chu cai*/
                text-align: center;
            }

            #content .section-sub-heading {
                font-style: italic; /*chu nghieng*/
                text-align: center;
                font-size: 15px;
                opacity: 0.6; /*lam mo chu*/
                margin-top: 25px;
            }
            /* Product basic */

            #content .product-list {
                margin-top: 48px;
            }

            #content .product-item {
                float: left;
                width: 100%;
                text-align: center;
            }

            #content .product-name {
                text-transform: uppercase;
                font-size: 20px;
                font-weight: 400;

            }

            #content .product-img {
                width: 154px;
                margin-top: 15px;
                border-radius: 4px;
            }

            /* Category */
            #content .content-Category-section {
                width: 1400px;
                margin-left: auto;
                margin-right: auto;
                padding: 48px 0 112px;
            }

            #content .category-list {
                margin-top: 48px;
            }
            #content .category-img {
                height: 400px;
                margin-top: 15px;
                margin-left: 10px;
                border-radius: 4px;
            }

            #content .category-item {
                float: left;
                width: 24%;
                text-align: center;

            }

            #content .category-item:hover {
                opacity: 0.7;
            }



            #content .category-content {
                color: #000;
                font-weight: 600;
                margin-top: 190px;
                border: 1px solid #fff;
                background-color: #fff;
                border-radius: 20px;
                margin: 190px 30px 190px 30px;
                padding-top: 10px;
                padding-bottom: 10px;
            }

            /* Blog */
            .blog-section {
                background-color: #000;
            }

            .blog-list {
                margin: 32px -8px 0;
            }

            .blog-item {
                padding: 0 8px;
                float: left;
                width: 50%;
            }

            .blog-img {
                width: 100%;
                display: block;
            }

            .blog-img:hover {
                opacity: 0.8;
            }

            .blog-body {
                background-color: #fff;
                padding: 16px;
                font-size: 15px;
            }

            .blog-heading {
                font-size: 40px;
                font-weight: 600;
            }

            .blog-desc {
                margin-top: 15px;
                line-height: 1.4;
            }

            .place-buy-btn {
                color: #fff;
                background-color: #000;
                text-decoration: none;
                padding: 11px 16px;
                display: inline-block;
                margin-top: 15px;

            }

            .place-buy-btn:hover {
                color: #000;
                background-color: #ccc;
            }

            /* Contact */
            .contact-content {
                margin-top: 48px;
            }

            .contact-info {
                font-size: 18px;
                line-height: 1.5;
            }

            .contact-info > p > i {
                width: 30px;
                display: inline-block;
            }

            .contact-form {
                font-size: 15px;
            }

            .contact-form .form-control {
                margin-top: 12px;
                padding: 10px;
                border: 1px solid #ccc;
                width: 100%;
                outline: 1px solid blue;
            }

            .contact-form .form-submit-btn {
                background-color: #000;
                color: #fff;
                border: 1px solid #000;
                padding: 10px 16px;
                float: right;
            }

            #footer {
                background-color: #000;
            }

            #footer .map {
                width: 60%;
                float: left;
                padding-top: 50px;
                padding-bottom: 50px;
                padding-left: 100px;
            }

            #footer .info-footer {
                width: 40%;
                float: left;
                min-height: 400px;
                padding-right: 20px;
            }

            #footer .content-footer {
                float:left;
                padding-top: 50px;
                padding-bottom: 20px;
                width: 40%;
                color: #fff;
            }

            #footer .feedback-footer {
                color: #fff;
                float: left;
                width: 40%;
                margin-left: 100px;
            }

            #footer .Button-Feedback {
                background-color: red;
                color: #fff;
                border: 1px solid #000;
                padding: 10px 16px;
                float: left;
                border-radius: 20px;
            }

            #footer .contact-info {
                font-size: 18px;
                line-height: 1.8;
            }


            /* css by son - product list */
            #wrapper{
                margin-top: 52px;
            }
            .headline .new-product{
                padding: 5% 10%;
                color: black;
                font-size: 100%;
                text-transform: uppercase;
                border: 2px solid gainsboro;
                display: inline-block;
                font-weight: 900;
            }
            .headline{
                text-align: center;
            }
            .product-infor a{
                text-decoration: none;
            }
            .product-name{
                color: black;
                padding: 3px 0px;
                font-weight: bold;
            }
            .product-price{
                color: #ff3102;
                padding: 2px 0px;
                margin-right: 1%;
                font-size: 100%;
            }
            .product-top a{
                display: block;
            }
            .product-top{
                position: relative;
                overflow: hidden;
                border-radius: 5%;
            }
            .product-top:hover a.buy-now{
                bottom: 0px;
                color: white;
            }

            .product-top:hover a img{
                filter: opacity(80%);
            }
            .product-top .buy-now{
                text-transform: uppercase;
                text-decoration: none;
                text-align: center;
                background-color: #446084;
                color: white;
                padding: 10px 0px;
                position: absolute;
                width: 100%;
                bottom: -44px;
                transition: 0.25s ease-in-out;
                opacity: 0.85;
            }

            del{
                color: #c4c4c4;
                float: right;
            }
            .reviews-rating {
                position: absolute;
                top: 0;
                padding: 0px 10px;
            }
            .reviews-rating__star{
                width: 10px;
                height: 10px;
                margin: 0 2px;
                background-image: url(../..//images/star-none.svg);
                display: inline-block;
            }
            .is-active{
                background-image: url(../..//images/star.svg);
            }
            .is-half{
                background-image: url(../..//images/star-half.svg);
            }
            .filter-search__control{
                height: 76%;
                width: 72%;
                padding: 2% 2%;
                border: 1px solid #d9d9d9;
                border-radius: 16px;
                z-index: 2;
            }
            .input-search{
                position: relative;
                overflow: hidden;
                margin: 0px 4%;
                height: 100%;
            }
            .button-search{
                position: absolute;
                width: 25px;
                height: 25px;
                margin: 2% -15%;
                border: none;
                color: white;
                background-image: url(../..//images/icon-search.svg);
                background-repeat: no-repeat;
                z-index: 1;
            }
            .dropdown-font-new{
                display: block;
                width: 66%;
                padding: 0.375rem 2.25rem 0.375rem 0.75rem;
                -moz-padding-start: calc(0.75rem - 3px);
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: #212529;
                background-color: #fff;
                background-image: url(../..//images/icon-v.svg);
                background-repeat: no-repeat;
                background-position: right 0.75rem center;
                background-size: 16px 12px;
                border: 1px solid #ced4da;
                border-radius: 5.25rem;
                transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                margin: 0% 4%;
            }
            .sort{
                margin: 0 10px;
            }
            .product-down{
                margin: 2% 4%;
            }
            .pagination{
                justify-content: center;
                margin: 20px 0px;
            }

            #carouselExampleDark{
                z-index: 1;
                margin-top: 46px;
            }
            .product-thumb img{
                height: 100%;
                width: 100%;
            }
            .list h2{
                font-weight: 900;
                margin-right: 5%;
            }
            .list {
                text-align: center
            }

            .open-button {
                background-color: #555;
                color: white;
                padding: 16px 20px;
                border: none;
                cursor: pointer;
                opacity: 0.8;
                position: fixed;
                bottom: 23px;
                right: 28px;
                width: 280px;
            }

            /* Button used to open the contact form - fixed at the bottom of the page */
            .changepassword_open-button {
                background-color: #555;
                color: white;
                padding: 16px 20px;
                border: none;
                cursor: pointer;
                opacity: 0.8;
                position: fixed;
                bottom: 23px;
                right: 28px;
                width: 280px;
            }

            /* The popup form - hidden by default */
            .changepassword_form-popup {
                display: none;
                bottom: 0;
                z-index: 2;
                position: fixed;
                width: 300px;
                height: 200px;
                top: 30%;
                left: 38%;
                margin-top: -100px; /* Negative half of height. */
                margin-left: -100px; /* Negative half of width. */
            }

            /* Add styles to the form container */
            .changepassword_form-container {
                width: 600px;
                Xpadding: 10px;
                border-radius:20px;
                background-color: white;
            }

            /* Full-width input fields */
            .changepassword_form-container input[type=text], .changepassword_form-container input[type=password] {
                width: 90%;
                padding: 15px;
                margin: 5px 0 22px 0;
                border: none;
                background: #f1f1f1;
                margin-left: 25px;
            }

            /* When the inputs get focus, do something */
            .changepassword_form-container input[type=text]:focus, .changepassword_form-container input[type=password]:focus {
                background-color: #ddd;
                outline: none;
            }

            /* Set a style for the submit/login button */
            .changepassword_form-container .changepassword_btn {
                background-color: #2f5acf;
                color: white;
                padding: 16px 20px;
                border: none;
                cursor: pointer;
                width: 90%;
                margin-bottom:10px;
                opacity: 0.8;
                border-radius: 20px;
                margin-left: 25px;
                margin-bottom: 25px;
            }
            /* Add some hover effects to buttons */
            .changepassword_form-container .changepassword_btn:hover {
                background: black;
                opacity: 1;
            }
            .changepassword_bd_rd{
                border-radius: 20px;
            }
            .changepassword_form-container label b {
                margin-left: 25px;
            }
            /* style user profile */
            .back:hover {
                color: #000;
                cursor: pointer
            }

            .labels {
                font-size: 5px
            }

            .add-experience:hover {
                background: #000;
                color: #fff;
                cursor: pointer;
                border: solid 1px #000
            }
            [type="radio"]:checked + span:after,
            [type="radio"].with-gap:checked + span:after {
                border: 2px solid #000;
            }


            [type="radio"]:checked + span:after,
            [type="radio"].with-gap:checked + span:before,
            [type="radio"].with-gap:checked + span:after {
                background-color: #000;
            }
        </style>
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
        <%@include file="components/javascript.jsp" %>
    </head>

    <body>
        <div id="main">

            <%@include file="components/header.jsp" %>
            <%@include file="components/account.jsp" %>
            <!--Slider-->


            <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
                <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel" >
                    <div class="carousel-indicators">

                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <c:forEach begin="1" end="${sessionScope.totalSlider-1}" var="c">
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="${c}" aria-label="Slide ${c+1}"></button>
                        </c:forEach>

                    </div>

                    <div class="carousel-inner">

                        <c:forEach items="${sessionScope.listSlider_HomePageAll}" var="s" >
                            <div class="carousel-item ${s.id == sessionScope.sliderFirst.id ? "active" : ""}">
                                <a href="${s.backlink}"><img src="${s.slider_image}" class="d-block w-100" alt="..."></a>

                            </div> 

                        </c:forEach>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>



            <!-- Content -->
            <div id="content">
                <div class="content-section background-product" style="width: 1500px">


                    <!-- Base Product -->
                    <h2 class="section-heading">Basic Items</h2>
                    <br>
                    <div  class="container-fluid">
                        <div class="row">
                            <c:forEach items="${sessionScope.list4product}" var="p">
                                <div class="col-md-2 product-down">
                                    <div class="row">
                                        <div class="product-item">
                                            <div class="product-top">
                                                <div class="reviews-rating">

                                                    <c:forEach var="i" begin="0" end="4">
                                                        <c:if test="${(p.rated_star - i) >= 1}">
                                                            <div class="reviews-rating__star is-active"></div> 
                                                        </c:if>
                                                        <c:if test="${(p.rated_star - i) < 1 && (p.rated_star - i) > 0}">
                                                            <div class="reviews-rating__star is-active is-half"></div> 
                                                        </c:if>
                                                        <c:if test="${(p.rated_star - i) <= 0}">
                                                            <div class="reviews-rating__star"></div> 
                                                        </c:if>

                                                    </c:forEach>

                                                </div>
                                                <a href="" class="product-thumb">
                                                    <a href="list-detail?productId=${p.id}&categoryId=${p.category_id}">
                                                        <img src="${p.image}" height="365px" width="230px" alt="">
                                                    </a>


                                                </a>

                                                <a href="addcart?productId=${p.id}" class="buy-now" onclick="checkLogin(event)">Buy Now</a>

                                            </div>
                                            <div class="product-infor">
                                                <a href="" class="product-name">${p.name}</a>
                                                <div class="product-price">
                                                    <c:if test="${p.sale_price != 0}">
                                                        ${p.sale_price}đ
                                                        <del>${p.original_price}đ</del>
                                                    </c:if>
                                                    <c:if test="${p.sale_price == 0}">
                                                        ${p.original_price}đ
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>


                <div class="content-Category-section background-product"><!--

                    <!-- Product list -->
                    <h2 class="section-heading">Category</h2>
                    <div class="category-list">
                        <a href="list?&categoryId=1"><div class="category-item category-img" style="background: url('./assets/img/categoryImg/category1.jpg')
                                                          top center / cover no-repeat">
                                <div class="category-content">T-Shirt</div>
                            </div></a>

                        <a href="list?&categoryId=2"><div class="category-item category-img" style="background: url('./assets/img/categoryImg/category2.jpg')
                                                          top center / cover no-repeat">
                                <div class="category-content">Balo</div>
                            </div></a>

                        <a href="list?&categoryId=3"><div class="category-item category-img" style="background: url('./assets/img/categoryImg/category3.jpg')
                                                          top center / cover no-repeat">
                                <div class="category-content">Crossbody Bag</div>
                            </div></a>


                        <a href="list?&categoryId=4"><div class="category-item category-img" style="background: url('./assets/img/categoryImg/category4.jpg')
                                                          top center / cover no-repeat">
                                <div class="category-content">Accessory
                                </div>
                            </div></a>







                        <div class="clear"></div>
                    </div> 
                </div>
                <!-- Blog -->
                <div class="blog-section">
                    <div class="content-section">
                        <h2 class="section-heading text-white">Raising the Standard</h2>
                        <p class="section-sub-heading text-white">Proudly Vietnamese!</p>

                        <!-- blog list hot -->
                        <div class="blog-list">

                            <c:forEach items="${sessionScope.listBlog_HomePage}" var="c">
                                <div class="blog-item">
                                    <img src="${c.thumbnail}" alt="" class="blog-img" style="width: 592px; height: 450px">
                                    <div class="blog-body" style="min-height: 340px">
                                        <h3 class="blog-heading" style="font-size: 40px">${c.title}</h3>
                                        <p class="blog-desc">${c.brief_infor}</p>
                                        <a href="blogDetail?blog_id=${c.blog_id}&categoryBlog_id=${c.categoryBlog_id}" class="place-buy-btn">Learn more</a>
                                    </div>
                                </div>
                            </c:forEach>

                            <div class="clear"></div>
                        </div> 
                    </div>

                </div>
                <script>
                    var categoryLinks = document.querySelectorAll('.category-link');
                    categoryLinks.forEach(function (link) {
                        link.addEventListener('click', function () {
                            categoryLinks.forEach(function (link) {
                                link.classList.remove('active');
                            });
                            this.classList.add('active');
                        });
                    });
                </script>

                <%@include file="components/footer.jsp" %>
                </body>
                </html>