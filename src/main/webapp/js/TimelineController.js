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

    // 根据专题id获取该碎片所有详情数据
    var timeline_id=$routeParams.id;
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allTimelines/'+ timeline_id
    }).success(function (data) {
        $scope.timelineId = data; //数据绑定
    });

    //设置当前时间
    $scope.today = new Date();

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
        // alert(21);
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

    // 发表一个碎片
    $scope.labelId = 0
    $scope.getLabelId=function (id) {
        // alert(id);
        $scope.labelId=id;
    }
    $scope.allTimeline =function (timelineContent) {
        // alert(21);
        alert(this.labelId);
        if(!$rootScope.token){
            swal({
                title:"请先登录",
                type:"error",
                timer:1000,
                showConfirmButton:false
            });
            window.setTimeout("location.href='http://localhost:8080/sign_in.html'",1100);
        }
        var file=document.querySelector('input[type=file]').files[0];
        console.log(file);
        $http({
            url: 'http://localhost:8080/timelineUser',
            method: 'POST',
            data:{
                file:file,
                user_id:$rootScope.user.user_id,
                label_id:this.labelId,
                content:timelineContent,
                like_count:0,
                comment_count:0
            },
            headers:{'Content-Type':undefined},//请求头的设置
            transformRequest:function (data) {
                console.log(data);
                var formData=new FormData();
                formData.append('file',data.file);
                formData.append('user_id',data.user_id);
                formData.append('label_id',data.label_id);
                formData.append('content',data.content);
                formData.append('like_count',data.like_count);
                formData.append('comment_count',data.comment_count);
                return formData;
            }
        }).success(function (data) {
            swal({
                title: "发布碎片成功",
                type: "success",
                timer: 1500,
                showConfirmButton: false
            });
            setCookie("timelineContent",data);//重新设置cookie
            setTimeout("window.location.reload()",1050);
        });

    };


}]);

//头像选择预览函数
function getTimelinePicture() {
    $("#photoTimeline").click(); //点击头像，模拟input type=file
}

function setTimelineImage(docObj,localImagId,imgObjPreview) {
    // alert('change');
    var f=$(docObj).val();
    f=f.toLowerCase();
    var strRegex=".bmp|jpg|png|jpeg$";
    var re=new RegExp(strRegex);
    if (re.test(f.toLowerCase())){
        //return true;
    }
    else {
        alert("请选择正确格式的图片");
        file=$("#photoTimeline");
        file.after(file.clone());
        file.remove();
        return false;
    }
    if(docObj.files && docObj.files[0]){
        imgObjPreview.src=window.URL.createObjectURL(docObj.files[0]);
    }else {
        //IE下，使用滤镜
        docObj.select();
        var imgSrc=document.selection.createRange().text;
        //图片异常的捕获，防止用户修改后缀来伪造图片
        try {
            localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src=imgSrc;
        }catch (e){
            alert("您上传的图片格式不正确，请重新选择!");
            return false;
        }
        imgObjPreview.style.display='none';
        document.selection.empty();
    }
    return true;
}

//读取cookies
function getCookie(name) {
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg)){
        return arr[2];
    }else{
        return null;
    }
}

//写cookies
function setCookie(name,value) {
    var exp=new Date();
    exp.setTime(exp.getTime() + 2 * 60 * 60 * 1000);//有效时间
    document.cookie=name + "=" +JSON.stringify(value);
}