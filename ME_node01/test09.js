/*
GET 요청과 POST 요청 구분하기
- request.method 프로퍼티의 값을 확인하라!

*/
var http = require('http');
var url = require('url');

http.createServer(function handler(req, res) {
	
	res.writeHead(200, 'ok', 
			{'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test04</title></head>');
	res.write('<body>');
	res.write('<h1>' + v1 + op + v2 + '=' + result + '</h1>');
	
	
	
	if (req.method == 'GET') {
		var urlMap = url.parse(req.url, true);
		var v1 = urlMap.query.v1;
		var v2 = urlMap.query.v2;
		var op = urlMap.query.op;
		
		var result = 0;
		if ( op == 'plus') {
			result = Number(v1) + Number(v2);
			op = '-';
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
			op = '(none)';
		}
	
	} else {
		res.write(req.method + '요청을 지원하지 않습니다!');	
	}
			    
    res.write('</body></html>');
    res.end();

}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
