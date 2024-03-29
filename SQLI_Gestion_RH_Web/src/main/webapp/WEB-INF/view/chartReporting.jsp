<%@include file="taglib_includes.jsp"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Tabs - Vertical Tabs functionality</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	$(function() {
		$("#tabs").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#tabs li").removeClass("ui-corner-top").addClass("ui-corner-left");
	});
</script>
<style>
.ui-tabs-vertical {
	padding: 0;
	width: 42em;
}

.ui-tabs-vertical .ui-tabs-nav {
	padding: .2em .1em .2em .2em;
	float: left;
	width: 19em;
	background: #0e69be;
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
	text-decoration: none;
	font-weight: normal;
}

.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active {
	padding-bottom: 0;
	padding-right: .1em;
	border-right-width: 15px;
}

.ui-tabs-vertical .ui-tabs-panel {
	padding: 1em;
	float: right;
	width: 40em;
}
</style>
</head>
<body>

	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">Ratio F/M</a></li>
			<li><a href="#tabs-2">Ratio nouveaux recrus par ann�e</a></li>
			<li><a href="#tabs-3">Pourcentage de chaque technologie</a></li>
		</ul>
		<div id="tabs-1">
			<img alt="Ration F/M" src=${chartRatioUrl } align="right" />
		</div>
		<div id="tabs-2">
			<img alt="Ratio recrus par ann�e" src=${chartRatioRecrusUrl } align="right" />
				<br/><br/> <br/>
			<table border="1" style="border-collapse: collapse;" align="center">
				<tr>
					<td style="color: grey">Ann�e</td>
					<td style="color: grey">Nb. recrus</td>
				</tr>
				<c:forEach var="entry" items="${mapRec}">
					<tr>
						<td style="color: black"><c:out value="${entry.key}" />
						<td style="color: black"><c:out value="${entry.value}" />
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="tabs-3">
			<img alt="Ration Technologie" src=${chartRatioTechUrl } align="right" />
		</div>

	</div>


</body>
</html>