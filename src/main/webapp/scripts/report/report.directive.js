angular.module('weddingApp')
.controller('reportController', ReportController)
.directive('reportDirective', ReportDirective);

function ReportDirective() {
	return {
		controller: 'reportController',
		scope: {
			item: '=',
		},
		templateUrl: 'scripts/report/rsvpReport.html'
	};
}

function ReportController($scope, $http, NgTableParams) {

	$scope.report = function (form) {
        $http({
            method: 'GET',
            url: '/admin/rsvpReport',
        }).then(function (success) {
            //TODO: update this to fetch from server and display results
            $scope.data =  success.data;
            $scope.ngTableData = new NgTableParams({}, { dataset: success.data.rsvpList});
        }, function (error) {
            console.log(error);
        });
    }
}
