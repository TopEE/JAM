/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('breakfast', ['ngRoute'])

        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        controller: 'MembersCtrl',
                        templateUrl: 'members.html'
                    })
                    .when('/new', {
                        controller: 'CreateNewMemberCtrl',
                        templateUrl: 'newmember.html'
                    })
                    .otherwise({
                        redirectTo: '/'
                    });
        })

        .service('Credentials', function () {
        })

        .controller('MembersCtrl', function ($scope, $http, Credentials) {
            $scope.credentials = Credentials;
            $http.get('http://localhost:8080/JAM/v1/members').
                    success(function (data) {
                        $scope.members = data;
                    });
        })
        
        .controller('CreateNewMemberCtrl', function ($scope, Member) {
            $scope.member = Member;
        })

        .controller('AllMembers', function ($scope, $http) {
            $http.get('http://localhost:8080/JAM/v1/members').
                    success(function (data) {
                        $scope.members = data;
                    });
        })
        ;

