/*
HTML 출력하기
*/
var http = require('http');

http.createServer(function handler(req, res) {
    res.writeHead(200, 'ok', 
    		{'Content-Type': 'text/html;charset=UTF-8'});
    res.write('<html><head><title>test04</title></head>');
    res.write('<body>');
    res.write('<h1>오호라... 이것이 노드제이에스</h1>')
    res.write('<p>자바스크립트만 제대로 배워도 서버측 ' +
    		'애플리케이션을 개발할 수 있다.</p>');
    res.write('</body></html>');
    res.end();
	console.log('okoko');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
