/*
GET 요청과 POST 요청 구분하기
- request.method 프로퍼티의 값을 확인하라!
- 
 */
var http = require('http');
var url = require('url');
var qs = require('querystring');

http.createServer(function handler(req, res) {
	var v1, v2, op;
	
	if (req.method == 'GET') { 
		var urlMap = url.parse(req.url, true);

		v1 = parseInt(urlMap.query.v1, 10);
		v2 = parseInt(urlMap.query.v2, 10);
		op = urlMap.query.op;
		
		displayResult(req,res, v1, v2, op);
	} else {
		var messageBody = '';
		// data 이벤트는 클라이언트에서 데이터를 읽을 때 마다
		// 일정 시간 또는 일정 크기 단위로 발생한다.
		// data 이벤트가 발생할 때 마다 등록된 함수를 호출한다.
		// 따라서 개발자는 클라이언트가 보낸 데이터를 받고 싶으면
		// data 이벤트에 리스너를 등록하고, 리스너가 호출될 때
		// 넘어오는 파라미터 값을 보관하면 된다.
		req.on('data', function(chunk){
			messageBody += chunk;
		});
		
		req.on('end', function(){
			//console.log(messageBody);
			var paramMap = qs.parse(messageBody);
			/*
			console.log('v1 = ', paramMap.v1);
			console.log('op = ', paramMap.op);
			console.log('v2 = ', paramMap.v2);
			*/
			v1 = parseInt(paramMap.v1);
			v2 = parseInt(paramMap.v2);
			op = paramMap.op;
			
			displayResult(req,res, v1, v2, op);
		});
	}
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');


function displayResult(req, res, v1, v2, op) {
	res.writeHead(200, 'ok', 
			{'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>');
	res.write('<body>');
	
	switch(op){
	case 'plus':
		res.write(v1 + ' + ' + v2 + ' = ' + (v1 + v2));
		break;
	case 'minus':
		res.write(v1 + ' - ' + v2 + ' = ' + (v1 - v2));
		break;
	case 'multiple':
		res.write(v1 + ' * ' + v2 + ' = ' + (v1 * v2));
		break;
	case 'divide':
		res.write(v1 + ' / ' + v2 + ' = ' + (v1 / v2));
		break;
	default:
		res.write('해당 연산자가 없습니다!');
	}
	
	res.write('</body></html>');
	res.end();
}
