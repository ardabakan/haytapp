<div style="padding-bottom:50px">
			<table style="width:100%">
				<tr>
					<td colspan="2" style="width:100%;padding:10px;">					
					<div class="alert alert-info" role="alert">List of foods</div>
					</td>
				</tr>
				<tr>
					<td style="vertical-align: top" colspan="2">
						<table class="table">
							<tr>
								<th>Label
								</th>
								<th>Weight (KG)
								</th>
								<th>Detail
								</th>
							</tr>
							<tr ng-repeat="food in foods">
								<td>{{food.label}}
								</td>
								<td>{{food.weight}}
								</td>
								<td>{{food.description}}
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>