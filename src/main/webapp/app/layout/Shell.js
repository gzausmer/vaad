/**
 * Created by gilzausmer on 03/10/2016.
 */

angular.module('myApp')
    .controller('ShellCtrl', ['$scope','$localStorage','SharedData', function($scope,$localStorage, SharedData, AuthenticationService){

        if(SharedData.alreadyWelcomed != 0) {
            $scope.alreadyWelcomed = SharedData.alreadyWelcomed;
        }
        $scope.fadeWelcome = false;
        $scope.usernameWelcome = $localStorage.firstName;

        $scope.isAdmin = true;
        SharedData.alreadyWelcomed = $localStorage.alreadyWelcomed;
        $scope.alreadyWelcomed = SharedData.alreadyWelcomed;
        console.log("sharedData"+SharedData.alreadyWelcomed)

    }]);




