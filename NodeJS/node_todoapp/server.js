// express라이브러리를 이용해서 server를 띄우기 위한 기본 세팅
const express = require('express'); // 설치한 라이브러리 첨부를 요구
const app = express(); // 첨부된 것으로 새로운 객체 생성

// 서버를 엶. listen(포트번호, 서버 띄운 후 실행할 코드)
app.listen(8081, function() {
    console.log('listening on 8081');
});

app.get('/test', function(req, resp) { // function(요청, 응답)
    resp.send('응답하는 페이지 입니다.');
});

app.get('/', function(req, resp) { // function(요청, 응답)
    resp.sendFile(__dirname + '/index.html');
});

app.get('/write', function(req, resp) { // function(요청, 응답)
    resp.sendFile(__dirname + '/write.html');
});