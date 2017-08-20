angular.module('weddingApp')
.controller('rsvpController', RSVPController);
// .directive('rsvp', RSVPDirective);

// function RSVPDirective() {
	// return {
		// controller: 'rsvpController',
		// scope: {
			// item: '=',
		// },
		// templateUrl: 'scripts/rsvp/rsvp.html'
	// };
// }

function RSVPController($scope, $http) {
	this.$onInit = function () {
		console.log($scope);
		var data = $scope.item;

		$scope.schema = {
			"type": "object",
			"properties": {
				"firstName": {
					"title": "First Name",
					"type": "string"
				},
				"lastName": {
					"title": "Last Name",
					"type": "string"
				},
				"rsvpText": {
				"type": "string",
				"title": "Will you attend",
				enum: ["I(We) would love to", "I need more time to think", "I'll just watch it online", "Congrats!! but I have other plans"],	
				},
				"guests": {
					"type": "number",
					enum: [0, 1, 2, 3, 4, 5],
				    default: 0,
				    validationMessage: {
				        302: "We love you but that's a bit much, eh?"
				    }
					"title": "Bringing guests"
				},
				"activCodeMap": {
					"title": "Activities",
					"description": "Interested in joining pre-wedding activities? or need hotel reservation(only)?",
					"type": "object",
					"properties": {
						/*"Bridal Shower TBD": {
							"type": "boolean"
						},*/
						"Henna Tattoo 2 days before the wedding": {
							"type": "boolean"
						},
						"I'd love to be a part of wedding dance party": {
							"type": "boolean" 
						},
						"I(We) will need hotel block reservation": {
							"type": "boolean",
						}
					}
				},
				"email": {
					"title": "email",
					"type": "string",
					"format": "email"
				}
			}
		};

		$scope.form = [{
				"key": "firstName",
				"notitle": false,
				"showAdvanced": false,
				"disableSuccessState": false,
				"disableErrorState": false,
				"readonly": false
			}, {
				"key": "lastName",
				"notitle": false,
				"showAdvanced": false,
				"disableSuccessState": false,
				"disableErrorState": false,
				"readonly": false
			}, {
				"key": "rsvpText",
				"notitle": false,
				"showAdvanced": true,
				"disableSuccessState": false,
				"disableErrorState": false,
				"readonly": false
			}, {
				"key": "guests",
				"notitle": false,
				"showAdvanced": false,
				"disableSuccessState": false,
				"disableErrorState": false,
				"readonly": false
			}, {
				"key": "activCodeMap",
				"notitle": false,
				"showAdvanced": false,
				"disableSuccessState": false,
				"disableErrorState": false,
				"readonly": false
			}, {
				"key": "email",
				"notitle": false,
				"showAdvanced": false,
				"disableSuccessState": false,
				"disableErrorState": false,
				"readonly": false
			}
		];

		$scope.rsvpDTO = {};
	}

	$scope.rsvp = function () {
			//rsvp save/update.
			$http({
				method: 'POST',
				url: '/weddingApp/rsvp',
				data: $scope.rsvpDTO
			}).then(function (success) {
				//TODO: update this to fetch from server and display results
				alert("Thanks for your RSVP.")
			}, function (error) {
				alert("Error saving, please try again later or contact us at email");
			});
	}
}
