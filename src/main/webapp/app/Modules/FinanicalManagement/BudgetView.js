/**
 * Created by gilzausmer on 12/10/2016.
 */
angular.module('myApp')
    .controller('BudgetViewController',['$scope','ViewService', function($scope, ViewService) {

        $scope.isSelected = function(){

            return ViewService.isElementSelected('budgetView');

        };

        $scope.selectView = function(element){
            ViewService.selectElement(element);
            


        };

        var resetBudget = [];
        $scope.editBtnPressed = false;
        $scope.Budget = 1000;
        resetBudget.push($scope.Budget);


        $scope.cancelBudget = function(){
            $scope.Budget = resetBudget[0];
            $scope.editBtnPressed = false;
        }

        $scope.saveBudget = function(){
            resetBudget[0] = $scope.Budget;
            $scope.editBtnPressed = false;
        }

        $scope.editBudget = function(){

            $scope.editBtnPressed = true;
        }




        $scope.budgetExpencesEdited = [];
        $scope.budgetIncomeEdited = [];


        $scope.budgetExpences = [
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

        $scope.budgetIncome = [
            {'key': 'vaad fees', 'value':7000},
            {'key': 'parking', 'value':3000}
        ]
        $scope.budgetIncomeReset = $scope.budgetIncome;

        $scope.totalExpences = function(){
            var sum = 0;
            for (var i = 0;i<  $scope.budgetExpences.length; i++){
                sum = sum + $scope.budgetExpences[i].value;
            }
            return sum;
                }

        $scope.totalIncome = function(){
            var sum = 0;
            for (var i = 0;i<  $scope.budgetIncome.length; i++){
                sum = sum + $scope.budgetIncome[i].value;
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

        $scope.removeIncomeRow = function(key){

            $scope.budgetIncomeEdited = [];
            for (var i = 0;i<  $scope.budgetIncome.length; i++) {
             
                if ($scope.budgetIncome[i].key != key) {
                
                    $scope.budgetIncomeEdited.push($scope.budgetIncome[i]);

                }
            }
            $scope.budgetIncome = $scope.budgetIncomeEdited;

        }

        $scope.resetExpenceRows = function(){
            $scope.budgetExpences  =  $scope.budgetExpencesReset;
        } ;

        $scope.resetIncomeRows = function(){
            $scope.budgetIncome  =  $scope.budgetIncomeReset;
        } ;




        $scope.editExpenceRow = function(expence){

            expence.id = true;

        

        }

        $scope.editIncomeRow = function(income){

            income.id = true;

  

        }

        $scope.saveExpenceRow = function(expence, key, value){


            expence.id = false;

        }

        $scope.saveIncomeRow = function(income, key, value){


            income.id = false;

        }

        $scope.addExpense = function(){
            $scope.AddExpensePressed = true;

        }

        $scope.addIncome = function(){
            $scope.AddIncomePressed = true;

        }


        $scope.saveExpense = function(key, value){
           var newExpense = {'key': key, 'value':value, 'id':false};
       
            $scope.budgetExpences.push(newExpense);
            $scope.AddExpensePressed = false;
        }

        $scope.saveIncome = function(key, value){
            var newIncome = {'key': key, 'value':value, 'id':false};
          
            $scope.budgetIncome.push(newIncome);
            $scope.AddIncomePressed = false;
        }

        $scope.cancelAddExpense = function(){
            $scope.AddExpensePressed = false;
        }

        $scope.cancelAddIncome = function(){
            $scope.AddIncomePressed = false;
        }

    }]);