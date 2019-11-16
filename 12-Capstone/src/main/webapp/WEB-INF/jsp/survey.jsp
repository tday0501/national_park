<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

		<c:url value="/submitSurvey" var="submitSurveyUrl" />
		<form:form method="POST" action="${submitSurveyUrl}" modelAttribute="formData">
		<div class="body-container">
	<div class="container-fluid">
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label" name="FavoriteParkCode">Favorite
					National Park</label>
				<div class="col-sm-10">
					<select id="FavoriteParkCode" class="form-control" name="FavoriteParkCode">
						<c:forEach items="${parks}" var="park">
							<option value="${park.code}">${park.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Your
					email</label>
				<div class="col-sm-10">
					<form:input type="email" class="form-control" id="email"
						placeholder="Please enter your email" required="required" name="email" path="email"/>
						<form:errors path="email"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="StateOfResidence" class="col-sm-2 col-form-label">State
					of residence</label>
				<div class="col-sm-10">
					<form:select id="StateOfResidence" class="form-control" name="StateOfResidence" required="required" path="stateOfResidence" >
						<c:forEach items="${states}" var="state">
							<option>${state}</option>
						</c:forEach>
					</form:select>
					<form:errors path=""/>
				</div>
			</div>
			<fieldset class="form-group" name="activity" >
				<div class="row">
					<legend class="col-form-label col-sm-2 pt-0">Activity</legend>
					<div class="col-sm-10">
						<c:forEach items="${options}" var="option">
							<div class="form-check">
							<input class="form-check-input" type="radio" name="activity"
								id="gridRadios1" value="${option}" required="required" path="activity"/> <label
								class="form-check-label" for="activity"> ${option} </label>
								<form:errors path=""/>
							</div>
						</c:forEach>
						
		
					</div>
				</div>
			</fieldset>
	</div>
</div>

						<div class="form-group row">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary submit">Submit</button>
							</div>
						</div>
</form:form>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />