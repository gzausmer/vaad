

  var app =  angular.module("myApp");
    app.config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/');

        $stateProvider

            // login state

            .state('login', {
                url: '/login',
                template: '<login></login>'
            })

            .state('register', {
                url: '/register',
                templateUrl: 'app/registerPage/registerPage.html',
                controller: 'RegisterCtrl',
                controllerAs: 'vm'
            })


        // HOME STATES AND NESTED VIEWS ========================================
            .state('Shell', {
                url: '/',
                views: {
                    '': {templateUrl: 'app/layout/Shell.html'},
                    'NavBar@Shell': {templateUrl: 'app/layout/NavBar.html', controller: 'NavBarCtrl'},
                    'SideBar@Shell': {templateUrl: 'app/layout/SideBar.html', controller: 'SideBarCtrl'},
                    'Expenses@Shell': {templateUrl: 'app/Modules/FinanicalManagement/expencesSheet/expences.html', controller: 'ExpensesCtrl'}
                }
            })

            // AdminSettings:

            .state('Shell.AddUserForm', {
                url: '/AddUserForm',
                templateUrl: 'app/Modules/Settings/Admin_Settings/addUser.html',
                controller:'AddUserCtrl as usrCtrl'
            })

            .state('Shell.BuildingForm', {
                url: '/BuildingForm',
                templateUrl: 'app/Modules/Building/BuildingForm.html',
                controller:'BuildingFormCtrl as vm'
            })

            .state('Shell.SuppliersFormView', {
                url: '/SuppliersFormView',
                templateUrl: 'app/Modules/Maintenance/Suppliers/SuppliersFormView.html',
                controller:'SuppliersFormCtrl as vm'
            })

            .state('Shell.SuppliersView', {
                url: '/SuppliersView',
                templateUrl: 'app/Modules/Maintenance/Suppliers/SuppliersView.html',
                controller:'SuppliersCtrl as vm'
            })

            .state('Shell.ScheduledMaintenanceForm', {
                url: '/ScheduledMaintenanceFormView',
                templateUrl: 'app/Modules/Maintenance/ScheduledMaintenance/ScheduledMaintenanceFormView.html',
                controller:'ScheduledMaintenanceController as vm'
            })

            .state('Shell.EventMaintenanceForm', {
                url: '/EventMaintenanceFormView',
                templateUrl: 'app/Modules/Maintenance/EventMaintenance/EventMaintenanceFormView.html',
                controller:'EventMaintenanceController as vm'
            })

            .state('Shell.MaintenanceJobsView', {
                url: '/MaintenanceJobsView',
                templateUrl: 'app/Modules/Maintenance/ViewAllMaintenanceJobs.html',
                controller:'MaintenanceJobsCtrl as vm'
            })

            .state('Shell.PaymentsView', {
                url: '/PaymentsView',
                templateUrl: 'app/Modules/FinanicalManagement/PaymentsView.html',
                controller:'PaymentsViewController as PmntCtrl'
            })

            .state('Shell.BudgetView', {
                url: '/Budget',
                templateUrl: 'app/Modules/FinanicalManagement/BudgetView.html',
                controller:'BudgetViewController as BdgtCtrl'
            })

            .state('Shell.expensesFullSize', {
                url: '/Expenses',
                templateUrl: 'app/Modules/FinanicalManagement/expencesSheet/expences.html',
                controller:'ExpensesCtrl as expCtrl'
            })



    });
