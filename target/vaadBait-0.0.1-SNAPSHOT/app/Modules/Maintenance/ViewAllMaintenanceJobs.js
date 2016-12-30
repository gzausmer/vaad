/**
 * Created by gilzausmer on 30/11/2016.
 */
/**
 * Created by gilzausmer on 24/11/2016.
 */

angular.module('myApp')
    .controller('MaintenanceJobsCtrl',['$state','$scope','$uibModal','ViewService', '$http','SharedData',
        function($state, $scope,$uibModal, ViewService, $http,SharedData ) {
        var vm = this;
        vm.isSelected = function(){
            return ViewService.isElementSelected('MaintenanceJobsView');
        };
        $scope.editStatus  = function (id) {
            SharedData.currentMaintenanceStatusId = id;
            console.log("scheduledMaintenance.id" + id);
            var modalInstance = $uibModal.open({
                templateUrl: 'editStatusModal.html',
                controller: 'ModalInstanceCtrl',
                size: 'lg'
            });
            modalInstance.result.then(function (trigger) {
                if (trigger == 1){
                    $state.reload();
                }
                });
        }

        $http({
            method  : 'GET',
            url     : './rest/getAllScheduledMaintenanceJobs',
            headers : {'Content-Type': 'application/json'}
        })

            .success(function(data, status, headers, config) {

                vm.scheduledMaintenance = data;
            })

            .error(function(data, status, headers, config) {

                $scope.searchError = data.message;
            });

        $http({
            method  : 'GET',
            url     : './rest/getAllEventMaintenanceJobs',
            headers : {'Content-Type': 'application/json'}
        })

            .success(function(data, status, headers, config) {

                vm.eventMaintenance = data;
            })

            .error(function(data, status, headers, config) {

                $scope.searchError = data.message;
            });

    }]);
