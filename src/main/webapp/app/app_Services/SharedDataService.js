/**
 * Created by gilzausmer on 25/11/2016.
 */

angular
    .module('myApp')
    .service('SharedData', function () {
        var sd = this;
        sd.email = "nothingSoFar";
        sd.scheduledMaintenance = {"system":"",
                                    "status":"",
                                    "type":"",
                                    "lastCheck":"",
                                    "serviceFreqNumber":"",
                                    "serviceFreqEach":"",
                                    "serviceFreqTime":"",
                                    "supplier":""};

        sd.setEmail = function(email){
                sd.email =  email;
        }
        sd.alreadyWelcomed = 0;
        sd.currentMaintenanceStatusId = 0;
        sd.unreadEventsAmount = 0;
        sd.notificationExist = false;
        sd.selectedCheckBox = [];

       });



