<%@ include file="../header.jsp" %>
<body>
	<div class="principalDiv">
		<div class="panel panel-default panel-Ranking">
			<div class="panel-heading">Ranking Geral</div>
			<div class="panel-body">
				<table id="rankingGeral" class="table">
					<thead>
						<tr>
							<th>Restaurante</th>
							<th>Votos</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		<div class="panel panel-default panel-Ranking">
			<div class="panel-heading">Seu ranking</div>
			<div class="panel-body">
				<table id="rankingUsuario" class="table">
					<thead>
						<tr>
							<th>Restaurante</th>
							<th>Votos</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(function() {
			generateRanking();
		});

		function generateRanking() {
			var rankings = {};
			rankings.restaurante = [];
			rankings.votos = [];

			var rankingsUsuario = {};
			rankingsUsuario.restaurante = [];
			rankingsUsuario.votos = [];

			<c:forEach items = "${rankingList}" var ="item">
			var index = $.inArray("${item.restaurante.nome}",
					rankings.restaurante);

			var restaurante = "${item.restaurante.nome}";
			var votos = parseInt('${item.votos}');

			if (index == -1) {
				rankings.restaurante.push(restaurante);
				rankings.votos.push(votos);
			} else {
				rankings.votos[index] = rankings.votos[index] + votos;
			}

			if ("${usuarioId}" == "${item.usuario.id}") {
				var indexUsuario = $.inArray(restaurante,
						rankingsUsuario.restaurante);
				if (indexUsuario == -1) {
					rankingsUsuario.restaurante.push(restaurante);
					rankingsUsuario.votos.push(votos);
				} else {
					rankingsUsuario.votos[indexUsuario] = rankingsUsuario.votos[indexUsuario]
							+ votos;
				}

			}

			</c:forEach>
			rankingTable(rankings, "rankingGeral");
			rankingTable(rankingsUsuario, "rankingUsuario");
		}

		function rankingTable(rankings, idTable) {
			for (var i = 0; i < rankings.restaurante.length; i++) {
				var row = $("<tr/>");

				$("#" + idTable).append(row);

				row.append($("<td>" + rankings.restaurante[i] + "</td>"));
				row.append($("<td>" + rankings.votos[i] + "</td>"));
			}
		}
	</script>
</body>
</html>