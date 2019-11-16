<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="body-container">
	<div class="container-fluid">
		<div class="card mb-3">
			<img src="<c:url value="/img/parks/${item.lowerCaseCode}.jpg"/>"
				class="card-img-top park-img" alt="...">
			<div class="card-body">
				<h5 class="card-title">${item.name}-${item.state}</h5>
				<p class="card-text">"${item.inspirationalQuote}"</p>
				<p class="card-text">- ${item.quoteSource}</p>
				<p class="card-text">${item.description}</p>
				<h5>Total acreage: </h5>
				<p class="card-text">${item.acreage} acres.</p>
				<h5>Elevation in feet: </h5>
				<p class="card-text">${item.elevationInFeet} ft.</p>
				<h5>Total miles of trail: </h5>
				<p class="card-text">${item.milesOfTrail} miles</p>
				<h5>Total number of campsites: </h5>
				<p class="card-text">${item.numberOfCampsites} campsites.</p>
				<h5>Climate: </h5>
				<p class="card-text">${item.climate}</p>
				<h5>Founded in year: </h5>
				<p class="card-text">${item.yearFounded}</p>
				<h5>Annual visitor count: </h5>
				<p class="card-text">${item.annualVisitorCount} visitors.</p>
				<h5>Entry Fee: </h5>
				<p class="card-text">$${item.entryFee}</p>
				<h5>Total number of species: </h5>
				<p class="card-text">${item.numberOfSpecies} species.</p>
				<h1 class="card-text forecast">Forecast</h1>
					<form action="<c:url value = "/parkDetailsPage"/>" method="post" class="temperature" id="formTemp">
						<input type="hidden" id="${item.code}" name="id" value="${item.code }">
						<button type="submit" id="buttonTemp"
							name="temperature" value="Celsius">Celsius</button>
						<button type="submit" id="buttonTemp2"
							name="temperature" value="Fahrenheit"> Fahrenheit </button>
					</form>
				</div>
				<div class="card-group weather">
					<c:forEach items="${weathers}" var="weather">
						<div class="card" style="width: 18rem;">
						<c:if test="${weathers[0] == weather}">	
							<h3>Today</h3>				
						</c:if>
							<c:url value="/img/weather/${weather.imageExt}.png"
								var="weatherImage" />
							<img src="${weatherImage}" class="card-img-top" alt="...">
							<div class="card-body weather-card">
								<h5 class="card-title">${weather.forecast}</h5>
								<c:choose>
								<c:when test="${temperature == 'Celsius' }">
								<p class="card-text">${weather.getTempConvert(weather.high)}&#176 ${temperature} </p>
								<p class="card-text">${weather.getTempConvert(weather.low)}&#176  ${temperature}</p>
								</c:when>
								<c:otherwise>
								<p class="card-text">${weather.high}&#176 ${temperature}</p>
								<p class="card-text">${weather.low}&#176 ${temperature}</p>
								</c:otherwise>
								</c:choose>
							</div>
							<h5>${weather.recommendation}</h5>	
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />