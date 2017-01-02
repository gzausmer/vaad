/**
 * Created by gilzausmer on 19/10/2016.
 */
angular.module('myApp')
    .controller('AddUserCtrl',['$scope', function($scope, ViewService) {

        $scope.newUserDetails = {};

        $scope.submitNewUser = function(){

          
            $scope.usersList.push($scope.newUserDetails);

            $scope.newUserDetails = {};
            $scope.newUserDetails.$setUntouched();
            $scope.newUserDetails.$setPristine();
        };

        $scope.manageUsersEdited = [];

        $scope.usersList = [

            // 'id' is for boolean editable or not:

            {'name': 'gil', 'role':'rolesomething', 'email':'gil.zz', 'password':'1234', 'id':false},
            {'name': 'chen', 'role':'rolesomething2', 'email':'gil.er', 'password':'124334', 'id':false},
            {'name': 'tamir', 'role':'rew', 'email':'grr.zz', 'password':'12rr34', 'id':false},
            {'name': 'jonni', 'role':'tre', 'email':'gil.tre', 'password':'ter', 'id':false},
            {'name': 'janice', 'role':'wer', 'email':'gil.wer', 'password':'rew', 'id':false}
        ]
        $scope.userReset = $scope.usersList;

        $scope.removeUserRow = function(name){

            $scope.manageUsersEdited = [];
            for (var i = 0;i<  $scope.usersList.length; i++) {

                if ($scope.usersList[i].name != name) {
                    $scope.manageUsersEdited.push($scope.usersList[i]);
                }
            }
            $scope.usersList = $scope.manageUsersEdited;
        }

        $scope.resetUserRows = function(){
     
            $scope.usersList  =  $scope.userReset;
        } ;

        $scope.editUserRow = function(user){
            user.id = true;
    
        }

        $scope.saveUserRow = function(user){
            user.id = false;
        }

        $scope.addUser = function(){
            $scope.AddUserPressed = true;
        }

        $scope.saveUser = function(name, role, email, password){
            var newUser = {'name': name, 'role':role, 'email':email,'password':password,'id':false};
       
            $scope.usersList.push(newUser);
            $scope.AddUserPressed = false;
        }

        $scope.cancelAddUser = function(){
            $scope.AddUserPressed = false;
        }
    }]);