<%@ include file="../header.jsp"%>
<body>
	<div class="principalDiv">
		<div class="panel panel-default">
			<div class="panel-heading">Para finalizar sua votação, preencha
				as informações abaixo</div>
			<div class="panel-body">
				<form method="post" action="<c:url value='//finalizarVotacao'/>">
					<div class="inputsDivs">
						Nome: <input type="text" name="usuario.nome" class="form-control"/><br /> 
						Email: <input type="text" name="usuario.email" class="form-control" />
						<br />
					</div>
					<div class="submitDiv">
						<input type="submit" value="Salvar" class="btn btn-default"/>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>