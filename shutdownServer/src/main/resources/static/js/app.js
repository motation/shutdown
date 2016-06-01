var serverHost = "http://"+window.location.host;
var suffix = "/timer";


var app = angular.module('app', ['ngRoute', 'ngResource']);
app.config(function ($routeProvider) {
    $routeProvider
        .when('/send', {
            templateUrl: '/view/send.html',
            controller: 'shutdownController'
        })
        .when('/show', {
            templateUrl: '/view/show.html',
            controller: 'showShutdownController'
        })
        .when('/home', {
            templateUrl: '/view/home.html',
            controller: 'homeController'
        })
        .otherwise(
            {redirectTo: '/'}
        );
});