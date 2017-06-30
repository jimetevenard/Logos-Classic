("use strict");

$(function(){
	$(".zone-drag-drop").each(function(){
		var phrase = $(this).find(".phrase").text();
		$(this).find(".inputs-drop .drop").each(function(){
			console.log( $(this).html() );
			
			phrase = phrase.replace("((trou))",$(this).html());
			$(this).remove();
			
			
		});
		$(this).find(".drop").droppable({
			drop:function(event,ui){
				$(this).append(ui.draggable[0]);
			}
		});
		$(this).find(".phrase").html(phrase);
		$(this).find(".inputs-drag .wrap-input-drag").draggable({
			revert:"invalid"
		});
	});
	
	
	
});