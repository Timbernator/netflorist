/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
'use strict';
var myMod = angular.module("myApp",["ngRoute"]);

myMod.config(["$routeProvider","$locationProvider",function($routeProvider,$locationProvider) {
    
      
    $routeProvider
    .when('/', {
       
        templateUrl :'/login.html',
        controller : 'loginCtrl'
    })
    .when('/register', {
        
        templateUrl : '/register.html',
       controller : 'registerCtrl'
    })
    .when('/adminRegister',{
        templateUrl:'/adminRegister.html',
        controller:'adminRegisterCtrl'
    })
    .when('/login', {
       
        templateUrl : '/login.html',
        controller : 'loginCtrl'
    })
    .when('/registered', {
        
        templateUrl : '/registered.html'
       
    })
    .when('/forgotPassword',{
        templateUrl : '/forgotPassword.html',
        controller : 'verifyIdCtrl'
        
    })
    .when('/errors',{
        templateUrl : '/errorpage.html'
    })
    .when('/viewProducts',{
        templateUrl :'/viewProducts.html',
        controller : 'productsCtrl'
    })
    .when('/adminPage',{
        templateUrl:'/adminPage.html'
    })
    .when('/users',{
        templateUrl :'/users.html',
        controller : 'usersCtrl'
        
    })
    .when('/adminProducts',{
        templateUrl : 'adminProducts.html',
        controller : 'productsCtrl'
                
    })
    .when('/cart',{
        templateUrl: 'cart.html'
    })
    .when('/addProduct',{
        templateUrl : 'addProduct.html',
        controller: 'addingProductCtrl'
    })
    .when('/upload',{
        templateUrl:'upload.html',
        controller:'addingProductCtrl'
    })
    .when('/checkout',{
        templateUrl: 'checkout.html',
        controller: 'shoppingCtrl'
    })
    .when('/order',{
        templateUrl: 'order.html'
    })
    .when('/adminOrder',{
        templateUrl:'adminOrder.html',
        controller:'ordersCtrl'
    })
    .when('/checkedError',{
        templateUrl:'checkedError.html'
    })
    .otherwise({
        redirectTo :'/'
    });
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('#');
}]);

/*myMod.controller("passwordCtrl", function($scope) {
    

password: $scope.password;
password2: $scope.passw2 ;

$scope.passValidation = false;
$scope.changepassword = function()
{
    var regexp = /^(=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,10}$/;
    if(regexp.test($scope.customer.password)===false)
    {
        $scope.passValidation = false;
        
    }
    else
    {
        $scope.passValidation = true;
    }
};

});*/
  
myMod.controller("registerCtrl",function($scope, $http,$location,$rootScope){
   
    
   $scope.submit = function ()
    {
        
        
        var url = '/register';
		
	var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        
        var data = $scope.customer;
       
        $http.post(url, data, config)
            .then(function (response) {
                
                $rootScope.customer = data;
               
                $location.url("/registered");
            }, function (response) {
            
            $location.Url("/error");
	});
    };
            
  });
  
myMod.controller("verifyIdCtrl",function($scope,$http,$location,$rootScope){
     
     $scope.status = 'true';
     $scope.fetchQuestion = function(){
         alert("verifiation in progresss");
         $http({
            url: '/customers/'+ $scope.id,
            method: 'GET'
            
         }).then(verifivationCallback, errorVerificationCallback);
         function verifivationCallback(response){
             
             $scope.status = 'true';
             console.log(response);
             console.log($location.path());
             $location.url('/forgotPassword');
             if($scope.id===response.data.id)
             {
                 $rootScope.customer = response.data;
             }else
             {
                 errorVerificationCallback(response);
             }
         }
         function errorVerificationCallback(response) {
             $scope.error = "false";
         }
     };

 });  
 
