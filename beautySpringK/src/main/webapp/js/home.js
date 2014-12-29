/*
 * Author: Chees
 * Description: Home관련 기본 js
 */

var SHORT_TIME = 1;
var LONG_TIME  = 5000;
var HomeApp = {
	init: function() {
		var startDelay = (window.intro == 'no') ? SHORT_TIME : LONG_TIME ;
		if ( !$.browser.mobile ) {
			var loading = $('<div class="loading"></div>').appendTo('body');

			if ( startDelay == SHORT_TIME ) {
				loading.hide();
			}
			window.onload = function () {
				if ( $('body').hasClass('started') ) return;
				$('body').addClass('started');
				loading.fadeOut(1000, function(){
					loading.remove();
					HomeApp.showIntro();
				});
			}

			// 로딩이 startDelayms보다 길어지면 강제로 시작
			setTimeout(function(){
				if ( $('body').hasClass('started') ) return;
				$('body').addClass('started');
				loading.fadeOut(1000, function(){
					loading.remove();
					HomeApp.showIntro();
				});
			},startDelay);
		} else {
			$('.wrapper').css('display','block');
			/*FeaturedSlide.play();
			MainNotice.play();*/
			ShowWindow.play();
			/*FashionNStyle.play();*/
		}

		/* 안쓰는거임 메인 밑에 버튼 동작안하는거.
		   $(window).on('scroll', function(){
			if ( $('.motion-scroll').hasClass('stopped')) return;
			if ( parseInt($(window).scrollTop()) > 10 ) {
				$('.motion-scroll').addClass('stopped');
				stopMotion($('.motion-scroll'));
				console.log('motion-scroll stopped');
			}
		});*/
	},

	showIntro : function() {

		$('html,body').css({'overflow':'auto', 'height':'auto'});
		$('#content').slideUp(0).delay(100).slideDown(600, 'easeInOutQuint', function(){
			HomeApp.checkShowWindowStart();
			$(window).on('scroll resize', HomeApp.checkShowWindowStart);
		});
		$('.wrapper').show(0).slideUp(0).slideDown(2000, 'easeOutQuad'); /*화면 내려오는 효과*/
		$('#content').css({'min-height':2000, 'background':'#fff'});	/*화면 올라오는 효과...이게 나중에 나오는거임 main 높이지정*/
		$('#header').slideUp(0).delay(200).slideDown(600, 'easeInOutQuint');

		/*$('#content .featured-slide').slideUp(0).delay(700).slideDown(1000, 'easeInOutQuint');

		$('#content .featured-slide .icon-scroll').css({'margin-bottom':-120}).delay(1400).animate({'margin-bottom':20}, 800, 'easeOutQuad');
		$('#content .featured-slide .slide-controls').css({'margin-bottom':-120}).delay(1600).animate({'margin-bottom':0}, 600, 'easeOutQuad')
		 */
		
		/*화면 올라오는 효과...이게 나중에 나오는거임
		$('#content').slideUp(0).delay(100).slideDown(600, 'easeInOutQuint', function(){
			HomeApp.checkShowWindowStart();
			$(window).on('scroll resize', HomeApp.checkShowWindowStart);
		});*/
		
		/*
		$('#content .luxury-hall-info-container').css({'left':300}).delay(2000).animate({'left':0}, 400, 'easeOutQuad', function(){
			$('html,body').css({'overflow':'auto', 'height':'auto'});
			HomeApp.checkFashionNStyleStart();
			$(window).on('scroll resize', HomeApp.checkFashionNStyleStart);
			$('#header').scrollToFixed();
			FeaturedSlide.play();
			MainNotice.play();
			FashionNStyle.play();
			$('html, body').trigger('scroll');


		}); 


		


		$('#content .fashion-n-style').slideUp(0).delay(2000).slideDown(800); */
		$('#footer').slideUp(0).delay(2000).slideDown(600, 'easeInOutQuint');
	},

	checkShowWindowStart : function() {
		if ( $('.show-window').hasClass('activated')) return false;
		var top = parseInt($('.show-window').offset().top);
		var scrollTop = $(window).scrollTop();
		var visibleArea = $(window).height() + scrollTop;
		if ( visibleArea > top + 50 ) {
			$('.show-window').addClass('activated');
			$('.show-window .btns').stop().fadeIn(500);
			$('.show-window > .bg').stop().slideDown(1500, 'easeInQuad');
			$('.show-window > h2').css({'margin-top':30, 'opacity':0}).stop().animate({'margin-top':0, 'opacity':1}, 600, 'easeOutQuad', function(){

			});
			ShowWindow.play();
		}
	},

	/*checkFashionNStyleStart : function() {
		if ( $('#content .fashion-n-style').hasClass('activated')) return false;
		var top = parseInt($('.fashion-n-style').offset().top);
		var scrollTop = $(window).scrollTop();
		var visibleArea = $(window).height() + scrollTop;
		if ( visibleArea > top + 50 ) {
			$('#content .fashion-n-style').addClass('activated');
			$('#content .fashion-n-style > .bg').stop().slideDown(1500, 'easeInQuad');
			$('#content .fashion-n-style > h2').css({'margin-top':30, 'opacity':0}).stop().animate({'margin-top':0, 'opacity':1}, 600, 'easeOutQuad', function(){
			});
		}
	}*/
};
/*
var FeaturedSlide = {
	slideInterval : null,
	SLIDE_DURATION : 7000, //슬라이더 보여주는 시간
	SLIDE_SPEED : 500, // 슬라이더 페이드 시간
	init : function() {

		FeaturedSlide.initIndices();
		FeaturedSlide.initControls();

		if ( $.browser.mobile ) FeaturedSlide.setSwipe();


		$(window).on('scroll resize', function(){
			scrollTop = $(window).scrollTop();

			$('.featured-slide .banner-img').each(function(index){
				var MIN_W = 1000;
				var MAX_W = 1920;
				var dy = 70 ;
				dy = 0;
				if ( !$.browser.mobile ) dy -= scrollTop / 2;
				var wh = parseInt($(window).width());
				wh = Math.max(MIN_W,wh);
				var dx = (wh - MAX_W) * 0.5;
				dx = Math.round(dx);
				$(this).css({'background-position':dx + 'px ' + dy + 'px'});
			});

			var bot = - 40 - scrollTop * .2;
			if ( !$.browser.mobile ) $('.featured-slide .icon-scroll').css({'bottom':bot});
		});

	},

	initIndices : function() {
		// indices를 세팅한다.
		$('.featured-slide .indices li').remove();
		$('.featured-slide .slides li').each(function(index) {
			var slide = $(this),
				indexLi = $('<li><a href="#">' + (index+1) + '</a></li>').appendTo('.featured-slide .indices');

			indexLi.on('click', function(){
				$('.featured-slide .slides li').stop().fadeOut((window.underIE9 ) ? 1 : FeaturedSlide.SLIDE_SPEED, 'easeInOutQuad').removeClass('active');
				slide.stop().fadeIn((window.underIE9 ) ? 1 : FeaturedSlide.SLIDE_SPEED, 'easeInOutQuad').addClass('active');
				$('.featured-slide .indices li.active').removeClass('active');
				$(this).addClass('active');
				if ( $('.featured-slide').hasClass('playing')) {
					FeaturedSlide.play();
				}
				return false;
			});
		});

		$('.featured-slide .indices li:first-child').trigger('click');
	},

	initControls : function() {
		$('.featured-slide .slide-controls .btn-prev').on('click', function(){
			var prev = $('.featured-slide .indices li.active').prev();
			if ( prev.length == 0 ) {
				prev = $('.featured-slide .indices li:last-child');
			}
			prev.trigger('click');
			return false;
		});

		$('.featured-slide .slide-controls .btn-next').on('click', function(){
			var next = $('.featured-slide .indices li.active').next();
			if ( next.length == 0 ) {
				next = $('.featured-slide .indices li:first-child');
			}
			next.trigger('click');
			return false;
		});

		$('.featured-slide .slide-controls .btn-play').on('click', function(){
			FeaturedSlide.play();
			$('.featured-slide .slide-controls .btn-pause').focus();
			return false;
		});

		$('.featured-slide .slide-controls .btn-pause').on('click', function(){
			FeaturedSlide.pause();
			$('.featured-slide .slide-controls .btn-play').focus();
			return false;
		});
	},

	play : function() {
		$('.featured-slide').addClass('playing');
		clearInterval(FeaturedSlide.slideInterval);
		FeaturedSlide.slideInterval = null;
		FeaturedSlide.slideInterval = setInterval(function(){
			$('.featured-slide .slide-controls .btn-next').trigger('click');
		}, FeaturedSlide.SLIDE_DURATION);
	},

	pause : function() {
		$('.featured-slide').removeClass('playing');
		if (FeaturedSlide.slideInterval) {
			clearInterval(FeaturedSlide.slideInterval);
			FeaturedSlide.slideInterval = null;
		}
	},

	setSwipe : function() {

		$(".featured-slide").swipe( {
			click:function(event, target) {
				//alert(event.target);
				try {
					var href = $(event.target).sibling('a').attr('href');
					if ( href && href != '' ) self.location.href = href;
				} catch (e) {
					console.log(e);
				}
			},

			swipe:function(event, direction, distance, duration, fingerCount) {
				if ( direction == 'left') {
					$('.featured-slide .slide-controls .btn-next').trigger('click');
				}

				if ( direction == 'right') {
					$('.featured-slide .slide-controls .btn-prev').trigger('click');
				}


			},
			triggerOnTouchEnd: true,
			excludedElements: 'a .banner',
			allowPageScroll: 'vertical',
			//Default is 75px, set to 0 for demo so any distance triggers swipe
			threshold: 20
		});
	}
};
*/

