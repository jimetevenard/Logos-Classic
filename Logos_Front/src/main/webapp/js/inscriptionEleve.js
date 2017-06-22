$(function(){
	$("button[alt~='valider']").on("click", function(){
	       var mdp = $("input[alt~='mdp']").val();
	        var mdp2 = $("input[alt~='mdp2']").val();
	        var regex = /[a-z]{1,}[A-Z]{1,}[0-9]{1,}/.test(mdp);
	        if(regex && mdp.length>=8){
	            console.log("regex");
	            if(mdp=== mdp2){
	                $("form[alt~='form']").submit();
	            }
	            else{
	                $("span[alt~='message']").text("erreur dans le mot de passe");
	            }
	        }else{
	           $("span[alt~='message']").text("mot de passe invalide");
	        }
	   });
});