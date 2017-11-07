app.controller('ReadController',function ($scope,$http,$rootScope) {

    $scope.now = -1;
    /*阅读块热门文章*/
    $http({
        method: 'GET',
        url: 'http://localhost:8080/readArticlePics'
    }).success(function (data) {
        $scope.readArticlePics = data; //数据绑定
    });

    /*阅读块专题*/
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allReadTopics'
    }).success(function (data) {
        $scope.allReadTopics = data; //数据绑定
    });

    /*阅读块全部文章*/
    $http({
        method: 'GET',
        url: 'http://localhost:8080/readAllArticles'
    }).success(function (data) {
        $scope.readAllArticles = data; //数据绑定
        //console.log(data)
    });

    $scope.selectTopicArticle = function (index,topicId) {
        $scope.topic_name = $scope.allReadTopics[index].topic_name + ' | All Articles';
        $scope.thisTopic = topicId;
        $scope.now = index;
    }


});

