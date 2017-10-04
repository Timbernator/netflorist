/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var myloginModule = angular.module("myApp",[]);

myloginModule.controller("loginCtrl",function($scope, $http){
    alert("im on login controller");
    $scope.login = function(){
      alert("login was clicked"); 
     $http({
            url: '/login',
            method: 'GET',
            params: {username: $scope.username , password: $scope.password}
    }).then(successCallback, errorCallback);
            function successCallback(respose) {
                 $scope.Details = respose.data;
                 console.log(respose);
            }
            function errorCallback(respose) {
             $scope.Details = respose.data;
	}
    };

//        var params = {'/?username={username}&password={password}'};
//      var url = '/login';
//		
//	var config = {
//            headers : {
//                'Content-Type': 'application/json;charset=utf-8;'
//            }
//        };
//        var data = $scope.customer; 
//        $http.get(url, params)
//                .success(function (data) {
//                 $scope.Details = data;
//            })
//                .error(function (data) {
//             $scope.Details = data;
//	});
});


