"use strict"

changeState('create');

var toYYYYMMDD = new Date();

function changeState(state) {
	var stateMap = {
			create: 'none',
			detail: 'none'
	};
	
	stateMap[state] = '';
	
	var detailClass = document.querySelectorAll('.detail');
	var createClass = document.querySelectorAll('.create');
	
	for (var i = 0; i < detailClass.length; i++) {
		$(detailClass[i]).css('display', stateMap.detail);
	}
	
	for (var i = 0; i < createClass.length; i++) {
		$(createClass[i]).css('display', stateMap.create);
	}
}

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
}) ;

$('#btnAdd').click(function(event) {
	var board = new Board (
			$('#title').value,
			$('#content').value,
			$('#writer').value,
			$('#password').value	);
	
	boardList.push(board);
	
	resetForm();
	
	refreshBoardList();
	
});

function refreshBoardList() {
	var boardTable = $('#boardTable');
	var tbody = boardTable.firstElementChild;
	for (var i = tbody.children.length -1; i > 0; i--) {
		tbody.removeChild(tbody.children[i]);
	}
	
	for (var i in boardList) {
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
	event.preventDefault();
	
	changeState('detail');
	
	var board = boardList[this.getAttribute('bno')];
	$('#no').val(this.getAttribute('bno'));
	$('#title').val(board.title);
	$('#content').val(board.content);
	$('#writer').val(board.writer);
	$('#date').val($.toYYYYMMDD(board.date));
}