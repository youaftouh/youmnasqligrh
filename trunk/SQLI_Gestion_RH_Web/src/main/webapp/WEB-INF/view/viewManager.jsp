<%@include file="taglib_includes.jsp"%>

<html>

<link
	href="${pageContext.request.contextPath}/resources/css/createUser_style.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	$(function() {
		$("#viewCollabTabs").tabs();
	});
</script>
<style>
.ui-tabs-vertical {
	width: 55em;
}

.ui-tabs-vertical .ui-tabs-nav {
	padding: .2em .1em .2em .2em;
	float: left;
	width: 12em;
}

.ui-tabs-vertical .ui-tabs-nav li {
	clear: center;
	width: 100%;
	border-bottom-width: 1px !important;
	border-right-width: 0 !important;
	margin: 0 -1px .2em 0;
}

.ui-tabs-vertical .ui-tabs-nav li a {
	display: block;
}

.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active {
	padding-bottom: 0;
	padding-right: .1em;
	border-right-width: 1px;
	border-right-width: 1px;
}

.ui-tabs-vertical .ui-tabs-panel {
	padding: 1em;
	float: right;
	width: 40em;
}
</style>
</head>
<body>
		<div id="viewCollabTabs">
			<ul>
				<li><a href="#tabs-1">Donn�es personelles</a></li>
				<li><a href="#tabs-2">Diplomes</a></li>
				<li><a href="#tabs-3">Technologies</a></li>
				<li><a href="#tabs-4">Reporting</a></li>
			</ul>
			<div id="tabs-1">
				<h2 style="color: maroon">Donn�es personelles:</h2>
				<table style="border-collapse: none;"
					 align="center" id="tabcol">
					<tr>
						<td><label>Matricule:</label></td>
						<td><c:out value="${viewCollab.matricule}"/></td>
						<td><label>Nom:</label></td>
						<td><c:out value="${viewCollab.nom}"/></td>
						<td><label>Prenom:</label></td>
						<td><c:out value="${viewCollab.prenom}"/></td>
					</tr>
					<tr>
						<td><label>Abreviation:</label></td>
						<td><c:out value="${viewCollab.abreviation}" /></td>
						<td><label>Sexe:</label></td>
						<td><c:out value="${viewCollab.sexe}"/></td>
						<td><label>Site:</label></td>
						<td><c:out value="${viewCollab.site}"/></td>
					</tr>
					<tr>

						<td><label>Bu:</label></td>
						<td><c:out value="${viewCollab.bu}" /></td>
						<td><label>Salaire actuel:</label></td>
						<td><c:out value="${viewCollab.salaireActuel}" /></td>
						<td><label>Date embauche:</label></td>
						<td><c:out value="${viewCollab.dateEmbauche}"/></td>
					</tr>
					<tr>

						<td><label>Mois bap:</label></td>
						<td><c:out value="${viewCollab.moisBap}" /></td>
						<td><label>Ancien Manager:</label></td>
						<td><c:out value="${viewCollab.ancienColl}"/></td>
						<td><label>Date de depart:</label></td>
						<td><c:out value="${viewCollab.dateDepart}" /></td>
					</tr>
					<tr>
						<td><label>Participe SI:</label></td>
						<td><c:out value="${viewCollab.participeSi}" /></td>
						<td><label>Date participation:</label></td>
						<td><c:out value="${viewCollab.dateSi}" /></td>
						<td><label>Poste actuel (3):</label></td>
						<td><c:out value="${viewCollab.posteActuel3}" /></td>
					</tr>
					<tr>

						<td><label>Poste actuel (4):</label></td>
						<td><c:out value="${viewCollab.posteActuel4}" /></td>
					</tr>
				</table>
			</div>
			<div id="tabs-2">
				<h2 style="color: maroon">Diplome:</h2>
				<c:if test="${diplomesSize!=0}">
					<c:forEach var="dipl" begin="0" end="${diplomesSize - 1}">

						<table 
							style="border-collapse: collapse;" align="center" id="tabcol">

							<tr>
								<td><label>Titre:</label></td>
								<td><c:out value="${DIPLOME[dipl].nom}" /></td>
								<td><label>Ecole:</label></td>
								<td><c:out value="${DIPLOME[dipl].ecole}" /></td>
								<td><label>Ecole type:</label></td>
								<td><c:out value="${DIPLOME[dipl].ecoleType}"/></td>
							</tr>
							<tr>
								<td><label>Diplome type:</label></td>
								<td><c:out value="${DIPLOME[dipl].diplomeType}" /></td>
								<td><label>Promotion:</label></td>
								<td><c:out value="${DIPLOME[dipl].promotion}"/></td>
								<td><label>Niveau:</label></td>
								<td><c:out value="${DIPLOME[dipl].niveau}" /></td>
							</tr>
						</table>
						<hr width="200" />
					</c:forEach>
				</c:if>
			</div>
			<div id="tabs-3">
				<h2 style="color: maroon">Technologie:</h2>
				<c:if test="${technologiesSize!=0}">
					<c:forEach var="tech" begin="0" end="${technologiesSize - 1}">
						<div id="itemTech">
							<table 
								style="border-collapse: none;" align="center" id="tabcol">
								<tr>
									<td ><label>Technologie:</label></td>
									<td><c:out value="${TECHNOLOGIE[tech].technologie}"/></td>

									<td><label>Competence #1:</label></td>
									<td><c:out value="${COMPETENCE[tech].competence}"/></td>

									<td><label>Niveau d'expertise:</label></td>
									<td><c:out value="${COMPETENCE[tech].niveauExpertise}"/></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td><label>Competence #2:</label></td>
									<td><c:out value="${COMPETENCE[tech +1].competence}" /></td>

									<td><label>Niveau d'expertise:</label></td>
									<td><c:out value="${COMPETENCE[tech +1].niveauExpertise}" /></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td><label>Competence #3:</label></td>
									<td><c:out value="${COMPETENCE[tech +2].competence}" /></td>

									<td><label>Niveau d'expertise:</label></td>
									<td><c:out value="${COMPETENCE[tech +2].niveauExpertise}" /></td>
								</tr>
								
							</table>
						</div>
						<hr width="200"/>
					</c:forEach>
				</c:if>
			</div>

			<div id="tabs-4">Reporting</div>

		</div>
	<input type="button" value="Back" onclick="go('adminManagers');">
</body>


</html>