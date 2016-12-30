/**
 * Created by gilzausmer on 03/10/2016.
 */
var app = angular.module('myApp');
app.controller('SideBarCtrl',['$scope','ViewService', function($scope, ViewService){
     $scope.show = true;
     $scope.isExpandedMaintenance = false;
        $scope.selectView = function(element){
          
            ViewService.selectElement(element);

        };
    }]);