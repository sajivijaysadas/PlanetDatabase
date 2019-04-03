(
    function () {
        var app = angular.module("PlanetDatabaseApp");
        app.directive('expand', function () {
            function link(scope, element, attrs) {
                scope.$on('onExpandAll', function (event, args) {
                    scope.expanded = args.expanded;
                });
            }
            return {
                link: link
            };
        });
    })()