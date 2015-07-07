var myapp = angular.module('mydirections',[]);

myapp.controller('abccontroller',function($scope,$http){
	$scope.origin="";
	$scope.destination="";
	
	$scope.movies=[];
	$scope.addMovie=function(){
		
		var url="https://maps.googleapis.com/maps/api/directions/json?origin="+$scope.origin+"&destination="+$scope.destination+"&avoid=highways&mode=bicycling&key=AIzaSyDnz7QJ-yHF28iFCMFJIyr0lm4cwvMaqrs";
		$http.get(url).success(function(data){
			
			$scope.movies.push(data);
			
			$scope.origin="";
			$scope.destination="";
		});
	};
	
	
});
