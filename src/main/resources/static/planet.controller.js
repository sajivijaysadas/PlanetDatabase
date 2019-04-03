(
    function () {

        var app = angular.module("PlanetDatabaseApp");
        app.controller("PlanetAppCtrl", planetAppCtrl);
        function planetAppCtrl($scope, PlanetDataSvc) {
            var self = this;
            PlanetDataSvc.getPlanets()
                .then(function (data) {
                    if (!data || data.length == 0) {
                        self.errorMessage = "No Planets Avaialble.";
                    } else {
                        self.planets = data;
                    }
                },
                    function () {
                        self.errorMessage = "No Planets Avaialble.";
                    }
                );
            self.expandAll = function (expanded) {
                $scope.$broadcast('onExpandAll', {
                    expanded: expanded
                });
            };
        }
    })()



