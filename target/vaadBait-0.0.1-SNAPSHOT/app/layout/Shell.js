/**
 * Created by gilzausmer on 03/10/2016.
 */

angular.module('myApp')
    .controller('ShellCtrl', ['$scope','$localStorage','ViewService','SharedData', function($scope,$localStorage, ViewService, SharedData, AuthenticationService){

        if(SharedData.alreadyWelcomed != 0) {
            $scope.alreadyWelcomed = SharedData.alreadyWelcomed;
        }
        $scope.fadeWelcome = false;
        $scope.usernameWelcome = $localStorage.firstName;

            $scope.isSelected = function(element){
                  
                            return ViewService.isElementSelected(element);
                    };

        $scope.isAdmin = true;
        SharedData.alreadyWelcomed = $localStorage.alreadyWelcomed;
        $scope.alreadyWelcomed = SharedData.alreadyWelcomed;
        console.log("sharedData"+SharedData.alreadyWelcomed)

    }]);




