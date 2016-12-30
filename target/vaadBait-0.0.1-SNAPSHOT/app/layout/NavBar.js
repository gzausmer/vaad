/**
 * Created by gilzausmer on 10/10/2016.
 */
var app = angular.module('myApp');
app.controller('NavBarCtrl',['$scope','$http','ViewService','AuthenticationService', function($scope, $http, ViewService, AuthenticationService){

    var vm = this;
    $scope.notificationExist = false;

    $http({
        method  : 'GET',
        url     : './rest/getAllOpenEvents',
        headers : {'Content-Type': 'application/json'}
    })

        .success(function(data, status, headers, config) {

            if (data){
                $scope.notificationExist = true;
                $scope.EventNotifications = "some";
                $scope.EventNotifications = "some";
                console.log(data +" " + "7" + vm.notificationExist);
            };
            console.log($scope.notificationExist);
        })

        .error(function(data, status, headers, config) {

            console.log(data.message + "7" + vm.notificationExist);

        });

    $scope.show = true;

    $scope.selectView = function(element) {
        ViewService.selectElement(element);
    }

    $scope.logout = function(){
     
        AuthenticationService.Logout();
    }
}]);