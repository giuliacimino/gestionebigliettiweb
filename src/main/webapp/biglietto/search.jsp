<%@page import="it.prova.gestionebigliettiweb.model.Biglietto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
<meta charset="ISO-8859-1">
<title>Cerca Biglietto</title>
</head>
<body class="d-flex flex-column h-100">

<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Cerca Biglietto</h5> 
				    </div>
				    <div class='card-body'>
		
							
		
		
							<form method="post" action="ExecuteSearchBigliettoServlet" class="row g-3" novalidate="novalidate">
							
								<% Biglietto bigliettiInPagina = (Biglietto)request.getAttribute("search_biglietto_attr"); %>
							
								<div class="col-md-6">
									<label for="codice" class="form-label">Provenienza: </label>
									<input type="text" name="provenienza" id="provenienza" class="form-control" placeholder="Inserire la provenienza" >
								</div>
								
								<div class="col-md-6">
									<label for="descrizione" class="form-label">Destinazione: </label>
									<input type="text" name="destinazione" id="destinazione" class="form-control" placeholder="Inserire la destinazione" >
								</div>
							
								<div class="col-md-6">
									<label for="prezzo" class="form-label">Prezzo:</label>
									<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo" >
								</div>
								
								<div class="col-md-3">
									<label for="dataNascita" class="form-label">Data:</label>
									<input class="form-control"  name="data" id="data" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" >
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />

</body>
</html>