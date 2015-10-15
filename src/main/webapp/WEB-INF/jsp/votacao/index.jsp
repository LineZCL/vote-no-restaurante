<%@ include file="../header.jsp" %>
<body>	
	<div class="principalDiv">
		<div class="panel panel-default">
			<div class="panel-heading">Qual seu restaurante favorito?</div>
		  	<div class="panel-body">
		    	<form action="/votar" method="post" >
		    		<c:if test="${mensagemErro != null && mensagemErro != ''}">
		    			<div class="alert alert-danger" role="alert">${mensagemErro }</div>
		    		</c:if>
					<c:forEach items="${restauranteList}" var="restaurante">
						<div class="opcRestaurantes">
							<div class="input-group">
						    	<span class="input-group-addon">
						        	<input type="radio" name="restauranteId" value="${restaurante.id}">
						      	</span>
						      	<input type="text" class="form-control" value="${restaurante.nome }">
					    	</div>
				    	</div>
					</c:forEach>
			    	<input type="submit" value="Votar" class="btn btn-default" />
				</form>
		  	</div>
		</div>
	</div>
</body>
</html>