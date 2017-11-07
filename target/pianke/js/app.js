var app=angular.module('MyApp',['ngRoute'])
app.run(function ($rootScope) {
    //$rootScope是全局作用域
});
app.config(['$routeProvider',function ($routeProvider) {
    $routeProvider
        // 前台路由配置
        .when('/',{
            templateUrl:'home.html',
            controller:'HomeController'
        })
        .when('/home',{
            templateUrl:'home.html',
            controller:'HomeController'
        })
        .when('/read',{
            templateUrl:'read.html',
            controller:'ReadController'
        })
        .when('/article/:id',{
            templateUrl:'article.html',
            controller:'ArticleController'
        })
        .when('/allUser',{
            templateUrl:'allUser.html',
            controller:'AllUserController'
        })
         .when('/user/:id',{
         templateUrl:'user.html',
         controller:'UserController'
         })
        .when('/radio',{
            templateUrl:'radio.html',
            controller:'RadioController'
        })
        .when('/radio/:id',{
            templateUrl:'radioInfo.html',
            controller:'ArticleController'
        })
        .when('/timeline',{
            templateUrl:'timeline.html',
            controller:'TimelineController'
        })
        .when('/timeline/:id',{
            templateUrl:'timelineInfo.html',
            controller:'TimelineController'
        })
        .when('/personal',{
            templateUrl:'personal.html',
            controller:'PersonalController'
        })
        .when('/message',{
            templateUrl:'message.html',
            controller:'MessageController'
        })
        .when('/book',{
            templateUrl:'book.html',
            controller:'BookController'
        })
        .when('/write',{
            templateUrl:'write.html',
            controller:''
        })
        // 后台路由配置
        .when('/userManage',{
            templateUrl:'Manage/userManage.html',
            controller:'UserManageController'
        })
        .when('/addUser',{
            templateUrl:'Manage/addUser.html',
            controller:'AddUserManageController'
        })
        .when('/articleManage',{
            templateUrl:'Manage/articleManage.html',
            controller:'ArticleManageController'
        })
        .when('/topicManage',{
            templateUrl:'Manage/topicManage.html',
            controller:'TopicManageController'
        })
        .when('/timelineManage',{
            templateUrl:'Manage/timelineManage.html',
            controller:'TimelineManageController'
        })
        .when('/labelManage',{
            templateUrl:'Manage/labelManage.html',
            controller:'LabelManageController'
        })
        .when('/bookManage',{
            templateUrl:'Manage/bookManage.html',
            controller:'BookManageController'
        })
        .otherwise({
            templateUrl:'wrongPage.html',
            controller:'BookController'
        })
}])