myMod.controller("verifyAnswerCtrl",function($scope,$rootScope){
          $scope.checkAnswer =function(){
        var customer = $rootScope.customer;
        if ($scope.securityAns===customer.securityAns) {
            $scope.answer = 'Password :'+ $rootScope.customer.password;
            
        }
        else
        {
            $rootScope.answer = 'Wrong Answer Try Again!';
        }
     };
 });
 
myMod.controller("productsCtrl", function ($scope,$route, $http,$location){
    
     $http.get('/products'
         ).then(successCallback, errorCallback);
        function successCallback(respose) {
             
            if($scope.customer.userRole==='admin')
            {
                $scope.products = respose.data;
                $location.url('/adminProducts');
            }
                $scope.products = respose.data;

             
             console.log(respose);
             
        }
        function errorCallback(respose) {
             $scope.Details = respose.data;
        }
        
        $scope.deleteProduct = function(id){
            $http({
            method: 'DELETE',
            url: '/products/'+ id
          }).then(successCallback, errorCallback);
            function successCallback(respose) {
                $route.reload();
                alert("success");
                
                $location.url('/adminProducts');
            }
            function errorCallback(respose)
            {
                alert("failed");
            }
        };
   
 });
 
myMod.controller("loginCtrl",function($scope, $http,$location,$rootScope, $route){
    $scope.login = function(){
      
     $http({  
            url: '/login',
            method: 'GET',
            params: {username: $scope.username , password: $scope.password}
    }).then(successCallback, errorCallback);
            function successCallback(respose) {
                var customer = respose.data;
                if ($scope.username===customer.username) {
                    $rootScope.customer = customer;
                        console.log(respose);

                       if(customer.userRole==='client')
                       {
                           
                            $location.url('/viewProducts');
                       }
                       else
                       {
                   
                        $location.url('/adminPage'); 
                       }

                }
                else
                {
                    $rootScope.answer = 'Username or Password is incorrect!';
                }           
            }
            function errorCallback(respose) {
             
                $scope.answer = respose.data;
                $route.reload();
	}
    };
});

myMod.controller("usersCtrl",function ($scope, $http,$route){
     $http.get('/customers'
         ).then(successCallback, errorCallback);
            function successCallback(respose) {
                console.log(respose);
                var customer = respose.data;
                    $scope.customerAdmin = customer;
        }
        function errorCallback(respose) {
             $scope.Details = respose.data;
        }
});

myMod.filter('capitalize', function() {
    return function(input) {
      return (!!input) ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
    };
});

myMod.controller('deleteCrtl',function ($scope,$http,$route,$location){
    
    $scope.deleteUser=function (id){
        $http({
            method: 'DELETE',
            url: '/customers/'+ id
          }).then(successCallback, errorCallback);
            function successCallback(respose) {
                $route.reload();
                alert("success");
                
                $location.url('/users');
            }
            function errorCallback(respose)
            {
                alert("failed");
            }
    };
    
});

 myMod.controller("adminRegisterCtrl",function($scope, $http,$location,$rootScope){
   
    
   $scope.deliver = function ()
    {
        
        
        var url = '/register';
		
	var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        
        var data = $scope.admin;
        $http.post(url, data, config)
            .then(function (response) {
                alert("registration");
                $rootScope.customer = data;
                console.log(response);
               
                $location.url("/users");
            }, function (response) {
            
            $location.url("/error");
	});
    };
            
  });
/*------------------------------------------------
 * 
 *          Cart Functionality
 ------------------------------------------------*/
