/**
 * Created by gilzausmer on 31/12/2016.
 */
angular.module('myApp')
.component('login', {

        scope:{},
        templateUrl:'app/loginPage/loginPage.html',
        controller: LoginPageCtrl,
        controllerAs: 'vm'

    });

function LoginPageCtrl($location, AuthenticationService, SharedData){
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

};
