/**
 * Created by gilzausmer on 30/11/2016.
 */
/**
 * Created by gilzausmer on 24/11/2016.
 */

angular.module('myApp')
    .controller('MaintenanceJobsCtrl',['$state','$scope','$filter','$uibModal', '$http','SharedData',
        function($state, $scope,$filter,$uibModal, $http,SharedData) {
        console.log("****************************"+SharedData.selectedCheckBox);
        var vm = this;

        $scope.statusTypes = ['unread','open','pending','closed'];
            $scope.selected = SharedData.selectedCheckBox;



$scope.toggle = function(item, list){

   var i = list.indexOf(item);
    if (i > -1){
        list.splice(i,1);
    }
    else{
        list.push(item);
    }
};

$scope.exists = function(item, list){
    return list.indexOf(item) > -1;
}


        $scope.editStatus  = function (id) {

            SharedData.currentMaintenanceStatusId = id;

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

                SharedData.unreadEventsAmount = 0;
                vm.eventMaintenance = [];
                vm.eventMaintenance = data;
                for(var index=0;index<vm.eventMaintenance.length;index++){

                    if (vm.eventMaintenance[index].status == 'unread'){
                        SharedData.notificationExist = true;
                        SharedData.unreadEventsAmount++;
                    }
                }
                if(SharedData.unreadEventsAmount == 0){
                    SharedData.notificationExist = false;
                }
            })

            .error(function(data, status, headers, config) {

                $scope.searchError = data.message;
            });

    }]).filter('checkBoxFilter', function() {
    return function (eventData, selectedBoxes) {
       var beforeFiltered = [];
        beforeFiltered.push(eventData);
        var filtered = [];

        if (beforeFiltered[0] != undefined){

            for (var i = 0; i < selectedBoxes.length; i++) {

                    for (var j = 0; j < beforeFiltered[0].length; j++) {
                       // console.log("beforeFiltered[0][j].status = " + beforeFiltered[0][j].status + "selectedBoxes[i] = " + selectedBoxes[i]);
                        if (beforeFiltered[0][j].status == selectedBoxes[i]) {
                            filtered.push(beforeFiltered[0][j])
                        }
                    }
                }
            //   console.log(filtered);
            return filtered;
            }
     }
}
);


