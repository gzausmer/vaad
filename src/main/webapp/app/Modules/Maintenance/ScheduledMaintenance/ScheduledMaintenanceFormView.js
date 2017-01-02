/**
 * Created by gilzausmer on 19/11/2016.
 */
// ScheduledMaintenanceController

angular.module('myApp')
    .controller('ScheduledMaintenanceController',['uuid','$scope','SharedData','$http', 'HttpService',
        function (uuid, $scope, SharedData, $http, HttpService) {

            var vm = this;

            vm.showSystemInput = false;
            vm.submitNewSystem = function(){
                vm.MaintanenceSystem.push({"systemType":$scope.newSystem});

                console.log(vm.MaintanenceSystem);
            }

            $scope.sharedData = SharedData.scheduledMaintenance;
            $scope.saveSharedData = function(){
                SharedData.scheduledMaintenance = {"system":$scope.scheduledMaintenanceForm.system.systemType,
                                                     "priority":$scope.scheduledMaintenanceForm.priority,
                                                        "type":$scope.scheduledMaintenanceForm.type,
                                                            "lastCheck":$scope.scheduledMaintenanceForm.lastCheck,
                    "serviceFreqNumber":$scope.scheduledMaintenanceForm.serviceFreqNumber,
                    "serviceFreqEach":$scope.scheduledMaintenanceForm.serviceFreqEach,
                    "serviceFreqTime":$scope.scheduledMaintenanceForm.serviceFreqTime,
                    "supplier":$scope.scheduledMaintenanceForm.supplier
                                                        };
                                                        console.log($scope.scheduledMaintenanceForm.lastCheck);
            }
            // datepicker

            $scope.open1 = function() {
                $scope.popup1.opened = true;
            };
            $scope.open2 = function() {
                $scope.popup2.opened = true;
            };

            $scope.dateOptions = {

                formatYear: 'yy',
                maxDate: new Date(2020, 5, 22),
                minDate: new Date(1970, 5, 22)
            };

            $scope.popup1 = {
                opened: false
            };
            $scope.popup2 = {
                opened: false
            };

            $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
            $scope.format = $scope.formats[0];
            $scope.altInputFormats = ['M!/d!/yyyy'];


            //////////

            vm.MaintanenceSystem = [
                {"systemType":"Elevator"},
                {"systemType":"Solar Heating"},
                {"systemType":"Generator"},
                {"systemType":"Heating"},
                {"systemType":"Gas"}
            ];



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

            $scope.sendScheduledMaintenanceDetails = function(){
                var hash = uuid.v4();
                console.log(hash);

                if
                (
                $scope.scheduledMaintenanceForm.system != null
                ) $scope.scheduledMaintenanceForm.system = $scope.scheduledMaintenanceForm.system.systemType;

                if
                (
                $scope.scheduledMaintenanceForm.supplier != null
                )  $scope.scheduledMaintenanceForm.supplier = $scope.scheduledMaintenanceForm.supplier.id;

                $scope.scheduledMaintenanceForm.contract = hash;

                HttpService.processForm('POST',$scope.scheduledMaintenanceForm, './rest/addScheduledMaintenance');
                HttpService.processMultiPartForm('POST', $scope.contract, hash, './rest/addScheduledMaintenanceContract');
            };



        }]);
