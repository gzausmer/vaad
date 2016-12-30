/**
 * Created by gilzausmer on 12/10/2016.
 */
angular.module('myApp')
    .controller('ExpensesCtrl',['$scope','ViewService', function($scope, ViewService) {


        $scope.isSelected = function(element){

            return ViewService.isElementSelected(element);

        };

        $scope.selectView = function(element){

            ViewService.selectElement(element);

        };

        $scope.budgetExpencesEdited = [];

        $scope.budgetExpences = [

            // 'id' is for boolean editable or not:

            {'key': 'Payent to vaad', 'value':100, 'id':false},
            {'key': 'Electricity', 'value':110, 'id':false},
            {'key': 'Lifts (servicing)', 'value':120, 'id':false},
            {'key': 'Generator (servicing)', 'value':140, 'id':false},
            {'key': 'Cleaning', 'value':130, 'id':false},
            {'key': 'Solar heating', 'value':115, 'id':false},
            {'key': 'Garbage disposal', 'value':112, 'id':false},
            {'key': 'Public services', 'value':120, 'id':false},
            {'key': 'Lifts (servicing)', 'value':160, 'id':false}
        ]
        $scope.budgetExpencesReset = $scope.budgetExpences;

        $scope.totalExpences = function(){
            var sum = 0;
            for (var i = 0;i<  $scope.budgetExpences.length; i++){
                sum = sum + $scope.budgetExpences[i].value;
            }
            return sum;
        }

        $scope.removeExpenceRow = function(key){

            $scope.budgetExpencesEdited = [];
            for (var i = 0;i<  $scope.budgetExpences.length; i++) {

                if ($scope.budgetExpences[i].key != key) {
                    $scope.budgetExpencesEdited.push($scope.budgetExpences[i]);

                }
            }
            $scope.budgetExpences = $scope.budgetExpencesEdited;

        }


        $scope.resetExpenceRows = function(){
            $scope.budgetExpences  =  $scope.budgetExpencesReset;
        } ;


        $scope.editExpenceRow = function(expence){

            expence.id = true;

            console.log( expence.id);

        }

        $scope.saveExpenceRow = function(expence, key, value){


            expence.id = false;

        }


        $scope.addExpense = function(){
            $scope.AddExpensePressed = true;

        }



        $scope.saveExpense = function(key, value){
            var newExpense = {'key': key, 'value':value, 'id':false};
            console.log(newExpense);
            $scope.budgetExpences.push(newExpense);
            $scope.AddExpensePressed = false;
        }



        $scope.cancelAddExpense = function(){
            $scope.AddExpensePressed = false;
        }



    }]);