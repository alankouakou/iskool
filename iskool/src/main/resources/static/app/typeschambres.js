/**
 * 
 */
app.factory('TypesChambres', [ '$resource', function($resource) {
	return $resource('/rest/typechambres/:typeId',{typeId:'@id'});
}]);