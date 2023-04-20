<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="it.prova.gestionebigliettiweb.model.Biglietto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
<meta charset="ISO-8859-1">
<title>Elimina Biglietto</title>
</head>
<body class="d-flex flex-column h-100">

<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Elimina Biglietto</h5>
					    </div>
					     <% Biglietto bigliettoInPagina = (Biglietto)request.getAttribute("delete_biglietto_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Provenienza:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getProvenienza() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Destinazione:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getDestinazione() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getPrezzo() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getData()!=null? bigliettoInPagina.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    
					    <div class='card-footer'>
					   	 	<form action="ExecuteDeleteBigliettoServlet" method="post" class="row g-3" novalidate="novalidate">
					        <a href="ListArticoliServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
					        <input type="hidden" name="idToRemove" value="<%=bigliettoInPagina.getId() %>">
					        <button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					        </form>
					    </div>
					<!-- end card -->
					</div>	
			  		
			  		<div class="col-12">
								
							</div>
							
						
					    
			    	
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />

</body>
</html>