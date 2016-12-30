/**
 * Created by gilzausmer on 04/10/2016.
 */
var app = angular.module('myApp');
app.service('ViewService', function(){

    var elements = [
        // AdminSettingsViews:
        {'view' : 'addUserView', 'state': false },

        {'view' : 'BuildingForm', 'state': false },
        {'view' : 'ScheduledMaintenanceForm', 'state': false },
        {'view' : 'EventMaintenanceForm', 'state': false },
        {'view' : 'contractorView', 'state': false },
        {'view' : 'PaymentsView', 'state': false },
        {'view' : 'budgetView', 'state': false },
        {'view' : 'expensesFullSize', 'state': false }

        ];
    
    this.selectElement = function(element){
        for(var i=0;i<elements.length;i++){
            if(elements[i].view == element){
           
                elements[i].state = true;
            
            }
            else {
           
                elements[i].state = false;
           
            }
        }
    }

    this.isElementSelected = function(element){


        for(var i=0;i<elements.length;i++){
       
            if(elements[i].view == element && elements[i].state == true) {
                return true;
            }

        }
        return false;
    }

})