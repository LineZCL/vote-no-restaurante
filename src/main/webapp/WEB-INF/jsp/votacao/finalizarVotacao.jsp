<%@ include file="../header.jsp" %>
<body>
	<form method="post"
		action="${linkTo[VotacaoController].finalizarVotacao}">
		Nome: <input type="text" name="usuario.nome" /><br /> 
		Email: <input	type="text" name="usuario.email" /><br />
		<input type="submit"value="Salvar"/>
	</form>
</body>
</html>