var myapp = angular.module('application',[]);


myapp.service('dataService',function(restAPICallService,$rootScope){
	var movies =['frozen','transformers','age of ultron','batman'];
	var movieInfo = {};
	
	getMovies = function(){
		return movies;
	};
	
	this.getMovieInfo= function(url){
		 restAPICallService.callRestService(url).then(function(data){
		 movieInfo =data;
		 $rootScope.$apply();
		});
	};
	
	this.getFetchedMovieInfo = function(){
		return movieInfo;
	};
	
	this.getMoviePoster = function(){
		return movieInfo.Poster;
	};
	
	
	this.getSelectedMovieName = function(){
		return movieInfo.Title;
	}
	
	
	
	
	
	
});


myapp.service('restAPICallService',function($http,$q){
	this.callRestService = function(url){
		var deferred = $q.defer();
		$http.get(url).success(function(data){
			deferred.resolve(data);
		});
		return deferred.promise;;
	};
});



myapp.controller('firstController',function($scope,dataService){
	$scope.movies = dataService.getMovies();
	$scope.getMovie = function(movie){
		var url = "http://www.omdbapi.com/?t="+movie+"&y=&plot=short&r=json";
		dataService.getMovieInfo(url);
	};
});

myapp.controller('secondController',function($scope,dataService){
        $scope.poster ="";
        $scope.service = dataService;
        $scope.$watch('service.getMoviePoster()', function(poster) {
            $scope.poster = poster;
          });

});

myapp.controller('thirdController',function($scope,dataService){
	$scope.movieName = "";
	$scope.service = dataService;
    $scope.$watch('service.getFetchedMovieInfo()', function(selectedMovie) {
        $scope.movieName = selectedMovie.Title;
      });
	
});

myapp.controller('fourthController',function($scope,dataService){
	$scope.plot = "";
	$scope.service = dataService;
    $scope.$watch('service.getFetchedMovieInfo()', function(selectedMovie) {
        $scope.plot = selectedMovie.Plot;
      });
});