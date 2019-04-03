(
    function () {
        var app = angular.module("PlanetDatabaseApp");
        app.factory('AuthInterceptor', [function () {
            var basicAuthInterceptor = {
                request: function (config) {
                    config.headers = config.headers || {};
                    var encodedString = btoa("planetuser:planetuser123");
                    config.headers.Authorization = 'Basic ' + encodedString;
                    return config;
                }
            };
            return basicAuthInterceptor;
        }]);

        app.config(function ($httpProvider) {
            $httpProvider.interceptors.push('AuthInterceptor');
        });
    })()

