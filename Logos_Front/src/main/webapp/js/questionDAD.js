/**
 * 
 */

$(function(){
	$(".zone-drag-drop").each(function(){
		var phrase = $(this).find(".phrase").text();
		$(this).find(".inputs-drop .wrap-input-drop").each(function(){
			console.log( $(this).html() );
			$(this).droppable({
				drop:function(event,ui){
					$(this).append(ui.draggable[0]);
				}
			})
			phrase = phrase.replace("((trou))",$(this).html());
			$(this).remove();
			
		});
		$(this).find(".phrase").html(phrase);
		$(this).find(".inputs-drag .wrap-input-drag").draggable({
			revert:"invalid"
		});
	});
	
	
	
});

