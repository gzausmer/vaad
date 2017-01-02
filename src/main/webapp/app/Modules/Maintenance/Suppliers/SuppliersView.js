/**
 * Created by gilzausmer on 24/11/2016.
 */

angular.module('myApp')
    .controller('SuppliersCtrl',['$scope', '$http', function($scope, $http) {
        var vm = this;

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
