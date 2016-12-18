<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>


<form:form method="POST" commandName="person" class="form-horizontal">
	<fieldset>
		<legend>Modification de vos informations</legend>
		<div class="form-group">
			<label for="idGroup" class="col-lg-2 control-label">Groupe</label>
			<div class="col-md-2">
				<select class="form-control" id="select" name="groups">
					<c:forEach items="${listGroup}" var="group">
						<option>${group.nameGroup}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="firstName" class="col-lg-2 control-label">Prénom</label>
			<div class="col-lg-2">
				<!-- 				<input type="text" class="form-control" id="firstName" placeholder="Prénom"> -->
				<form:input path="firstName" value="${personLogged.firstName}"
					class="form-control" />
				<small class="errors help-block"><form:errors
						path="firstName" cssClass="error" /></small>
			</div>
		</div>

		<div class="form-group">
			<label for="lastName" class="col-lg-2 control-label">Nom</label>
			<div class="col-lg-2">
				<!-- 				<input type="text" class="form-control" id="lastName" placeholder="Nom"> -->
				<form:input path="lastName" value="${personLogged.lastName}"
					class="form-control" />
				<small class="errors help-block"><form:errors
						path="lastName" cssClass="error" /></small>
			</div>
		</div>

		<div class="form-group">
			<label for="inputEmail" class="col-lg-2 control-label">Email</label>
			<div class="col-lg-2">
				<!-- 				<input type="text" class="form-control" id="inputEmail"	placeholder="Email"> -->
				<form:input path="mail" value="${personLogged.mail}"
					class="form-control" />
				<small class="errors help-block"><form:errors path="mail"
						cssClass="error" /></small>

			</div>
		</div>

		<div class="form-group">
			<label for="web" class="col-lg-2 control-label">Site web</label>
			<div class="col-lg-2">
				<!-- 				<input type="text" class="form-control" id="web" placeholder="Web"> -->
				<form:input path="web" value="${personLogged.web}"
					class="form-control" />
				<small class="errors help-block"><form:errors path="web"
						cssClass="error" /></small>
			</div>
		</div>

		<div class="form-group">
			<label for="naissance" class="col-lg-2 control-label">Date de
				naissance</label>
			<div class="col-lg-2">
				<!-- 				<input type="text" class="form-control" id="naissance" placeholder="Naissance"> -->
				<form:input path="naissance" value="${personLogged.naissance}"
					class="form-control" />
				<small class="errors help-block"><form:errors
						path="naissance" cssClass="error" /></small>
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="col-lg-2 control-label">Mot de passe</label>
			<div class="col-lg-2">
				<!-- 				<input type="password" class="form-control" id="inputPassword" placeholder="Password"> -->
				<form:input path="password" value="${personLogged.password}"
					class="form-control" />
				<small class="errors help-block"><form:errors
						path="password" cssClass="error" /></small>

			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-lg-2 control-label"></label>
			<div class="col-lg-2">
					<input type="submit" class="btn btn-warning"
			value="Enregistrer les modifications" />
			</div>
		</div>
	</fieldset>
</form:form>



</body>
</html>