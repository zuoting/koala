app.controller('MessageController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {
    $http({
        method: 'GET',
        url: 'http://localhost:8080/messages/'+$rootScope.user.user_id
    }).success(function (data) {
        $scope.messages = data; //数据绑定
    });

}]);
