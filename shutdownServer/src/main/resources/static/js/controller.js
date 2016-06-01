app.controller('shutdownController', function ($scope, $http, $location) {


    $scope.sendPost = function (time) {

        var config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }

        $http.post(serverHost + suffix, "shutdownInSeconds=" + time, config)
            .then(function (response) {
                    // success callback
                    $location.path("/show");
                },
                function (response) {
                    // failure callback
                });
    }

});


app.controller('showShutdownController', function ($scope, $http, $route) {
    $scope.sendCancel = function () {
        $http.delete(serverHost + suffix)
            .then(function (response) {
                    // success callback
                    console.log("success sendCancel");
                    $route.reload();
                },
                function (response) {
                    // failure callback
                    console.log("failure sendCancel");
                });
    }
    $scope.getTimer = function () {
        $http.get(serverHost + suffix)
            .success(function (data, status, headers, config) {
                // success callback
                console.log("success getTimer");
                $scope.timer = getTextOrDate(data);
            }).error(function (data, status, headers, config) {
            // failure callback
            console.log("failure getTimer");
        });
    }

    var getTextOrDate = function (data) {
        var timer = data.timer;
        if (timer) {
            console.log(timer.startTime);
            var date = new Date(timer.startTime + timer.shutdownInSecs * 1000);
            var hours = date.getHours();
            // Minutes part from the timestamp
            var minutes = "0" + date.getMinutes();
            // Seconds part from the timestamp
            var seconds = "0" + date.getSeconds();

            var month = date.getMonth() + 1;

            var dayDate = date.getDate();

            var year = date.getFullYear();

            // Will display time in 10:30:23 format
            var formattedTime = dayDate + "." + month + "." + year + " - " +
            hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
            return formattedTime;
        } else {
            return "Kein Timer aktiv!";
        }
    }

});

app.controller('homeController', function ($scope) {

});


app.controller('navController', function ($scope, $location) {
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };
});