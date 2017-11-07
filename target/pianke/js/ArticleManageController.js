app.controller('ArticleManageController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {

   //后台页面上查询所有文章
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allArticles'
    }).success(function (data) {
        $scope.allArticles = data; //数据绑定
        paging();
    });
    //后台页面上查询所有文章  分页
    function paging(){
        $scope.pageSize = 8; //每个页面最多加载10条数据
        $scope.maxSize = Math.ceil($scope.allArticles.length / $scope.pageSize);  //分页总数
        $scope.newPages = $scope.maxSize > 5 ? 5 : $scope.maxSize; //判断页码是否超过5
        $scope.pageList = [];//存放所有页
        $scope.selPage = 1;//当前页（默认）

        //设置表格数据源(分页)
        $scope.setData = function () {
            $scope.allArticle = $scope.allArticles.slice(($scope.pageSize * ($scope.selPage - 1)), ($scope.selPage * $scope.pageSize));//通过当前页数筛选出表格当前显示数据
        }

        $scope.allArticle = $scope.allArticles.slice(0, $scope.pageSize);

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

    //删除一个文章
    $scope.deleteArticle=function (index) {
        $scope.articleInfo=$scope.allArticle[index];
        // alert($scope.articleInfo.article_id);
        $http({
            url: 'http://localhost:8080/admin/deleteArticles/'+$scope.articleInfo.article_id,
            method: 'DELETE'
        }).success(function () {
            swal({
                title: "删除成功",
                type: "success",
                timer: 1500,
                showConfirmButton: false
            });
            setTimeout("window.location.reload()",1050);
        });
    }

}]);
