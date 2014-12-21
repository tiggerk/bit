$(function() {

	$('#mi-slider').catslider();

	$("#flexiselDemo3").flexisel({
		visibleItems : 5,
		animationSpeed : 1000,
		autoPlay : true,
		autoPlaySpeed : 3000,
		pauseOnHover : true,
		enableResponsiveBreakpoints : true,
		responsiveBreakpoints : {
			portrait : {
				changePoint : 480,
				visibleItems : 1
			},
			landscape : {
				changePoint : 1200,
				visibleItems : 2
			},
			tablet : {
				changePoint : 768,
				visibleItems : 3
			}
		}
	});

});