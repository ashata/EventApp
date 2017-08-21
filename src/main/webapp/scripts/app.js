(function () {
	'use strict';

	var app = {
		isLoading: true,
	};

	/*****************************************************************************
	 *
	 * Event listeners for UI elements
	 *
	 ****************************************************************************/

	/*****************************************************************************
	 *
	 * Methods to update/refresh the UI
	 *
	 ****************************************************************************/
	//type, name, templateKey, created, title, iconCode, intro, xplnText
	// Updates a block card with the latest information. If the card
	// doesn't already exist, it's cloned from the template.
	app.hideLoading = function () {
		if (app.isLoading) {
			//app.spinner.setAttribute('hidden', true);
			//app.container.removeAttribute('hidden');
			app.isLoading = false;
		}
	};

	/*****************************************************************************
	 *
	 * Methods for dealing with the model
	 *
	 ****************************************************************************/
	var appModule = angular.module('weddingApp', ['ngRoute', 'schemaForm', 'angular-carousel', 'ngTouch']);

	appModule.config(['$locationProvider', function ($locationProvider) {
				$locationProvider.hashPrefix('');
			}
	]);

	appModule.config(function ($routeProvider) {
		$routeProvider
		.when('/', {
			controller: 'mainCtrl',
			templateUrl: 'scripts/app.html'
		})
		.when('/rsvp', {
			controller: 'rsvpController',
			templateUrl: 'scripts/rsvp/rsvp.html'
		})
		.when('/giftRegistry', {
			controller: 'giftRegistryController',
			templateUrl: 'scripts/giftRegistry/giftRegistry.html'
		})
		.when('/directions', {
			controller: 'directionsController',
			templateUrl: 'scripts/directions/directions.html'
		})
		.when('/aboutUs', {
			controller: 'baseController',
			templateUrl: 'scripts/baseCard/baseCard.html'
		})
		.when('/faq', {
			controller: 'baseController',
			templateUrl: 'scripts/baseCard/baseCard.html'
		})
		.otherwise({
			controller: 'mainCtrl',
			templateUrl: 'scripts/app.html'
		});
	});

	appModule.controller('mainCtrl', function ($scope, $http) {
		app.spinner = document.querySelector('.loader');
		//app.photoBanner = document.querySelector('.photoBanner');
		//app.infoCard = document.querySelector('.infoCard');
		app.container = document.querySelector('.main');
		app.getCardData($scope, $http);

		document.getElementById('homeBtn').addEventListener('click', function () {
			app.home($scope);
		});
	});

	/*
	 * Gets user data and updates the cards with the data.
	 * goes to the network for fresh data. If the network
	 * request goes through, then the card gets updated a second time with the
	 * freshest data.*/
	app.getCardData = function ($scope, $http) {
		// Fetch the latest data.
		$http({
			method: 'GET',
			url: '/home'
		}).then(function (success) {
			$scope.cards = success.data.cardList;
			app.hideLoading();
		}, function (error) {
			alert("Server is down or facing an issue, please try again later");
			app.hideLoading();
		});
	};

	//back to main page
	app.home = function ($scope) {
		window.location = '/';
	};
})();