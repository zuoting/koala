app.controller('UserManageController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {
    $rootScope.msg=JSON.parse(getCookie('msg')); //获取新的cookie，设置为 $rootScope.msg

    //查询所有用户
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allUsers'
    }).success(function (data) {
        //console.log(data);
        $scope.allUsers = data; //数据绑定
        paging();
    });
    //后台页面上查询所有作者  分页
    function paging(){
        $scope.pageSize = 8; //每个页面最多加载10条数据
        $scope.maxSize = Math.ceil($scope.allUsers.length / $scope.pageSize);  //分页总数
        $scope.newPages = $scope.maxSize > 5 ? 5 : $scope.maxSize; //判断页码是否超过5
        $scope.pageList = [];//存放所有页
        $scope.selPage = 1;//当前页（默认）

        //设置表格数据源(分页)
        $scope.setData = function () {
            $scope.allUser = $scope.allUsers.slice(($scope.pageSize * ($scope.selPage - 1)), ($scope.selPage * $scope.pageSize));//通过当前页数筛选出表格当前显示数据
        }

        $scope.allUser = $scope.allUsers.slice(0, $scope.pageSize);

        //分页要repeat的数组
        for (var i = 0; i < $scope.newPages; i++) {
            $scope.pageList.push(i + 1);
        }

        //打印当前选中页索引
        $scope.selectPage = function (page) {
            //不能小于1大于最大
            if (page < 1 || page > $scope.maxSize) return;
            //最多显示分页数5
            if (page > 2) {
                //因为只显示5个页数，大于2页开始分页转换
                var newpageList = [];
                for (var i = (page - 3) ; i < ((page + 2) > $scope.maxSize ? $scope.maxSize : (page + 2)) ; i++) {
                    newpageList.push(i + 1);
                }
                $scope.pageList = newpageList;
            }
            $scope.selPage = page;
            $scope.setData();
            $scope.isActivePage(page);
            console.log("选择的页：" + page);
        };

        //设置当前选中页样式
        $scope.isActivePage = function (page) {
            return $scope.selPage == page;
        };

        //上一页
        $scope.Previous = function () {
            $scope.selectPage($scope.selPage - 1);
        }

        //下一页
        $scope.Next = function () {
            $scope.selectPage($scope.selPage + 1);
        };
    }


    //点击修改按钮  弹出修改面板
    $scope.showUser=function(index){
        document.getElementById("updateUser").style.display='block';
        // console.log($scope.allUser[index]);
        /*通过$index 来接收每一行的数组遍历下标 然后再scope 作用域里我们就可以拿到 allUser[index] 的数据了*/
        $rootScope.userInfo=$scope.allUser[index];
    };
    //点击取消按钮，修改框消失
    $scope.cancelButton=function () {
        document.getElementById("updateUser").style.display='none'
    };


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
                account:account,
                password:password,
                nickname:nickname,
                description:description
            },
            headers:{'Content-Type':undefined},//请求的设置
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
                title: "修改用户信息成功",
                type: "success",
                timer: 1500,
                showConfirmButton: false
            });
            setCookie("user",data);//重新设置cookie
            setTimeout("window.location.reload()",1050);
        });
    }

    //删除一个用户
    $scope.deleteUser=function (index) {
        $scope.userInfo=$scope.allUser[index];
        // alert($scope.userInfo.user_id);
        $http({
            url: 'http://localhost:8080/admin/deleteUsers/'+$scope.userInfo.user_id,
            method: 'DELETE'
        }).success(function () {
            swal({
                title: "删除用户成功",
                type: "success",
                timer: 1500,
                showConfirmButton: false
            });
            setTimeout("window.location.reload()",1050);
        });
    }


}]);

//头像选择预览函数
function getPictures() {
    $("#photo").click(); //点击头像，模拟input type=file
}

function setImages(docObj,localImagId,imgObjPreview) {
   alert('change');
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