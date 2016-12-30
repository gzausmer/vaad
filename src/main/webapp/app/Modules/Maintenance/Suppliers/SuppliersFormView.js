/**
 * Created by gilzausmer on 18/10/2016.
 */
angular.module('myApp')
    .controller('SuppliersFormCtrl',['$scope','ViewService','HttpService',function($scope, ViewService, HttpService) {

        $scope.isSelected = function(){

            return ViewService.isElementSelected('suppliersFormView');
        };
        $scope.submitSupplier = function(){
            console.log($scope.supplierDetails);
            HttpService.processForm('POST',angular.toJson($scope.supplierDetails), './rest/addSupplier');
            $scope.supplierDetails = {};
            $scope.supplierDetails.$setUntouched();
            $scope.supplierDetails.$setPristine();

        };
    }]);