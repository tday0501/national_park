<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="body-container">
	<c:forEach items="${formResults}" var="result">
		<div class="container-fluid">
			<div class="card mb-3">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img  src= "<c:url value="/img/parks/${result.parkCode}.jpg"/>" class="card-img"/>
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">${result.parkName} - ${result.surveyCount}</h5>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	</c:forEach>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />