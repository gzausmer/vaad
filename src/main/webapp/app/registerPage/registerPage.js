/**
 * Created by gilzausmer on 22/10/2016.
 */

    angular
        .module('myApp')
        .controller('RegisterCtrl',['$scope','UserService','$location','$rootScope','FlashService',
            function($scope,UserService, $location, $rootScope, FlashService) {
        var vm = this;

        vm.register = function() {
            vm.dataLoading = true;
            UserService.Create(vm.user)
                .then(function (response) {
                    if (response.success) {
                        FlashService.Success('Registration successful', true);
                        $location.path('/login');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                })};

    }]

);