'use strict';

angular.module('GPYApp.directives', [])
        .directive('tabs', function () {
            return {
                restrict: 'E',
                transclude: true,
                scope: {},
                controller: ["$scope", function ($scope) {
                        var panes = $scope.panes = [];

                        $scope.select = function (pane) {
                            
                            angular.forEach(panes, function (pane) {
                                pane.selected = false;
                            });
                            pane.selected = true;
                        }

                        this.addPane = function (pane) {
                            if (panes.length == 0)
                                $scope.select(pane);
                            panes.push(pane);
                        }
                    }],
                template:
                        '<div class="tabbable">' +
                        '<ul class="nav nav-tabs">' +
                        '<li ng-repeat="pane in panes" ng-class="{active:pane.selected}">' +
                        '<a href="" ng-click="select(pane)">{{pane.title}}</a>' +
                        '</li>' +
                        '</ul>' +
                        '<div class="tab-content" ng-transclude></div>' +
                        '</div>',
                replace: true
            };
        })
        .directive('pane', function () {
            return {
                require: '^tabs',
                restrict: 'E',
                transclude: true,
                scope: {title: '@'},
                link: function (scope, element, attrs, tabsCtrl) {
                    tabsCtrl.addPane(scope);
                },
                template:
                        '<div class="tab-pane" ng-class="{active: selected}" ng-transclude>' +
                        '</div>',
                replace: true
            };
        }).directive('menuLink', function() {
            return {
              scope: {
                enabled: '=menuLink'
              },
              link: function(scope, element, attrs) {
                element.bind('click', function(event) {
                  if(!scope.enabled) {
                    event.preventDefault();
                  }
                });                
              }
            };
        }).directive("format", ["$filter", function ($filter) {
            return {
                require: '?ngModel',
                link: function (scope, elem, attrs, ctrl) {
                    if (!ctrl)
                        return;


                    ctrl.$formatters.unshift(function (a) {
                        return $filter(attrs.format)(ctrl.$modelValue)
                    });


                    ctrl.$parsers.unshift(function (viewValue) {
                        var plainNumber = viewValue.replace(/[^\d|\-+|\.+]/g, '');
                        elem.val($filter(attrs.format)(plainNumber));
                        return plainNumber;
                    });
                }
            };
        }]);