var myapp = angular.module('mymovieapp',[]);

myapp.controller('abccontroller',function($scope,$http){
	$scope.moviename="";
	
	$scope.movies=[];
	$scope.addMovie=function(){
		
		var url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20location="+$scope.moviename+"&format=json&diagnostics=true&callback=";
		
		$http.get(url).success(function(data){
			
			$scope.movies.push(data);
			$scope.moviename="";
			
		});
	};
	
	
});
