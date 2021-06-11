<%--
  Created by IntelliJ IDEA.
  User: mohamed
  Date: 09/06/2021
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Application</title>
</head>
<body>
<!-- Modal -->
<div class="modal product-modal fade" id="product-modal">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <i class="tf-ion-close"></i>
    </button>
    <div class="modal-dialog " role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-8 col-sm-6 col-xs-12">
                        <div class="modal-image">
                            <img class="img-responsive" src="images/shop/products/modal-product.jpg" alt="product-img" />
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <div class="product-short-details">
                            <h2 class="product-title">

                                <c:if test="${not empty param.price}">

                                    <c:out value="${param.price}"/>

                                </c:if>
                                ${param.productname}
                            </h2>
                            <p class="product-price">$${param.price}</p>
                            <p class="product-short-description">
                               meilleur: ${param.productname}  .
                            </p>

                                Add To Cart
                            </a>
                            <a href="product-single.jsp" class="btn btn-transparent">${param.productname}</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.modal -->
</body>
</html>
