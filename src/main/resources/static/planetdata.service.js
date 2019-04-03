(
    function () {
    var app = angular.module("PlanetDatabaseApp");

    app.service("PlanetDataSvc", function ($http) {
        var self = this;
        self.getPlanets = function () {
            console.log("before get ");
            var promise = $http.get('http://localhost:8085/planets')
                .then(function (response) {
                    return response.data;
                });
            return promise;
        }
    });
})();
