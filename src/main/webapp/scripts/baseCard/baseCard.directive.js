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
		$http({
			method: 'GET',
			url: '/weddingApp/getPage/',
			params: {
				path: window.location.hash.substring(2)
			}
		}).then(function (success) {
			//fetch from server and display results
			$scope.pageItems = success.data;

			if(window.location.hash.substring(2) == 'faq'){
				$scope.title = 'FAQ';
			}
			else if(window.location.hash.substring(2) == 'aboutUs'){
				$scope.title = 'About Us';
			}
		}, function (error) {
			$location.path("/")
		});
	}
}