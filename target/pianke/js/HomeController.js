
app.controller('HomeController',function ($scope,$http,$rootScope,$routeParams) {

    if(getCookie('user')){
        $rootScope.user=JSON.parse(getCookie('user'));
    }
    if(getCookie('token')){
        $rootScope.token=JSON.parse(getCookie('token'));
    }

    /*导航热门电台图片*/
    $http({
        method: 'GET',
        url: 'http://localhost:8080/articlePics'
    }).success(function (data) {
        $scope.articlePics = data; //数据绑定
    });
    /*导航热门电台图片*/
    $http({
        method: 'GET',
        url: 'http://localhost:8080/radioPicArticles'
    }).success(function (data) {
        $scope.radioPicArticles = data; //数据绑定
    });

    /*热门文章*/
    $http({
        method: 'GET',
        url: 'http://localhost:8080/articles'
    }).success(function (data) {
        $scope.articles = data; //数据绑定
    });
    /*热门电台的3个文章*/
    $http({
        method: 'GET',
        url: 'http://localhost:8080/radioArticles'
    }).success(function (data) {
        $scope.radioArticles = data; //数据绑定
    });
    /*热门作者*/
    $http({
        method: 'GET',
        url: 'http://localhost:8080/users'
    }).success(function (data) {
        $scope.users = data; //数据绑定
    });

  // 往期所有文章
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allArticles'
    }).success(function (data) {
        $scope.allArticles = data; //数据绑定
    });

    //注销
    $scope.logout = function () {
        // swal("确定登出考拉吗？");
        alert("确定登出考拉吗？");
        delCookie("user");
        delCookie("token");
        setTimeout("window.location.href='http://localhost:8080'",50);
    }


    //点击简信按钮  弹出修改面板
    $scope.showLetter=function(){
        document.getElementById("sendBtn").style.display='block';
        // console.log($scope.userId[index]);
        /*通过$index 来接收每一行的数组遍历下标 然后再scope 作用域里我们就可以拿到 allUser[index] 的数据了*/
        $rootScope.userInfo=$scope.userId[index];
    };
    //点击取消按钮，发简信框消失
    $scope.cancelBtn=function () {
        document.getElementById("sendBtn").style.display='none'
    };
    //发表一个简信
    $scope.letterUser =function (content) {
        $rootScope.userInfo=$scope.userId[index];
        alert(21);
        if(!$rootScope.token){
            swal({
                title:"请先登录",
                type:"error",
                timer:1000,
                showConfirmButton:false
            });
            window.setTimeout("location.href='http://localhost:8080/sign_in.html'",1100);
        }
        $http({
            url: 'http://localhost:8080/letters',
            method: 'POST',
            data:{
                "to_id":userInfo.user_id,
                "from_id":$rootScope.user.from_id,
                "content":content,
                "letter_time":new Date()

            }
        }).success(function () {
            swal({
                title:"评论成功",
                type:"success",
                showConfirmButton:false
            });
            setTimeout('window.location.reload()',1050);
        });
    };

});

//读取cookies
function getCookie(name) {
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg)){
        return arr[2];
    }else{
        return null;
    }
}

/*注销*/
function delCookie(name){
    var date = new Date();
    date.setTime(date.getTime() - 10000);
    document.cookie = name + "=a; expires=" + date.toGMTString();
}