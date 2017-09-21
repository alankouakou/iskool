/**
 * 
 * 
 */
app.factory('tarifsService', [ '$http', '$resource',
		function($http, $resource) {
			var urlTypeChambres = "/rest/typechambres";
			var tarifsService = {};
			var typesChambres = $resource('/rest/typechambres/:tcId', {
				tcId : '@id'
			}, {
				update : {
					method: 'PUT'
				}
			});

			tarifsService.typesChambres = typesChambres;

			tarifsService.getAllTypes = function() {
				return $http.get(urlTypeChambres);
			};

			tarifsService.getTypeChambre = function(id) {
				return $http.get("/rest/typechambres/" + id);
			};
			
			tarifsService.creerClient = function(client) {
				console.log(client);
				$http.post("/rest/client", client);
			}

			return tarifsService;

		} ]);