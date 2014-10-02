//가위바위보 함수

function gawibawibo(choice) {
	
	document.getElementById('img').style.display='';

	with (document.game) {
		comp = Math.round((Math.random() * 2) + 1);

		var choicename;

		if (comp == 1)
			choicename = "가위";
		if (comp == 2)
			choicename = "바위";
		if (comp == 3)
			choicename = "보";
		msg.value = '컴퓨터는' + choicename + '. ';

		var imageView;
		var imgArray = new Array("images/scissors.png", "images/rock.png", "images/paper.png");

		if (comp == 1)
			imageView = imgArray[0];
		if (comp == 2)
			imageView = imgArray[1];
		if (comp == 3)
			imageView = imgArray[2];

		document.img.src = imageView;
		
		
		
		var imageView2;
		var imgArray2 = new Array("images/1.png", "images/2.png", "images/3.png");

		if (comp == 1)
			imageView2 = imgArray[0];
		if (comp == 2)
			imageView2 = imgArray[1];
		if (comp == 3)
			imageView2 = imgArray[2];

		document.img2.src = imageView2;
		
		//
		var url = imgArray2[choice-1];
		document.img2.src = url;
		//
		
		
		switch (choice) {
		case 1:
			if (comp == 1) {
				draw.value++;
				msg.value += '무승부입니다.';
				var url;
				url = 'url("draw.jpg")';
				var DivImg = document.getElementById('img');
				DivImg.style.background = url;
				break;
			}
			if (comp == 2) {
				loss.value++;
				msg.value += '졌습니다.';
				var url;
				url = 'url("lose.jpg")';
				var DivImg = document.getElementById('img');
				DivImg.style.background = url;
				break;
			}
			if (comp == 3) {
				win.value++;
				msg.value += '이겼습니다.';
				var url;
				url = 'url("win.jpg")';
				var DivImg = document.getElementById('img');
				DivImg.style.background = url;
				break;
			}

		case 2:
			if (comp == 1) {
				win.value++;
				msg.value += '이겼습니다';
				var url;
				url = 'url("win.jpg")';
				var DivImg = document.getElementById('img');
				DivImg.style.background = url;
				break;
			}
			if (comp == 2) {
				draw.value++;
				msg.value += '무승부입니다.';
				var url;
				url = 'url("draw.jpg")';
				var DivImg = document.getElementById('img');
				DivImg.style.background = url;
				break;
			}
			if (comp == 3) {
				loss.value++;
				msg.value += '졌습니다.';
				var url;
				url = 'url("lose.jpg")';
				var DivImg = document.getElementById('img');
				DivImg.style.background = url;
				break;
			}

		case 3:
			if (comp == 1) {
				loss.value++;
				msg.value += '졌습니다.';
				var url;
				url = 'url("lose.jpg")';
				var DivImg = document.getElementById('img');
				DivImg.style.background = url;
				break;
			}
			if (comp == 2) {
				win.value++;
				msg.value += '이겼습니다.';
				var url;

				url = 'url("win.jpg")';
				var DivImg = document.getElementById('img');
				DivImg.style.background = url;
				break;
			}
			if (comp == 3) {
				draw.value++;
				msg.value += '무승부입니다.';
				var url;
				url = 'url("draw.jpg")';
				var DivImg = document.getElementById('img');
				DivImg.style.background = url;
				break;
			}

		}

		msg.value += ' ㅡ,,ㅡ';

		var a = parseInt(win.value);
		var b = parseInt(loss.value);
		var c = parseInt(draw.value);

		gameSum.value = a + b + c;

		winRate.value = Math.round((a / (a + b)) * 100);

	}

}

document.getElementById('img').onmouseover = function(event) {
	
		document.getElementById('img').style.display='none';
}

