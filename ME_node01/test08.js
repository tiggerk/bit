/*
요청 파라미터의 값 꺼내기
- 클라이언트가 보낸 데이터(요청 파라미터)

*/
var http = require('http');
// 1. url 모듈을 가져온다. 사용하기 위해 변수에 넣는다.
var url = require('url');

http.createServer(function handler(req, res) {
	// 클라이언트가 보낸 name 파라미터 값을 변수에 저장하라!
	// 2. url 정보를 분석한다. 
	var urlMap = url.parse(req.url, true);	
	
	// 3. 쿼리 객체에서 파라미터 값을 추출한다.	
	var v1 = urlMap.query.v1;
	var v2 = urlMap.query.v2;
	var op = urlMap.query.op;
	
	var result = 0;
	
	if (op == 'plus') {
		result = Number(v1) + Number(v2);
		op = '+';
	} else if (op == 'minus') {
		result = v1 - v2;
		op = '-';
	} else if (op == 'multiple') {
		result = v1 * v2;
		op = '*';
	} else if (op == 'divide') {
		result = v1 / v2;
		op = '/';
	} else {
		result = '연산자가 없습니다';
		op = 'ERROR!!!';
	}
	
	
			
    res.writeHead(200, 'ok', 
    		{'Content-Type': 'text/html;charset=UTF-8'});
    res.write('<html><head><title>test08</title></head>');
    res.write('<body>');
    res.write('<h1>' + v1 + op + v2 + '=' + result + '</h1>');
    
    res.write('</body></html>');
    res.end();
	console.log('okoko');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
