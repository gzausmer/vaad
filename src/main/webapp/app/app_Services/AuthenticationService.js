/**
 * Created by gilzausmer on 20/10/2016.
 */

    angular
        .module('myApp')
        .service('AuthenticationService', function ($http, $localStorage, jwtHelper) {

            var auth = this;
            auth.welcomeUsername = "";

        var service = {};

        service.Login = Login;
        service.Logout = Logout;

        return service;

            function Login(email, password, callback) {
            	
            $http.post('./rest/login', { email: email, password: password })
                .success(function (response) {
                	
                    // login successful if there's a token in the response
                    if (response.token) {
                        // store username and token in local storage to keep user logged in between page refreshes
                        $localStorage.currentUser = { email: email, token: response.token };
                        var tokenPayload = {};
                        tokenPayload = jwtHelper.decodeToken(response.token);
                        $localStorage.firstName = tokenPayload.firstname;
                        console.log("££££££££££"+tokenPayload);
                        console.log("££££££££££" + tokenPayload.firstname);
                        // add jwt token to auth header for all requests made by the $http service
                        $http.defaults.headers.common.Authorization = 'Bearer ' + response.token;

                        // execute callback with true to indicate successful login
                        callback(true);
                    } else {
                        // execute callback with false to indicate failed login
                        callback(false);
                    }
                });
        }

        function Logout() {
           
            // remove user from local storage and clear http auth header
            delete $localStorage.currentUser;
            delete $localStorage.alreadyWelcomed;
            $http.defaults.headers.common.Authorization = '';

        }
    }
);