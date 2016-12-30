/**
 * Created by gilzausmer on 20/10/2016.
 */

    angular.module('myApp')
        .controller('LoginPageCtrl', function ($scope, $location, AuthenticationService, SharedData) {

            var vm = this;

      initController = function() {
            // reset login status
            AuthenticationService.Logout();
        };

        initController();

        vm.login  = function() {
            vm.loading = true;
            AuthenticationService.Login(vm.email, vm.password, function (result) {
                if (result === true) {
                    $location.path('/');
                    SharedData.setEmail(vm.email);
                } else {
                    vm.error = 'email or password is incorrect';
                    vm.loading = false;
                }
            });
        };

            $scope.moveToRegsiterPage  = function(){
                console.log("go to register")
            }
    }

);