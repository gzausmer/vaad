/**
 * Created by gilzausmer on 24/11/2016.
 */

/**
 * Created by gilzausmer on 19/11/2016.
 */
// ScheduledMaintenanceController

angular.module('myApp')
    .controller('EventMaintenanceController',['uuid','$state','$scope','SharedData','ViewService', 'HttpService',
        function(uuid,$state, $scope, SharedData, ViewService, HttpService) {
            var vm = this;
            vm.isSelected = function(){
                return ViewService.isElementSelected('EventMaintenanceForm');
            };
console.log(SharedData.email);

            vm.MaintanenceBuilding = [
                {"building":"Amishav"},
                {"building":"Hilton"},
                {"building":"Leonardo"}
            ];

            vm.MaintanenceLocation = [
                {"location":"Building Space"},
                {"location":"Garden Space"},
                {"location":"Floor"}
            ];

            vm.MaintanenceNatureOfProblem = [
                {"natureOfProblem":"Electrical"},
                {"natureOfProblem":"Water"},
                {"natureOfProblem":"Cleanliness"}
            ];

            $scope.sendEventMaintenanceDetails = function(){
                var hash = uuid.v4();
                console.log(hash);
                $scope.eventMaintenanceForm.photo = hash;
                $scope.eventMaintenanceForm.sender = SharedData.email;

                HttpService.processForm('POST',$scope.eventMaintenanceForm, './rest/addEventMaintenance');
                HttpService.processMultiPartForm('POST',$scope.photo, hash, './rest/addEventMaintenancePhoto');
                $state.reload();
            };

        }]);
