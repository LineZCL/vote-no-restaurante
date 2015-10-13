<%@ include file="../header.jsp" %>
<body>
	<table style="width: 100%; border: 1px solid #D8D8D8;"
		id="rankingGeral">
		<thead>
			<tr>
				<th>Restaurante</th>
				<th>Votos</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

	<table style="width: 100%; border: 1px solid #D8D8D8;"
		id="rankingUsuario">
		<thead>
			<tr>
				<th>Restaurante</th>
				<th>Votos</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>


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