<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div style="padding-bottom:50px">
			<table style="width:100%">
				<tr>
					<td colspan="2" style="width:100%;padding:10px;">					
					<div class="alert alert-info" role="alert">{{message}} - Enter food details to add</div>
					</td>
				</tr>
				<tr>					
					<td scolspan="2" tyle="width:45%;padding-left:40px;vertical-align: top">
						<div style="padding-bottom:20px">
							<h3>Add food to share</h3>
						</div>
						<form class="form-horizontal" role="form" ng-submit="addRowAsyncAsJSON()">
						
						<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}"/>
						
							<div class="form-group">
								<label class="col-md-2 control-label">Label</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="label"
										ng-model="label" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">Weight</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="weight"
										ng-model="weight" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">Description</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="description"
										ng-model="description" />
								</div>
							</div>
							<div class="form-group">								
								<div style="padding-left:110px">
									<input type="submit" value="Submit" class="btn btn-primary"/>
								</div>
							</div>
						</form>
					</td>
					
				</tr>
			</table>
		</div>