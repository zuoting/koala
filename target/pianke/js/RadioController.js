app.controller('RadioController',function ($scope,$http,$rootScope) {
    $scope.now = -1;

    // 封装电台块专题查询结果集
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allRadioTopics'
    }).success(function (data) {
        $scope.allRadioTopics = data; //数据绑定
    });

    // 电台块所有TING文章
    $http({
        method: 'GET',
        url: 'http://localhost:8080/radioAllArticles'
    }).success(function (data) {
        $scope.radioAllArticles = data; //数据绑定
    });

    $scope.selectTopicArticle = function (index,topicId) {
        $scope.topic_name = $scope.allRadioTopics[index].topic_name + ' | All TING';
        $scope.thisTopic = topicId;
        $scope.now = index;
    }

});

