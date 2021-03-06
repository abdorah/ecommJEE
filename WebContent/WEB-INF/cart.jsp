<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  ================================================== -->
  <meta charset="utf-8">
  <title>Application</title>

  <!-- Mobile Specific Metas
  ================================================== -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="Construction Html5 Template">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0">
  <meta name="author" content="Themefisher">
  <meta name="generator" content="Themefisher Constra HTML Template v1.0">
  
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />
  
  <!-- Themefisher Icon font -->
  <link rel="stylesheet" href="plugins/themefisher-font/style.css">
  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
  
  <!-- Animate css -->
  <link rel="stylesheet" href="plugins/animate/animate.css">
  <!-- Slick Carousel -->
  <link rel="stylesheet" href="plugins/slick/slick.css">
  <link rel="stylesheet" href="plugins/slick/slick-theme.css">
  
  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="css/style.css">

</head>

<body id="body">

<!-- Start Top Header Bar -->
<section class="top-header">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-xs-12 col-sm-4">
				<div class="contact-number">
					<i class="fa fa-mobile" aria-hidden="true"></i>
					<span>+212- 610-203040</span>
				</div>
			</div>
			<div class="col-md-4 col-xs-12 col-sm-4">
				<!-- Site Logo -->
				<div class="logo text-center">

						<svg width="135px" height="29px" viewBox="0 0 155 29" version="1.1" xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink">
							<g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" font-size="40"
								font-family="AustinBold, Austin" font-weight="bold">
								<g id="Group" transform="translate(-108.000000, -297.000000)" fill="#000000">
									<text id="AVIATO">
										<tspan x="108.94" y="325">Magasin</tspan>
									</text>
								</g>
							</g>
						</svg>
					</a>
				</div>
			</div>

		</div>
	</div>
</section><!-- End Top Header Bar -->


<!-- Main Menu Section -->


<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">cadie</h1>
					<ol class="breadcrumb">
						<li><a href="${pageContext.request.contextPath }/Accueil">Acceuil</a></li>
						<li class="active">cadie</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>



<div class="page-wrapper">
  <div class="cart shopping">
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-md-offset-2">
          <div class="block">
            <div class="product-list">
             <form  method="GET"  id="myform" action="Commandes">
				  <table class="table">
					  <thead>
					  <tr>
						  <th class="">Nom de l'article</th>
						  <th class="">Prix unitaire</th>
						  <th class="">Actions</th>
						  <th class="">Quantite</th>
						  <th class="">Enregistrer</th>
					  </tr>
					  </thead>
					  <tbody>
					  <script>
						  function submitform() {
							  document.getElementById('myform').submit();

						  }
					  </script>
					  <c:forEach items="${productsselected}" var="produits" >
					  <tr class="">
						  <td class="">
							  <div class="product-info">
								  <img width="80" src="images/shop/cart/cart-1.jpg" alt="" />
								  <a href="#!">${produits.getNomPro()}</a>
							  </div>
						  </td>
						  <td class="">${produits.getPuPro()}</td>
						  <td class="">
							  <a class="product-remove" href="${pageContext.request.contextPath }/Commandes?page=cart&action=remove&numppro=${produits.numPro }">Suprimer</a>
						  </td>
						  <td class="">

							  <input type="number"  min="1" style="height: 40px;width: 90px; margin:0 15px" class="form-control" id="qte" name="qte"  value="${param.qte}" placeholder="quantite" required>

						  </td>
							<td class="">
								<c:out value="${param.name}"/>
								
								<!-- <a href="" >
									Modifier
								</a> -->
								<!-- <input type="text" name="name"
								value="<c:out value="${param.name}"/>" /> -->
								<button onclick="alert('Commande enregistree.')" class="btn btn-primary text-center"  type="submit">Enregistrer</button>

							</td>
						  <td class="">
							  <input type="number" action="modifier" name="numpr" value="${produits.numPro }" hidden>
						  </td>

					  </tr>
                       </c:forEach>


					  </tbody>
				  </table>

				 <a  class="btn btn-main text-center" href="${pageContext.request.contextPath }/Commandes?page=cart&action=valider">Valider</a>
              </form>
			  <a href="${pageContext.request.contextPath }/Accueil" class="btn btn-main mt-20">Continuer les Achats</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>




    <!-- 
    Essential Scripts
    =====================================-->
    
    <!-- Main jQuery -->
    <script src="plugins/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap 3.1 -->
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- Bootstrap Touchpin -->
    <script src="plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
    <!-- Instagram Feed Js -->
    <script src="plugins/instafeed/instafeed.min.js"></script>
    <!-- Video Lightbox Plugin -->
    <script src="plugins/ekko-lightbox/dist/ekko-lightbox.min.js"></script>
    <!-- Count Down Js -->
    <script src="plugins/syo-timer/build/jquery.syotimer.min.js"></script>

    <!-- slick Carousel -->
    <script src="plugins/slick/slick.min.js"></script>
    <script src="plugins/slick/slick-animation.min.js"></script>

    <!-- Google Mapl -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
    <script type="text/javascript" src="plugins/google-map/gmap.js"></script>

    <!-- Main Js File -->
    <script src="js/script.js"></script>
    


  </body>
  </html>