myMod.controller('shoppingCtrl',function($scope,$location,$http,$rootScope,$filter){
    
    $scope.showMe = false;
    
    $rootScope.cartItems = [];
//    var cartData = localStorage.getItem("cdata");
    //add products into a cart
    $scope.myFunc = function() {
        $scope.showMe = !$scope.showMe;
        
    };
    $scope.addCartItem = function(product){
                 
        var existingItem = getExistingCartItem(product.id);
        
        if(existingItem === null){
            
            $rootScope.cartItems.push({ name : product.name, 
                quantity: 1, 
                product_id : product.id, 
                price : product.price,
                description : product.description
                
            });
            console.log($rootScope.cartItems);
            
        }else{
            existingItem.quantity++;
        }


    };
    //checks if the the product was added befor into the cart
    function getExistingCartItem(id){
//        $scope.cartItems = convertCartToArray(cartData);
        for(var i=0; i< $rootScope.cartItems.length; i++){
            if($rootScope.cartItems[i].product_id === id){
                return $rootScope.cartItems[i];
            }
        }

        return null;
    }

    //calculates the total amount on the cart
    $scope.cartSum = function(){
        var sum =0;
        $rootScope.cartItems.forEach(function(item){
            sum += item.quantity * item.price;
            
        });

        return $rootScope.totalAmnt = sum;
    };
    //increace quantyity in the cart
    $scope.increase = function(item){
        
        item.quantity++;
    };
    
    function getItemIndex(item){
        
        for (var i = 0, max = $rootScope.cartItems[i].length; i < max; i++) {
            if ($rootScope.cartItems[i].id===item.id) {
                
                return i;
            }
            break;
        }
        return i;
    }
    //decrease the quntity in the  cart
    $scope.decrease = function(item){
        
        var index = getItemIndex(item);
        
        if(item.quantity -1 === 0){
            
            $rootScope.cartItems.splice(index,1);
        }
        else{
            
            item.quantity--;
        }
        
    };
 
    //remove from cart
    $scope.removeFromCart = function(item){ 
        
	
            var index = getItemIndex(item);
            
            $rootScope.cartItems.splice(index, 1); 
        };
        
        $scope.checkOut = function (){
             
            console.log($rootScope.cartItems);
            $rootScope.itemsNum = $rootScope.cartItems.length;
            $scope.placeOrder();
            $location.url('/checkout');  
        };
        $scope.payment = function (){
            
            $http({
                    url: '/payment',
                    method: 'GET',
                    params: {accountNo: $scope.bankAcc , pin: $scope.bankpin}
            }).then(successCallback, errorCallback);
            function successCallback(respose) {
                var bankDetails = respose.data;
                if ($scope.bankname===bankDetails.bankType) {
         
                    if($rootScope.totalAmnt<=bankDetails.balance)
                    {

                        bankDetails.balance -=$rootScope.totalAmnt;
                        alert("payment was successful!");
//                        $scope.placeOrder();
                         
                        $location.url("/order");
                    }
                    else
                    {

                        $rootScope.balanceResponse = 'you have insuficient balance on your account';
                     
                    }

                }
                else
                {
                    $rootScope.balanceResponse = 'The selected Bank doesn`t have such account number!';
                }           
            }
            function errorCallback(respose) {
                $rootScope.balanceResponse = 'invalid account number or worng pin, please verify and try again!';
            }
        };
        
        $scope.placeOrder = function(){
            var data = {customer : $rootScope.customer, 
                amount: $rootScope.totalAmnt,
                productCopy: $rootScope.cartItems,
                quantity:$rootScope.itemsNum};
            alert($rootScope.cartItems);
                    $http({
                        url: '/placeOrder',
                        method: "POST",
                        data:data,
                        headers: {
                        'Content-Type': 'application/json;charset=utf-8;'
                    }
                    }).then(successCallback, errorCallback);
                    function successCallback(response) {
                        alert("placling order");
                        $rootScope.order = response.data;  
                        $scope.submitOrder();
                    }
                    function errorCallback(response) {
                        alert("failed");
                    $location.url("/error");
                    };  
        };
        
        $scope.submitOrder = function()
        {
            
            alert("order id is"+$rootScope.order.id );
            var data = {product_id: $rootScope.cartItems.product_id,
                    quantity:$rootScope.cartItems.quantity,
                    price: $rootScope.cartItems.price,
                    name: $rootScope.cartItems.name,
                    orderedDate: $scope.orderedDate = $filter('date')(new Date(), 'yyyy-MM-dd'),
                    status:'recieved',
                    description:$rootScope.cartItems.description,
                    order: $rootScope.order};
            
            for (var i = 0, max = data.length; i < max; i++)  {
                  var jsonData = angular.toJson(data[i]);
                  alert(jsonData);
                    $http({
                        url: '/productCopy',
                        method: "POST",
                        data:jsonData,
                        headers: {
                        'Content-Type': 'application/json;charset=utf-8;'
                    }
                    }).then(successCallback, errorCallback);
                    function successCallback(response) {    
                        alert("displaying ordered products");
                        $rootScope.orderedProducts = response.data;
                        
                        console.log(response.data);   
                       
                    }
                    function errorCallback(response) {
                        alert("failed");
                        $location.url("/error");
                    };  

            }
        };

});

