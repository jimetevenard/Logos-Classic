$(function (){
	
	
	setInterval(function(){
		console.log('fx timeout')
		$(".btn-rafraichir").trigger("click");
	
	},1000);
	
	
});
