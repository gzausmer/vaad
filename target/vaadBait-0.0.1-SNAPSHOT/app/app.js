// Code goes here

var app = angular.module('myApp', ['ui.bootstrap','ui.router', '720kb.fx', 'ngMessages', 'ngStorage', 'angular-jwt', 'angular-uuid']);

app.run(init);


function init($rootScope, $http, $location, $localStorage) {

    // keep user logged in after page refresh
    if ($localStorage.currentUser) {
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
    }

    if(!$localStorage.alreadyWelcomed) {
        $localStorage.alreadyWelcomed = 1;
        console.log("already welcomed? "+$localStorage.alreadyWelcomed);
    }
    else{
        $localStorage.alreadyWelcomed = 2;
        console.log("already welcomed? "+$localStorage.alreadyWelcomed);
    }



    // redirect to login page if not logged in and trying to access a restricted page
    $rootScope.$on('$locationChangeStart', function (event, next, current) {

        var publicPages = ['/login'];
        var restrictedPage = publicPages.indexOf($location.path()) === -1;
        if (restrictedPage && !$localStorage.currentUser) {
            $location.path('/login');
        }
    });
};








