
    angular
        .module('myApp')
        .service('HttpService', function ($http, $localStorage, jwtHelper) {

       this.processForm = function (method,formData, URL) {
    	   console.log(formData);
            	 $http({
            	      method  : method,
            	      url     : URL,
            	      data    : formData,  // pass in data as strings
            	      headers : {'Content-Type': 'application/json'}  // set the headers so angular passing info as form data (not request payload)
            	     })
            	      .success(function(data) {
            	        console.log(data);

            	        if (!data.success) {
            	          // if not successful, bind errors to error variables
            	         
            	        	 console.log(data);
            	        } else {
            	          // if successful, bind success message to message
            	          $scope.message = data.message;
            	        }
            	      })};

			this.processMultiPartForm = function (method,FileData,FileName,URL) {

                console.log(FileData);
                var formData = new FormData;
                formData.append("fileName", FileName);
                formData.append("file", FileData);
				$http({
					method  : method,
					url     : URL,
					headers : {'Content-Type': undefined},
                    transformRequest: angular.identity,
                    data: formData
				})
					.success(function(data) {
						console.log(data);

						if (!data.success) {
							// if not successful, bind errors to error variables

							console.log(data);
						} else {
							// if successful, bind success message to message
							$scope.message = data.message;
						}
					})};



        });


     
