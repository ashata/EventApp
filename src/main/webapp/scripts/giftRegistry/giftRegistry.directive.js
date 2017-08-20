angular.module('weddingApp')
.controller('giftRegistryController', GiftRegistryController)
.directive('giftRegistry', GiftRegistryDirective);

function GiftRegistryDirective() {
	return {
		controller: 'giftRegistryController',
		scope: {
			store: '=',
		},
		templateUrl: 'scripts/giftRegistry/giftRegistry.html'
	};
}

function GiftRegistryController($scope, $http) {
	$scope.openLink = function () {
		var url = $scope.cardButtonLink;
		//window.location(url);
	}

	$scope.showRegistry = function () {
		$http({
			method: 'GET',
			url: '/weddingApp/fetchRegistry',
		}).then(function (success) {
			//fetch from server and display results
			$scope.registryList = success.data;
		}, function (error) {
			//show mock data
			//alert("oops");
		});
	}
}