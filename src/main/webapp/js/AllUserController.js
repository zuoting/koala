app.controller('AllUserController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allUsers'
    }).success(function (data) {
        //console.log(data);
        $scope.allUsers = data; //数据绑定
    });

    //关注作者
    $scope.followAuthor =function (idTo) {
        // alert(idTo);
        if(!$rootScope.token){
            swal({
                title:"请先登录",
                type:"error",
                timer:1000,
                showConfirmButton:false
            });
            window.setTimeout("location.href='http://localhost:8080/sign_in.html'",1100);
        }

        var id_to=document.getElementById("id_to").value;//被关注人id
        var id_from=document.getElementById("id_from").value; //关注人id
        console.log(id_to)
        console.log(id_to)
        var authorFollow={
            "id_to":null,
            "id_from":null
        };
        authorFollow.id_to=id_to;
        authorFollow.id_from=id_from;
        $http({
            url: 'http://localhost:8080/authorFollow',
            method: 'POST',
            data:{
                "id_to":idTo,
                "id_from":authorFollow.id_from}
        }).success(function () {
            swal({
                title:"关注成功",
                type:"success",
                showConfirmButton:false
            });
           setTimeout('window.location.reload()',1050);
        });
    };

}]);
