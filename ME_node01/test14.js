/*
GET 요청과 POST 요청 구분하기
- request.method 프로퍼티의 값을 확인하라!
- 
 */
var http = require('http');
var url = require('url');


http.createServer(function handler(req, res) {
		
	if (req.method == 'GET') { 
		console.log('get 요청-------------------------');
		var obj = url.parse(req.url, true);
		// 쿼리 객체에서 요청 값을 꺼낸다.
		var v1 = parseInt(obj.query.v1, 10);
		var v2 = parseInt(obj.query.v2, 10);
		var op = obj.query.op;
		
		var result= v1 + v2;
		console.log(op, result);
		
	} else {
		console.log('post 요청');
	}
	res.end();
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

