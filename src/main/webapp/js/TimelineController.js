app.controller('TimelineController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {
    $scope.now = -1;
    // 获取碎片所有专题
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allLabels'
    }).success(function (data) {
        $scope.allLabels = data; //数据绑定
    });

    // 查询所有碎片
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allTimelines'
    }).success(function (data) {
        $scope.allTimelines = data; //数据绑定
    });
    $scope.selectTopicArticle = function (index,topicId) {
        $scope.label_name = $scope.allLabels[index].label_name;
        $scope.thisTopic = topicId;
        $scope.now = index;
    }

    //    根据专题id获取该碎片所有详情数据
    var timeline_id=$routeParams.id;
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allTimelines/'+ timeline_id
    }).success(function (data) {
        $scope.timelineId = data; //数据绑定
    });

    /*点击添加标签,列表显示出来*/
    $(".tag_icon").click(function(){
        $(".tag_dropmenu").show();
    });
    /*鼠标移出添加标签,列表隐藏*/
    $(".tag_icon").mouseout(function(){
        $(".tag_dropmenu").fadeOut(1000);
    });
    /*鼠标移到标签列表,列表显示出来*/
    $(".tag_dropmenu").mouseover(function(){
        $(".tag_dropmenu").stop().show();
    });
    /*鼠标移出标签列表,列表隐藏*/
    $(".tag_dropmenu").mouseout(function(){
        $(".tag_dropmenu").hide();
    });


    //发表一个评论
    $scope.timelineCommentArticle =function (content) {
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
            url: 'http://localhost:8080/timelineComments',
            method: 'POST',
            data:{
                "timeline_id":timeline_id,
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
