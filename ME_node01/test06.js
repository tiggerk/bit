/*
URL에서 파라미터 값을 문자열이 아닌 객체로 추출하기
url.parse(URL, true);
   => 리턴 객체의 query에는 문자열이 아닌 객체가 들어 있다.

*/
var http = require('http');	// http 객체 가져오기
var url = require('url');	// url 객체 가져오기

http.createServer(function handler(req, res) {
	console.log(req.url);
	
	// url로부터 경로 정보와 데이터 정보를 분리하여 추출
	// parse()에 true 파라미터 추가!
	var urlInfoMap = url.parse(req.url, true);
	console.log('URL 전체내용:', urlInfoMap.href);
	console.log('경로:', urlInfoMap.pathname);
	console.log('데이터:', urlInfoMap.search);
	
	// query 문자열이 객체로 준비된다.
	console.log('query 객체:', urlInfoMap.query);
	console.log('name=', urlInfoMap.query.name);
	console.log('age=', urlInfoMap.query.age);
	console.log('tel=', urlInfoMap.query.tel);

	
    res.writeHead(200, 'ok', 
    		{'Content-Type': 'text/html;charset=UTF-8'});
    res.write('<html><head><title>test06</title></head>');
    res.write('<body>');
    res.write('<h1>오호라... 이것이 노드제이에스</h1>')
    res.write('<p>자바스크립트만 제대로 배워도 서버측 ' +
    		'애플리케이션을 개발할 수 있다.</p>');
    res.write('</body></html>');
    res.end();
	console.log('okoko');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
