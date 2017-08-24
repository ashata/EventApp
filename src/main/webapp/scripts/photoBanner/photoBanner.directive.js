angular.module('weddingApp')
.controller('photoBannerController', PhotoBannerController)
.directive('photoBanner', PhotoBannerDirective);

function PhotoBannerDirective() {
	return {
		controller: 'photoBannerController',
		scope: {
			photo: '='
		},
		templateUrl: 'scripts/photoBanner/photoBanner.html'
	};
}

function PhotoBannerController($scope, $sce, $http) {
    $scope.slides = [];

    $scope.trustSrc = function(src) {
        return $sce.trustAsResourceUrl(src);
    }

    $scope.getImages = function () {
        $http({
            method: 'GET',
            url: '/slideshow',
        }).then(function (success) {
            //fetch from server and display results
            _.each(success.data, function(imageObj) {
               $scope.slides.push({
                 image: $scope.trustSrc(imageObj.url)//,
                 /*text: imageObj.caption,
                 typeu: 'image'*/
               });
            });
        }, function (error) {

        });
    }
}


