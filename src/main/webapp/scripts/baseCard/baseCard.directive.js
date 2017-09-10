angular.module('weddingApp')
.controller('baseController', BaseController)
.directive('baseCard', BaseDirective);

function BaseDirective() {
	return {
		controller: 'baseController',
		scope: {
			item: '=',
		},
		templateUrl: 'scripts/baseCard/baseCard.html'
	};
}

function BaseController($scope, $http) {
	$scope.getPage = function () {
        if(window.location.hash.substring(2) == 'faq'){
            $scope.title = 'FAQ';
            return $scope.getFAQ('faq');
        }
        else if(window.location.hash.substring(2) == 'aboutUs'){
            $scope.title = 'About Us';
            return $scope.getFAQ('aboutUs');
        }
        else{
            $scope.title = 'Program for the day of';
            return $scope.getProgram();
        }
	}

    $scope.getFAQ = function (value) {
		$http({
			method: 'GET',
			url: '/getPage/',
			params: {
				path: value
			}
		}).then(function (success) {
			//fetch from server and display results
			$scope.pageItems = success.data;
			$scope.weather = false;
		}, function (error) {
			$location.path("/")
		});
	}


	$scope.getProgram = function () {
    		$http({
    			method: 'GET',
    			url: '/weddingProgram/',
    		}).then(function (success) {
    			//fetch from server and display results
    			$scope.pageItems = success.data;
    			$scope.weather = true;
    		}, function (error) {
    			$location.path("/")
    		});
    	}
}