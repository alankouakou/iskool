/**
 * 
 */

var app = angular.module('MyApp', [ 'ngRoute','ngResource' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/secure', {
		templateUrl : 'app/views/page-403.html',
		controller : 'tarifsController'
	}).when('/nouveau-client', {
		templateUrl : 'app/views/nouveau-client.html',
		controller : 'tarifsController'			
	}).when('/tarifs', {
		templateUrl : 'app/views/pricing-tables.html',
		controller : 'tarifsController'
	}).when('/type-chambre', {
		templateUrl : 'app/views/type-chambre.html',
		controller : 'tarifsController'
	}).otherwise({
		redirectTo : '/tarifs'
	});
}).controller('tarifsController', function tarifsController($scope, tarifsService) {
	$scope.client = {
			nom:"",
			prenom:"",
			genre:"",
			dateNaissance:"",
			numeroPieceID:"",
			created:"01/01/2017",
			updated:"",
			typeID:null,
			categorie:null
	};
	$scope.typeChambres = [];
	$scope.message = "Chargement des données ...";
	getAllTypes();
	
	/* Nlle Méthode : utiliser ngResource */

	function getAllTypes(){
		$scope.typeChambres = tarifsService.typesChambres.query();
	}
	
	$scope.getTypeChambre = function(id=1){
		$scope.typeChambre = tarifsService.typesChambres.get({tcId:id});
	}
	
	$scope.creerClient = function(){
		tarifsService.creerClient($scope.client);
		$scope.msg_feedback="Client enregistré avec succès!";
		$scope.client={};
		//console.log($scope.client);
	}
	
	
});

/* 1ere methode: utilise $http
 * 
function getAllTypes(){
	tarifsService.getAllTypes().success(function(data){
		$scope.typeChambres = data;
		$scope.message = "Chargement des données réussi!";
	})
	.error(function(error){
		$scope.message="Echec de chargement des données: "+ error.message;
	})
}

$scope.getTypeChambre = function (id=1){
	tarifsService.getTypeChambre(id).success(function(data){
		$scope.typeChambre = data;
		$scope.message = "Type chambre chargé!";
	})
	.error(function(error){
		$scope.message = "Type chambre introuvable: "+error.message;
	});
}
*/
