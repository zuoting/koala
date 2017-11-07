app.controller('BookController',['$scope','$routeParams','$http','$rootScope',function ($scope,$routeParams,$http,$rootScope) {
    $http({
        method: 'GET',
        url: 'http://localhost:8080/allBooks'
    }).success(function (data) {
        $scope.allBooks = data; //数据绑定
    });

}]);

