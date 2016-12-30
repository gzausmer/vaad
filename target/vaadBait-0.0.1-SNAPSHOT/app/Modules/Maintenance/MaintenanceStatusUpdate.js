/**
 * Created by gilzausmer on 01/12/2016.
 */
angular.module('myApp')
    .controller('ModalInstanceCtrl',['$scope', '$uibModalInstance', '$http', 'SharedData',
            function ($scope, $uibModalInstance, $http, SharedData) {
        var mi = this;
                $scope.statuses = [
                    {'status': 'open'},
                    {'status': 'pending'},
                    {'status': 'closed'}
                ];
        var data = {};


            $scope.shouldNotify = false;
            $scope.ok = function() {
                data.id = SharedData.currentMaintenanceStatusId;
                data.status = $scope.selectedStatus.status;
                console.log(data.status);
                data.notificationSent = $scope.shouldNotify;
                $http({method: 'PUT', url: './rest/scheduledMaintenance', data: data}).

                //success:
                then(function(response) {
                    $scope.status = response.status;
                    $scope.data = response.data;

                    //error:
                }, function(response) {
                    $scope.data = response.data || 'Request failed';
                    $scope.status = response.status;
                });

                $uibModalInstance.close(1);
            };

        }]
        );