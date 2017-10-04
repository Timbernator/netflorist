/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




var myMod = angular.module("myApp",[]);


myMod.controller("registerCtrl",function($scope, $http){
    alert("on the controller");
    console.log("waiting for submit to be clicked");
   $scope.submit = function ()
    {
        
        alert(" submit called");
        var url = '/customers';
		
	var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        var data = $scope.customer; 
        $http.post(url, data, config)
            .then(function (response) {
                $scope.postResultMessage = "Sucessful!";
            }, function (response) {
            $scope.postResultMessage = "Fail!";
	});
    };
            
  });
    



