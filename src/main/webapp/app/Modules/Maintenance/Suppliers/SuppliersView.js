/**
 * Created by gilzausmer on 24/11/2016.
 */

angular.module('myApp')
    .controller('SuppliersCtrl',['$scope','ViewService', '$http', function($scope, ViewService, $http) {
        var vm = this;
        vm.isSelected = function(){
            return ViewService.isElementSelected('SuppliersView');
        };

        $http({
            method  : 'GET',
            url     : './rest/getSuppliers',
            headers : {'Content-Type': 'application/json'}
        })

            .success(function(data, status, headers, config) {

                vm.suppliers = data;
            })

            .error(function(data, status, headers, config) {

                $scope.searchError = data.message;
            });

    }]);
