/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#form_login_before_launch").click(function(){
        $(this).animate({height:"250px" ,width:"400px"});
        $(this).children("p").animate({fontSize:"25px"});
    });
});
