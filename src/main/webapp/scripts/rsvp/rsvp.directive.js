angular.module('weddingApp')
.controller('rsvpController', RSVPController);

function RSVPController($scope, $http) {
	this.$onInit = function () {
		console.log($scope);
		var data = $scope.item;
        $scope.rsvpDTO = {};
        $scope.emailReqd = false;
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
				        1: "We love you but that's a bit much, eh?"
				    },
					"title": "Total no. of guests including you"
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
						/*"I'd love to be a part of wedding dance party": {
							"type": "boolean" 
						},*/
						"I(We) will need hotel block reservation": {
							"type": "boolean",
						}
					}
				},
				"email": {
					"title": "email",
					"type": "string",
					"format": "email"
				},
				 "required": ["firstName, lastName", "rsvpText", "email"]
			}
		};

		$scope.form = [{
				"key": "firstName",
				"required": true
			}, {
				"key": "lastName",
				"required": true
			}, {
				"key": "rsvpText",
				"required": true
			}, {
				"key": "guests",
			}, {
				"key": "activCodeMap",
			}, {
				"key": "email",
			}
		];
	}

	$scope.rsvp = function (form) {
        $scope.$broadcast('schemaFormValidate');
        //rsvp save/update.
        if (form.$valid) {
            $http({
                method: 'POST',
                url: '/rsvp',
                data: $scope.rsvpDTO
            }).then(function (success) {
                //TODO: update this to fetch from server and display results
                alert("Thanks for your RSVP.")
            }, function (error) {
                alert("Error saving, please try again later or contact us at email");
            });
        }
	}
}
