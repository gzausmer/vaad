/**
 * Created by gilzausmer on 10/10/2016.
 */
var app = angular.module('myApp');
app.controller('NavBarCtrl',['$scope','$state','$http','AuthenticationService','SharedData', function($scope,$state, $http, AuthenticationService, SharedData){

    var vm = this;

    $http({

        method  : 'GET',
        url     : './rest/getAllEventMaintenanceJobs',
        headers : {'Content-Type': 'application/json'}
    })

        .success(function(data, status, headers, config) {
            SharedData.unreadEventsAmount = 0;
            var eventMaintenance = [];
            eventMaintenance = data;

            for(var index=0;index<eventMaintenance.length;index++){

                if (eventMaintenance[index].status == 'unread'){
                    SharedData.notificationExist = true;
                    SharedData.unreadEventsAmount++;
                }
            }
            if (SharedData.unreadEventsAmount == 0){
                SharedData.notificationExist = false;
            }
            $scope.notificationExist = SharedData.notificationExist;
            $scope.unreadEventsAmount = SharedData.unreadEventsAmount;

        })

        .error(function(data, status, headers, config) {
            console.log("three");
            $scope.searchError = data.message;
        });

    $scope.notificationExist = SharedData.notificationExist;
    $scope.unreadEventsAmount = SharedData.unreadEventsAmount;

    var source = new EventSource('./rest/newEventNotifications');
    source.addEventListener('error', function(e) {
        if (e.currentTarget.readyState == EventSource.CLOSED) {
            // Connection was closed.
        } else {
            // Close it yourself
            source.close();
        }
    });
    source.addEventListener('spring', function(e) {
        console.log(e.data);
        $state.reload();
    });

    $scope.show = true;

    $scope.logout = function(){
     
        AuthenticationService.Logout();
    }
}]);