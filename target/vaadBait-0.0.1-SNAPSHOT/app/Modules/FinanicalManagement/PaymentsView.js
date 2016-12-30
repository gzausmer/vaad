/**
 * Created by gilzausmer on 04/10/2016.
 */
angular.module('myApp')
    .controller('PaymentsViewController',['$scope','ViewService', function($scope, ViewService) {


        $scope.isSelected = function(){
            return ViewService.isElementSelected('PaymentsView');

        };

        $scope.data = [
            {
                'Apprtmnt': 1,
                "Pays_per_month": 200,
                "Pays_per_year": 2400,
                'Payment_method': 'Direct Debit',
                'Paid_from_January_2016':2000,
                'Paid_in_Advance':'yes',
                'Owes_from_previous_year':300,
                'Currently_owes': 700,
                'Paid_up_to_current_month': 'yes'
            },

            {
                'Apprtmnt': 2,
                'Pays_per_month': 200,
                'Pays_per_year': 2400,
                'Payment_method': 'Cash',
                'Paid_from_January_2016':1000,
                'Paid_in_Advance':'no',
                'Owes_from_previous_year':300,
                'Currently_owes': 700,
                'Paid_up_to_current_month': 'yes'
            },

            {
                'Apprtmnt': 3,
                'Pays_per_month': 100,
                'Pays_per_year': 1400,
                'Payment_method': 'Cashhh',
                'Paid_from_January_2016':4000,
                'Paid_in_Advance':'maybe',
                'Owes_from_previous_year':300,
                'Currently_owes': 600,
                'Paid_up_to_current_month': 'no'
            }
            ]

    }]);
