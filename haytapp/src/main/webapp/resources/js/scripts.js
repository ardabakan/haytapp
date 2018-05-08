	var haytapApp = angular.module('haytapApp', ['ngRoute']);

	haytapApp.config(function($routeProvider) {
		$routeProvider

			.when('/', {
				templateUrl : '/pages/home.jsp',
				controller  : 'mainController'
			})

			.when('/addfood', {
				templateUrl : '/pages/addfood.jsp',
				controller  : 'addfoodController'
			})

			.when('/viewfood', {
				templateUrl : '/pages/viewfood.jsp',
				controller  : 'viewfoodController'
			})
		
		.when('/listfoods', {
			templateUrl : '/pages/listfoods.jsp',
			controller  : 'listfoodsController'
		});
	});

	haytapApp.controller('mainController', function($scope) {
		$scope.message = 'Welcome to food sharing for pets';
	});

	haytapApp.controller('addfoodController', function($scope) {
		$scope.message = 'Add your food using this form';
	});

	haytapApp.controller('viewfoodController', function($scope) {
		$scope.message = 'Here you can see available food for your pet';
	});
	
	haytapApp.controller('listfoodsController', function($scope) {
		$scope.message = 'Here you can see the detail of the food';
	});	
	
	
	haytapApp.controller("mainController", ['$scope', '$http', function($scope, $http) {
		
/*
	
		$scope.foods = [
		                    { 'label':'Whiskas',
		                    	'weight': 3,
		                    	'description': 'So fresh'},
		                    	{ 'label':'ND',
			                    	'weight': 2,
			                    	'description': 'Left food from my cat'},
			                    	{ 'label':'Best Cat Food',
				                    	'weight': 5,
				                    	'description': 'Not opened'},
				                    	{ 'label':'Gravy Chicken',
					                    	'weight': 1,
					                    	'description': 'Fresh food left'},				                    	
		                    ];
*/		  
		
		
		 $http.get('/rest/foods/list').success(function (data, status, headers, config) {
	            var foods = data;
	            for (var i = 0; i < foods.length; i++) {
	                var food = foods[i];
	                food.detailLink = "/view/" + food.id;
	            }
	            $scope.foods = foods;
	        }).error(function (data, status, headers, config) {
	            if (data.message == 'Time is out') {
	                $scope.finishByTimeout();
	            }
	        });
		               
	
	}]);
	
	
	haytapApp.controller('viewfoodController', ['$scope', '$routeParams','$http',function($scope,$routeParams,$http){
	    $http({
	              method: 'GET',
	              url: '/rest/foods/view/',
	            params:{"id":"$routeParams.id"}
	    }).success(function(data){
	        $scope.food = data;
	    });

	}]);
	
	haytapApp.controller("listfoodsController", ['$scope', '$http', function($scope, $http) {
		
		 $http.get('/rest/foods/list').success(function (data, status, headers, config) {
	            var foods = data;
	            for (var i = 0; i < foods.length; i++) {
	                var food = foods[i];
	                food.detailLink = "/view/" + food.id;
	            }
	            $scope.foods = foods;
	        }).error(function (data, status, headers, config) {
	            if (data.message == 'Time is out') {
	                $scope.finishByTimeout();
	            }
	        });
	
	}]);
	
	haytapApp.controller("addfoodController", ['$scope', '$http', function($scope, $http) {
		
		$scope.addRowAsyncAsJSON = function(){
			
			//$scope.foods.push({ 'label':$scope.label, 'weight': $scope.weight, 'description':$scope.description });
			// Writing it to the server
			//		
			var dataObj = {
					label : $scope.label,
					weight : $scope.weight,
					description : $scope.description
			};	
			
			var res = $http.post('/addfood', dataObj);
			res.success(function(data, status, headers, config) {
				$scope.message = data;
			});
			
			
			res.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data: data}));
			});		
			
			$scope.label='';
			$scope.weight='';
			$scope.description='';
			
			$http.get('/rest/foods/list').success(function (data, status, headers, config) {
	            var foods = data;
	            for (var i = 0; i < foods.length; i++) {
	                var food = foods[i];
	                food.detailLink = "/view/" + food.id;
	            }
	            $scope.foods = foods;
	        }).error(function (data, status, headers, config) {
	            if (data.message == 'Time is out') {
	                $scope.finishByTimeout();
	            }
	        });
		};
	
	}]);