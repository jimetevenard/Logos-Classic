$(function(){
	$("#valider").on("click", function(){
	       var mdp = $("#mdp").val();
	        var mdp2 = $("#mdp2").val();
	        var regex = /[a-z]{1,}[A-Z]{1,}[0-9]{1,}/.test(mdp);
	        if(regex && mdp.length>=8){
	            console.log("regex");
	            if(mdp=== mdp2){
	                $("#formInscription").submit();
	            }
	            else{
	                $("#message").text("erreur dans le mot de passe");
	            }
	        }else{
	           $("#message").text("mot de passe invalide");
	        }
	   });
});