/*
var LuxuryHallInfo = {
	init : function() {
		$('.luxury-hall-info').slideUp(0);
		$('.btn-luxury-hall-info').on('click', function(){
			$('.luxury-hall-info').stop().slideDown(1200, 'easeInOutQuint');
			$('body,html').animate({'scrollTop':0}, 1000, 'easeInOutQuint');

			$('.lhi-content > *').each(function(index){
				$(this).stop().css({'margin-top':500}).delay(index * 100).animate({'margin-top':0}, 2000, 'easeInOutQuint');
			});
			return false;
		});

		$('.btn-luxury-hall-info').on('mouseenter', function(){
			$('.over', this).stop().animate({'top':-56}, 600, 'easeOutQuad', function(){
				$(this).css({'top':0})
			});
		});

		$('.btn-luxury-hall-info').on('mouseleave', function(){});

		$('.luxury-hall-info .btn-close').on('click', function(){
			$('.luxury-hall-info').stop().slideUp(800, 'easeInOutQuint');
			return false;
		});

		$(window).on('scroll resize', function(){
			scrollTop = $(window).scrollTop();
			var MIN_W = 1000;
			var BG_W = 1400;
			var dy = 70 ;
			if ( !$.browser.mobile ) dy -= scrollTop / 2.5;
			var wh = parseInt($(window).width());
			wh = Math.max(MIN_W,wh);
			var dx = (wh-BG_W);
			$('.luxury-hall-info').css({'background-position':dx + 'px ' + dy + 'px'});

		});

	}
};

var MainNotice = {
	noticeInterval : null,
	NOTICE_DURATION : 5000, // 공지사항 보여주는 시간
	init : function() {
		$('.main-notice .notice-list li').each(function(index) {
			if ( index > 0 ) $(this).css({'top':-55});
			else $(this).addClass('active');
		});

		//20140414
		$('.main-notice  .nbtn-pause').on('click', function(){
			$('.main-notice .nbtn-pause').css('display','none');
			$('.main-notice .nbtn-play').css('display','block');
			MainNotice.pause();
			$('.main-notice .nbtn-play').focus();
		});

		//20140414
		$('.main-notice  .nbtn-play').on('click', function(){
			$('.main-notice .nbtn-pause').css('display','block');
			$('.main-notice .nbtn-play').css('display','none');
			MainNotice.play();
			$('.main-notice .nbtn-pause').focus();
		});
	},
	play : function() {
		MainNotice.noticeInterval = setInterval(function(){
			var curr = $('.main-notice .notice-list li.active');
			var next = ( curr.next().length == 0 ) ? $('.main-notice .notice-list li:first-child') : curr.next();
			curr.removeClass('active').stop().animate({'top':55}, 1000, 'easeInOutQuint', function(){
				curr.css({'top':-55})
			});
			next.addClass('active').stop().animate({'top':0}, 1000, 'easeInOutQuint');
		}, MainNotice.NOTICE_DURATION);
	},
	pause : function() {
		clearInterval(MainNotice.noticeInterval);
		noticeInterval = null;
	}
};

/
var FashionNStyle = {

	init : function() {

		$('.fashion-n-style .style-post').on('mouseenter', function(){
			$(this).addClass('active');
			$('.over', this).stop().fadeIn((window.underIE9 ) ? 1 : 500);
			resumeMotion($('.anim-obj', this));
		});

		$('.fashion-n-style .style-post').on('mouseleave', function(){
			$(this).removeClass('active');
			$('.over', this).stop().fadeOut((window.underIE9 ) ? 1 : 300);
			stopMotion($('.anim-obj', this));
		});

		stopMotion($('.fashion-n-style .style-post .anim-obj'));
	},

	play : function() {
		$(window).on('scroll resize', function(){
			if ( $.browser.mobile ) return false;
			var scrollTop = parseInt($(window).scrollTop()),
				visibleArea = $(window).innerHeight() + scrollTop,
				offsetTop = parseInt($('.fashion-n-style').offset().top);

			$('.fashion-n-style .style-post').each(function(index){
				if ( $(this).hasClass('activated') == false ) {
					var top = parseInt($(this).css('top')) + offsetTop;
					if ( visibleArea > top + 20 * index ) {
						$(this).stop().show().css({'margin-top':800}).addClass('activated').animate({'margin-top':0}, 1300, 'easeInOutQuint');
					}
				}
			});

			var dy = - scrollTop * .5;
			$('.fashion-n-style').css({'background-position':'0 ' + dy + 'px'})
		});
	}
};
*/
$(function(){

	if ( $('body').hasClass('home') == false ) return false;

	HomeApp.init();
	/*FeaturedSlide.init();
	LuxuryHallInfo.init();
	MainNotice.init();
	FashionNStyle.init();*/
	$(window).trigger('resize');

});