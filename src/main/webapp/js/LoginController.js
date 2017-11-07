app.controller('LoginController',function ($scope,$rootScope,$http) {
    //登录
    $rootScope.signIn=function (user) {
        $http({
            url: 'http://localhost:8080/signIn',
            method: 'POST',
            data:{"account":user.account,"password":user.password}
        }).then(function success(response) {
            console.log(response);
            console.log(response.data.user.password);
            if(response.data.user.password == user.password ){
                swal({
                    title:"登录成功",
                    type:"success",
                    timer:1000,
                    showConfirmButton:false
                });
                setCookie("user",response.data.user);//用户的基本信息
                setCookie("token",response.data.token);//用户的令牌
                /*setCookie("myFollow",data.myFollow);*/
                window.setTimeout("location.href='http://localhost:8080'",1200);
            }
            else{
                swal({
                    title:"Oh,My God! 登录失败,请重新输入",
                    type:"error",
                    timer:1000,
                    showConfirmButton:false
                });
            }
        },function error() {
            swal({
                title:"Oh,My God! 登录失败,请重新输入",
                type:"error",
                timer:1000,
                showConfirmButton:false
            });
        });
    };

    //注册
    $rootScope.signUp=function (user) {
        //alert(21);
        $http({
            url: 'http://localhost:8080/signUp',
            method: 'POST',
            data:{
                "account":user.account,
                "password":user.password,
                "nickname":user.nickname,
                "head": "img/default.jpg",
                "description": "这是一个还没有简介的Koalar~" ,
                "write_count":0,
                "fans_count":0
            }
        }).success(function () {
            swal({
                title: "注册成功",
                type: "success",
                timer: 1500,
                showConfirmButton: false
            });

            window.setTimeout("location.href='http://localhost:8080/sign_in.html'",1200);
        });
    };

    //管理员登录
    $scope.adminLogin=function(admin){
        $http({
            url: 'http://localhost:8080/adminLogin',
            method: 'POST',
            data: {
                username:admin.username,
                password:admin.password
            }
        }).success(function (data) {
            // console.log(data);
            if(data.msg==null){
                //跳到登录页 账号密码错误
                swal({
                    title:"Oh,My God! 登录失败,请重新输入",
                    type:"error",
                    timer:1000,
                    showConfirmButton:false
                });
                setTimeout("window.location.href='http://localhost:8080/login.html'",1200);
            }else{
                swal({
                    title: "登录成功"+data.msg.username,
                    type: "success",
                    timer: 1500,
                    showConfirmButton: false
                });
                setCookie("msg",data.msg);
                window.setTimeout("location.href='http://localhost:8080/backManage.html#/userManage'",1200);
            }


        });
    };

});
//写cookies
function setCookie(name,value) {
    var exp=new Date();
    exp.setTime(exp.getTime() + 2 * 60 * 60 * 1000);//有效时间
    document.cookie=name + "=" +JSON.stringify(value);
}
