"use strict";

// 목표 : 리팩토링 => 반복되는 코드를 함수로 추출하여 정리한다.
// extract method => changeState 생성
// 엘리먼트 찾는 코드 => 간단한 함수로 정의 => $()
// 목표 : 라이브러리화?
// 자주 사용할 함수는 별도의 파일에 분리하여 둔다. 
// 목표 : 라이브러리화2
// 기존 엘리먼트 객체에 나만의 조미료를 뿌리자!
// 목표 : val() 조미료 추가, css() 조미료 추가, 생닭 가공 => bit() if문 참조

changeState('create');

var toYYYYMMDD = new Date();

function changeState(state) {
	var stateMap = {
			create : 'none',
			detail : 'none'
	};

	stateMap[state] = '';
	/*
	 * var createState = 'none'; 
	 * var detailState = 'none';
	 * 
	 * if(state == 'create') { 
	 * createState = ''; 
	 * } else if (state == 'detail') {
	 * detailState = ''; 
	 * }
	 */
	var detailClass = document.querySelectorAll('.detail');
	var createClass = document.querySelectorAll('.create');

	for (var i = 0; i < detailClass.length; i++) {
		$(detailClass[i]).css('display', stateMap.detail);
	}

	for (var i = 0; i < createClass.length; i++) {
		$(createClass[i]).css('display', stateMap.create);
	}
}

// 게시글을 저장하는 객체 생성자 함수
function Board(title, content, writer, password) {
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.password = password;
	this.date = new Date();
	this.count = 0;
}

function resetForm() {
	$('#btnCancel').click();
}

var boardList = [];

$('#btnCancel').click(function(event) {
	changeState('create');
});

$('#btnAdd').click(function(event) {
	var board = new Board(
			$('#title').value,
			$('#content').value,
			$('#writer').value, 
			$('#password').value);

	boardList.push(board);

	resetForm();

	refreshBoardList();

});

function refreshBoardList() {
	var boardTable = $('#boardTable');
	// var tbody = boardTable.children[0]; //<tbody>
	var tbody = boardTable.firstElementChild; // <tbody>
	for (var i = tbody.children.length - 1; i > 0; i--) {
		// console.log(boardTable.children[i]);
		tbody.removeChild(tbody.children[i]);
	}
	
	for ( var i in boardList) {
		$('<tr>')
			.appendTo(tbody)
			.append($('<td>').html(i))
			.append($('<td>')					
					.append($('<a>')
							.attr('bno', new String(i))
							.attr('href', '#')
							.click(loadBoardDetail)
							.html(boardList[i].title)))
			.append($('<td>').html(boardList[i].writer))
			.append($('<td>').html($.toYYYYMMDD(boardList[i].date)))
			.append($('<td>').html(boardList[i].count));
			
	}
}

function loadBoardDetail(event) {
	// 원래 하던 기능 하지마!
	event.preventDefault();

	changeState('detail');

	var board = boardList[this.getAttribute('bno')];
	$('#no').val(this.getAttribute('bno'));
	$('#title').val(board.title);
	$('#content').val(board.content);
	$('#writer').val(board.writer);
	$('#date').val($.toYYYYMMDD(board.date));
}
