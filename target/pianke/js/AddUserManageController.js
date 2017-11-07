app.controller('AddUserManageController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {

    //添加个人信息
    $scope.insertUser=function (user) {
       // alert(21);
        console.log(user);
        var file=document.querySelector('input[type=file]').files[0];
        var account=document.getElementById('addAccount').value;
        var password=document.getElementById('addPassword').value;
        var nickname=document.getElementById('addNickname').value;
        var description=document.getElementById('addDescription').value;
        console.log(user.account);
        console.log(user.password);
        console.log(user.nickname);
        console.log(user.description);
        console.log(file);
        $http({
            url: 'http://localhost:8080/admin/insertUsers',
            method: 'POST',
            data:{
                file:file,
                account:account,
                password:password,
                nickname:nickname,
                description:description
            },
            headers:{'Content-Type':undefined},//请求头的设置
            transformRequest:function (data) {
                var formData=new FormData();
                formData.append('file',data.file);
                formData.append('account',data.account);
                formData.append('password',data.password);
                formData.append('nickname',data.nickname);
                formData.append('description',data.description);
                return formData;
            }
        }).success(function (data) {
            swal({
                title: "添加用户成功",
                type: "success",
                timer: 1500,
                showConfirmButton: false
            });
            setCookie("user",data);//重新设置cookie
            window.setTimeout("location.href='http://localhost:8080/backManage.html#/userManage'",1200);
            // setTimeout("window.location.reload()",1050);
        });
    }
}]);

//头像选择预览函数
function getPicture() {
    $("#photoHead").click(); //点击头像，模拟input type=file
}

function setImage(docObj,localImagId,imgObjPreview) {
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
        file=$("#photoHead");
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
