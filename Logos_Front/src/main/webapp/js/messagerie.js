$(function (){
	//$(".messages").scrollTop(500);
	
	setInterval(function(){
		console.log('fx timeout')
		$(".btn-rafraichir").trigger("click");
	
	},1000);
	
	
});
