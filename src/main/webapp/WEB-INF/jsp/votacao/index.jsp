<%@ include file="../header.jsp" %>
<body>
	  <form method="post" action="${linkTo[VotacaoController].votar}">
		
		<c:forEach items="${restauranteList}" var="restaurante">
		    <input type="radio" name="restauranteId" value="${restaurante.id}"/>
		    <p>${restaurante.nome }</p>
		</c:forEach>
	    <input type="submit" value="Votar" />
	</form>
	<ul>
		
	</ul>
</body>
</html>