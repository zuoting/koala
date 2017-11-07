app.controller('PersonalController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {
    $rootScope.user=JSON.parse(getCookie('user')); //获取新的cookie，设置为 $rootScope.user
    $http({
        method: 'GET',
        url: 'http://localhost:8080/users/'+$rootScope.user.user_id
    }).success(function (data) {
        $scope.userId = data; //数据绑定
    });
    // 个人中心
    $http({
        method: 'GET',
        url: 'http://localhost:8080/personal/'+$rootScope.user.user_id
    }).success(function (data) {
        $scope.personal = data; //数据绑定
    });

    //修改个人信息
    $scope.update=function () {
        var file=document.querySelector('input[type=file]').files[0];
        var account=document.getElementById('account').value;
        var password=document.getElementById('password').value;
        var nickname=document.getElementById('nickname').value;
        var description=document.getElementById('description').value;
        //alert(account + nickname + description);
        $http({
            url: 'http://localhost:8080/updateUsers',
            method: 'POST',
            data:{
                file:file,
                nickname:nickname,
                password:password,
                description: description,
                account:account
            },
            headers:{'Content-Type':undefined},//请求的设置
            transformRequest:function (data) {
                var formData=new FormData();
                formData.append('file',data.file);
                formData.append('nickname',data.nickname);
                formData.append('password',data.password);
                formData.append('description',data.description);
                formData.append('account',data.account);
                return formData;
            }

        }).success(function (data) {
            swal({
                title: "个人信息修改成功",
                type: "success",
                timer: 1500,
                showConfirmButton: false
            });
            setCookie("user",data);//重新设置cookie
            setTimeout("window.location.reload()",1050);
        });
    }

}]);


//头像选择预览函数
function getPicture() {
    $("#photo").click(); //点击头像，模拟input type=file
}

function setImage(docObj,localImagId,imgObjPreview) {
    var f=$(docObj).val();
    f=f.toLowerCase();
    var strRegex=".bmp|jpg|png|jpeg$";
    var re=new RegExp(strRegex);
    if (re.test(f.toLowerCase())){
        //return true;
    }
    else {
        alert("请选择正确格式的图片");
        file=$("#photo");
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

//写cookies
function setCookie(name,value) {
    var exp=new Date();
    exp.setTime(exp.getTime() + 2 * 60 * 60 * 1000);//有效时间
    document.cookie=name + "=" +JSON.stringify(value);
}

