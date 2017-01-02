/**
 * Created by gilzausmer on 03/10/2016.
 */
var app = angular.module('myApp');
app.controller('SideBarCtrl',['$scope', function($scope){
     $scope.show = true;
     $scope.isExpandedMaintenance = false;

    }]);