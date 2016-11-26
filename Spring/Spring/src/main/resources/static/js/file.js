/**
 * 
 */
var app=angular.module("myApp", []);
app.controller('springRest',FirstCtrl2);
function FirstCtrl2($scope,$http){
	//view
	$scope.update=false;
	//view
	
	$scope.nbpage=0;
	$scope.motCle=null;
	
	
	$scope.charger=function(){
	$http.get("/mc2?des="+$scope.motCle+"&page=0").success(function(data){
		$scope.produits=data.content;
		$scope.pages=new Array(data.totalPages);
	});
	};
	$scope.goto=function(index){
		$http.get("/mc2?des="+$scope.motCle+"&page="+index).success(function(data){
			$scope.produits=data.content;
			$scope.pages=new Array(data.totalPages);
			$scope.nbpage=index;
		});	
	};
	
	$scope.ajouter=function(){
		///save?designation=PABZ&prix=695
		$http.get("/save?designation="+$scope.designation+"&prix="+$scope.prix);
		$scope.charger();
		$scope.designation="";
		$scope.prix="";
		
	}
	$scope.modifier=function(){
		///save?designation=PABZ&prix=695
		///update?ref=3&designation=AABBCC&prix=999
		
		$http.get("/update?ref="+$scope.ref+"&designation="+$scope.designation1+"&prix="+$scope.prix1);
		$scope.charger();
		$scope.update=false;
		
	}
	$scope.editer=function(ref,des,prix){
		
		$scope.update=true;
		$scope.ref=ref;
		$scope.designation1=des;
		$scope.prix1=prix;
		$scope.charger();
		
	}
	// /delete?id=3
$scope.supprimer=function(ref){
		
	$http.get("/delete?id="+ref);
		$scope.charger();
		
	}
}