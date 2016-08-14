<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Daily Exchange Rate</title>
<script src="resources/js/jquery.js"></script>
<link rel="stylesheet"
	href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/custom.js"></script>
<script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/custom.css">
</head>
<body>
	<div>
		<h2 align="center">
			Türkiye Cumhuriyet Merkez Bankası Kurları<br> <br>
		</h2>

		<div class="container">
			<table class="table table-striped " id="contactTable">
				<thead class="thead-inverse">
					<tr>
						<th>Birim<br>Unit
						</th>
						<th>Döviz Cinsi <br>Currency
						</th>
						<th>Döviz Alış <br>Forex Buying
						</th>
						<th>Döviz Satış <br>Forex Selling
						</th>
						<th>Efektif Alış<br>Banknote Buying
						</th>
						<th>Efektif Satış<br>Banknote Selling
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${currencyList}" var="currency">
						<tr>
							<td id="unit"><c:out value="${currency.unit}" /></td>
							<td id="isim"><c:out value="${currency.isim}" /></td>
							<td id="forexbuying"><c:out value="${currency.forexbuying}" /></td>
							<td id="forexselling"><c:out
									value="${currency.forexselling}" /></td>
							<td id="banknotebuying"><c:out
									value="${currency.banknotebuying}" /></td>
							<td id="banknoteselling"><c:out
									value="${currency.banknoteselling}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="container">
			<div class="well well-sm" align="left">Çapraz Kurlar / Cross
				Rates</div>
			<table class="table table-striped " id="contactTable2">
				<thead class="thead-inverse">
					<tr>
						<th>Birim<br>Unit
						</th>
						<th id="currency1">Döviz Cinsi<br>Currency
						</th>
						<th>Çapraz Kur<br>Cross Rate
						</th>
						<th>Döviz Cinsi<br>Currency
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${currencyList}" var="currency">
						<tr>
							<td><c:out value="${currency.unit}" /></td>
							<td><c:out value="ABD DOLARI" /></td>
							<td><c:out value="${currency.crossrateusd}" /></td>
							<td><c:if test="${not empty currency.crossrateusd}">
									<c:out value="${currency.isim}" />
								</c:if>
						</tr>
					</c:forEach>
					<c:forEach items="${currencyList}" var="currency">
						<tr>
							<td><c:out value="${currency.unit}" /></td>
							<td><c:if test="${not empty currency.crossrateother}">
									<c:out value="${currency.isim}" />
								</c:if></td>
							<td><c:out value="${currency.crossrateother}" /></td>
							<td><c:out value="ABD DOLARI" /></td>
						</tr>
					</c:forEach>
					<c:forEach items="${currencyList}" var="currency">
						<tr>
							<td><c:out value="${currency.unit}" /></td>
							<td><c:if
									test="${not empty currency.crossrateother && empty currency.forexselling }">
									<c:out value="${currency.isim}" />
								</c:if></td>
							<td><c:out value="${currency.forexbuying}" /></td>
							<td><c:out value="TÜRK LİRASI" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
