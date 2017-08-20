angular.module('weddingApp')
.controller('cardController', CardController)
.directive('infoCard', CardDirective);

function CardDirective() {
	return {
		controller: 'cardController',
		scope: {
			item: '=',
		},
		templateUrl: 'scripts/infoCard/infoCard.html'
	};	
}

function CardController($scope) {
	this.$onInit = function() {
		var data = $scope.item;

		$scope.dataLastUpdated = new Date(data.created);
		$scope.templateName = data.templateName;
		$scope.iconClass = data.iconCode;

		$scope.description = data.description;
		$scope.info = data.info;
		$scope.buttonText = data.buttonText;
		$scope.buttonLink = data.buttonLink;
		$scope.buttonHoverText = data.buttonHover;
	}
	
	$scope.openLink = function () {
		var url = $scope.cardButtonLink;
		//window.location(url);
	}
}