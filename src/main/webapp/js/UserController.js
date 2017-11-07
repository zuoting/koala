app.controller('UserController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {
    var user_id=$routeParams.id;
    $http({
        method: 'GET',
        url: 'http://localhost:8080/users/'+user_id
    }).success(function (data) {
        $scope.userId = data; //数据绑定
    });

    //关注作者
    $scope.followAuthor =function (authorFollow) {
        //alert(23);
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
        var authorFollow={
            "id_to":null,
            "id_from":null
        };
        authorFollow.id_to=id_to;
        authorFollow.id_from=id_from;
        $http({
            url: 'http://localhost:8080/authorFollow',
            method: 'POST',
            data:{"id_to":authorFollow.id_to,
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

    //取消关注作者
    // var id_to=document.getElementById("id_to").value;
    // $http({
    //     method: 'GET',
    //     url: 'http://localhost:8080/authorFollow/'+id_to
    // }).success(function (data) {
    //     $scope.authorIds = data; //数据绑定
    // });
    // $scope.cancelFollowUser = function(authorFollow){
    //     var id = authorFollow.user_id;
    //     $http({
    //         method: 'POST',
    //         url: 'http://localhost/cancelFollowUser',
    //         data:{
    //             "idFrom":$rootScope.user.user_id,
    //             "idTo":authorFollow.user_id
    //         }
    //     }).success(function () {
    //         swal({
    //             title: "成功取消关注",
    //             type: "success",
    //             timer: 1000,
    //             showConfirmButton: false
    //         });
    //         for (var i = 0; i < $rootScope.authorIds.length; i++) {
    //             if($rootScope.authorIds[i] == id){
    //                 $rootScope.authorIds.splice(i,1);
    //             }
    //         }
    //         locals.setObject("authorIds", $rootScope.authorIds);
    //         $rootScope.authorIds = locals.getObject("authorIds");
    //     });
    // }


}]);

//
// //自定义过滤器，用户去除标签并截断显示
// app.filter('contentFilter', function () {
//     return function (input) {
//         input = input.replace(/<[^>]+>/g,'').substring(0,90);
//         console.log(input);
//         return input + "...";
//     }
// });
//
// //自定义过滤器，判断没关注
// app.filter('attention', function () {
//     return function (Ids,id) {
//         for(var i in Ids){
//             if(Ids[i] == id){
//                 return true;
//             }
//         }
//         return false;
//     }
// });
//
// app.factory('locals', ['$window', function ($window) {
//     return {
//         setObject: function (key, value) {
//             $window.localStorage[key] = JSON.stringify(value);
//         },
//         getObject: function (key) {
//             return JSON.parse($window.localStorage[key] || '{}');
//         }
//     }
// }]);
//
//
//
//



