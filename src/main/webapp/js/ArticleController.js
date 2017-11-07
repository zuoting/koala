app.controller('ArticleController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {

    /*文章详情*/
    var article_id=$routeParams.id;
    $http({
        method: 'GET',
        url: 'http://localhost:8080/articles/'+article_id
    }).success(function (data) {
        $scope.articleId = data; //数据绑定
    });

    /*电台文章详情*/
    $http({
        method: 'GET',
        url: 'http://localhost:8080/radioArticles/'+article_id
    }).success(function (data) {
        $scope.radioArticleId = data; //数据绑定

        // 音乐播放
        var obj = document.getElementById("bgMusic");
        obj.src = $scope.radioArticleId.song_url;
    });

    //喜欢（关注）一个文章
    $scope.followArticle =function (likeFroms) {
        if(!$rootScope.token){
            swal({
                title:"请先登录",
                type:"error",
                timer:1000,
                showConfirmButton:false
            });
            window.setTimeout("location.href='http://localhost:8080/sign_in.html'",1100);
        }
        var article_id=document.getElementById("article_id").value;
        var user_id=document.getElementById("user_id").value;
        var likeFroms={
            "article_id":null,
            "user_id":null
        };
        likeFroms.article_id=article_id;
        likeFroms.user_id=user_id;
        $http({
            url: 'http://localhost:8080/likeFroms',
            method: 'POST',
            data:{"article_id":likeFroms.article_id,"user_id":likeFroms.user_id}
        }).success(function () {
            swal({
                title:"收藏文章成功",
                type:"success",
                showConfirmButton:false
            });
            setTimeout('window.location.reload()',1050);
        });
    };

    //发表一个评论
    $scope.commentArticle =function (content) {
        //alert(21);
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
            url: 'http://localhost:8080/comments',
            method: 'POST',
            data:{
                "article_id":article_id,
                "user_id":$rootScope.user.user_id,
                "content":content,
                "comment_time":new Date()

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


}]);