/*
 *      Uploading of a picture
 */
myMod.controller("addingProductCtrl", function ($scope, $http,$location)
{
    $scope.image = null;
    $http.defaults.headers.post["Content-Type"] = "application/json";

    var url = '/addProduct';

    var imageCopy = null;
    var image = null;
    var handleImageSelect = function (evt)
    {
        var files = evt.target.files;
        var file = files[0];

        if (files && file) {
           
            var reader = new FileReader();
            reader.onload = function (readerEvt) {
                var binaryString = readerEvt.target.result;
                imageCopy = btoa(binaryString);
                image = 'data:image/octet-stream;base64,' + imageCopy;
                $scope.image = image;
                
            };

            reader.readAsBinaryString(file);
        }
    };

    if (window.File && window.FileReader && window.FileList && window.Blob) {
        document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
    } else {
        alert('The File APIs are not fully supported in this browser.');
    }
    $scope.saveProd = function ()
    {

        $http.post(url, {
            name:  $scope.name,
            description: $scope.description,
            price: $scope.price,
            image: $scope.image

        }).then(successCallback, errorCallback);
           function successCallback(response) {
                alert("success");
                $location.url('/adminProducts');
            }
            function errorCallback(response) {
                console.log(response);
                alert("fail");
            };        
    };

});

myMod.controller("ordersCtrl", function($scope,$http,$route,$location){
   
    
    $http({
            url: '/customerOrders',
            method: 'GET'
                    
            }).then(successCallback, errorCallback);
            function successCallback(response) {
                        
                        $scope.allOrders = response.data;
                        $scope.deliver  = {deliveryDate: new Date()};
                        $scope.example = {
                                value: new Date()
                              };
            }
            function errorCallback(response) {
                $scope.answer = response.data;
            }
            
    $scope.updateOrder = function(order){
         alert(order);
        console.log(order); 
        var url = 'customers/'+order.customer.id+'/customerOrders/'+order.id;
		
	var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        
        var data = $scope.order;
//        console.log(data);
//        alert(data);
        $http.put(url, data, config)
            .then(function (response) {
                alert("order update was successful!");
                $scope.allOrders = response.data;
                $route.reload();
                $location.url('/adminOrder');            
            }, function (response) {
            
            $location.url("/error");
	});
        
        
    }; 
    $scope.deleteOrder=function(order){
        
      $http({
          url:'/customerOrders/'+order.id,
          method:'DELETE'
      }).then(successCallback, errorCallback);
            function successCallback(response) {
                        alert("order deleted successfully!");
                        $scope.allOrders = response.data;
                        $route.reload();
                        $location.url('/adminOrder');
            }
            function errorCallback(response) {
                $scope.answer = response.data;
            }
    };   
    
});


// myMod.controller('DateCtrl', function ($filter,$scope) {
//    // https://docs.angularjs.org/api/ng/filter/date
//    $scope.today = $filter('date')(new Date(), 'yyyy/MM/dd');
//    alert($scope.today);
//});