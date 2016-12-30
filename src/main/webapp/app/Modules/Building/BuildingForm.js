//TODO - organise the whole sending of arrays. differtiate between addAndSubmit to submit (maybe name it 'Done")

angular.module('myApp')
.controller('BuildingFormCtrl',['$scope','ViewService', 'HttpService', 
                                function($scope, ViewService, HttpService) {
	var vm = this;
	vm.isSelected = function(){
		return ViewService.isElementSelected('BuildingForm');
	};
	
	$scope.sendBuildingForm = function(){
		alert('first');
		HttpService.processForm('POST',angular.toJson(vm.BuildingDetails), './rest/addBuilding');
		
	};
	
	$scope.sendAssetForm = function(){
		alert('first');
		HttpService.processForm('POST',angular.toJson(vm.AssetDetails), './rest/addAssets');
		
	};
	
	$scope.sendAssetForm = function(){
		alert('first');
		HttpService.processForm('POST',angular.toJson(vm.TenantDetails), './rest/Tenants');
		
	};

	$scope.showTenantDetails = false;
	vm.BuildingFormFinished = false;
	$scope.showApartmentDetailsFormViewSelected = false;
	var Building_localStorage = [];
	vm.BuildingDetails = {};
	vm.AssetDetails = [];
	vm.TenantDetails = [];

	$scope.storeBuildingDetails = function(){

		Building_localStorage.push(vm.BuildingDetails);
		HttpService.processForm('POST',angular.toJson(vm.BuildingDetails), './rest/addBuilding');
		
		$scope.BuildingFormFinished = true;
		$scope.showAssetForm = true;
	}
	
	$scope.counterApartment = 0;
	$scope.counterCommenrcialSpace = 0;
	$scope.counterStoreRooms = 0;

	$scope.submitAndAddAnotherAsset = function(){

		if($scope.assetForm.assetType == 'Appartment'){
			$scope.counterApartment ++;
		}
		if($scope.assetForm.assetType == 'Commercial Space'){
			$scope.counterCommenrcialSpace ++;
		}
		if($scope.assetForm.assetType == 'Store Room'){
			$scope.counterStoreRooms ++;
		}
		vm.AssetDetails.push($scope.assetForm);
		
		Building_localStorage.push(vm.AssetDetails);
		HttpService.processForm('POST',angular.toJson(vm.AssetDetails), './rest/addAssets');
		
		$scope.assetForm = {};
	};

	$scope.submitAndAddAnotherTenant = function(){

		vm.TenantDetails.push($scope.tenantForm);
		$scope.assetForm = {};
		Building_localStorage.push(vm.TenantDetails);
		HttpService.processForm('POST',angular.toJson(vm.AssetDetails), './rest/addAssets');	
	};

	$scope.showApartmentDetailsForm = function(){

		$scope.BuildingFormFinished = true;
		$scope.showApartmentDetailsFormViewSelected = true;
	};

}]);
