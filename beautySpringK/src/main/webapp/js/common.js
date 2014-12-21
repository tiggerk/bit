/*
 * Author: Chees
 * Description: header,nav,footer 관련 사이트 공통 js
 */


// extra
/**
 * jQuery.browser.mobile (http://detectmobilebrowser.com/)
 *
 * jQuery.browser.mobile will be true if the browser is a mobile device
 *
 **/
(function(a){(jQuery.browser=jQuery.browser||{}).mobile=/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|Android|android|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od|ad)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(a.substr(0,4))})(navigator.userAgent||navigator.vendor||window.opera);

if ( ! window.console ) console = { log: function(){} };

window.underIE9 = (navigator.userAgent.match(/MSIE\s(?!9.0)/)) ? true : false ;
// window.underIE9 = true;

$(function(){

	// 모바일 브라우져 혹은 메인을 제외한 페이지에서는 fixed된 헤더의 가로 스크롤을 활성화시켜준다.
	// fixed된 header가 가로 스크롤이 필요한 이유는 https://github.com/bigspotteddog/ScrollToFixed 참조
	if ($.browser.mobile || $('body').hasClass('home') == false ) $('#header').scrollToFixed();

	// 브라우져 가로가 1245이하일 경우 header 오른쪽 메뉴를 숨기기 위하여 body에 class를 세팅해줌
	$(window).on('resize', function(){
		var wh = parseInt($(window).width());
		if (wh < 1245) {
			$('body').addClass('under-1200').removeClass('over-1200');
		} else {
			$('body').removeClass('under-1200').addClass('over-1200');
		}
	});

	// 스킵메뉴안의 버튼들 세팅
	$('.skip-menu > a').on('click', function(e){
		$('.skip-menu').removeClass('active').blur();
		var target = $(this).attr('href');
		$(target).attr('tabindex', '-1');
	});

	// "tab"키로 포커스 이동시
	$('.skip-menu').on('focusin', function(){
		$(this).addClass('active');
	});

	$('.skip-menu').on('focusout', function(){
		$(this).removeClass('active');
	});


	$('#header .logo, #header .util-menu').on('focusin', function(){
		$('.gnb > li.opened').removeClass('active opened');
	});

	// #nav > .gnb 세팅
	$('.gnb > li').each(function(index,obj){
		var container = $(this);
		var subMenu = $('.sub-menu', container);
		$('a .over', container).height(0);
		var openEvenType = ( $.browser.mobile ) ? 'mouseenter' : 'mouseenter' ;
		container.on(openEvenType, function(e){
			showGnbLi(container);
			return false;
		});

		var closeEventType = ( $.browser.mobile ) ? 'mouseleave' : 'mouseleave' ;
		container.on(closeEventType, function(e){
			closeGnbLi(container);
			return false;
		});

		// tab키로 포커스 이동시
		container.on('focusin', function(e) {
			if ( container.hasClass('opened') == false ) {
				$('.gnb > li.opened').removeClass('active opened');
				container.addClass('active opened');
			}
		});

		container.on('focusout', function(e) {
			//container.removeClass('active');
		});
	});



	// 토글 메뉴를 가진 버튼들 세팅. 일반적으로 .toggle-menu안에 > a와 > .toggle-list의 구조를 가지고 있음.
	$('.toggle-menu').each(function(){

		var menu = $(this);
		menu.addClass('js-control').find('.toggle-list').slideUp(0);

		menu.on('focusout', function(e){
			menu.removeClass('active');
			return false;
		});

		menu.on('focusin', function(e){
			menu.addClass('active');
			return false;
		});


		$('> a', menu).on('click', function(){
			if ( $(menu).hasClass('opened')) {
				$(menu).removeClass('opened');
				$('.toggle-list', menu).stop().slideUp(100);
			} else {
				$(menu).addClass('opened');
				var delay = ( $(menu).attr('delay-in') ) ? parseInt($(menu).attr('delay-in')) : 0 ;
				$('.toggle-list', menu).stop().delay(delay).slideDown(200);
			}

			return false;
		});

		menu.on('mouseleave', function(){
			$('.toggle-list', menu).stop().slideUp(100);
			menu.removeClass('active opened');
		});

		$(' > a', menu).on('click', function(){
			return false;
		});
	});

	// 1200이하일 경우 헤더 오른쪽 util menu는 숨겨진 레이어 메뉴(panel-util-menu)로 바뀜 .panel-util-menu를 세팅함.
	$('.panel-util-menu').slideUp(0);
	$('.btn-show-util-menu').on('click', function(){
		$(this).toggleClass('active');
		if ( $(this).hasClass('active')) {
			$('.panel-util-menu').stop().slideDown(1000, 'easeInOutQuint');
		} else {
			$('.panel-util-menu').stop().slideUp(500, 'easeInOutQuint');
		}
		return false;
	});
})
