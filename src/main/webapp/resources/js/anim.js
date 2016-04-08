
$(function(){
	
	$(".centered").animate({top: "50%"},2000, function(){
		$(".logo, .border").animate({
			opacity : 0
		},2000,function(){
			$(this).css({clip:'rect(0px, 432px, 124px, 0px)', top:'124px'}).animate({
				opacity : 1
			}, 2000)
		})
		
	})
	
	
	
	
	
	/*$('.logo-cnt').on('mouseover',function(){
		
		console.log("test");
	});
	*/
	
	
});


