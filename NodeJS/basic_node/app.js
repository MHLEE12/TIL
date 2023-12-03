// Core modules
// - http, https, fs, path, os

// 파일을 불러옴. 경로가 없으면 global module을 불러옴
const http = require('http');

// 서버 여는 방법 1
// function rqListener(req, res) {}
// http.createServer(rqListener);

// 서버 여는 방법 2. 익명 함수 사용
// http.createServer(function(req, res) {
//     // 서버에 요청이 들어올 때마다 익명 함수가 실행됨
//     // 이것이 node의 주된 event driven architecture(EDA)
// });

// 서버 여는 방법 3. createServer 콜백 함수 사용
const server = http.createServer((req, res) => {
    // 실행은 터미널에서 > node [파일명] (여기서는 node app.js 로 실행) 

    // console.log(req);
    // console.log(req.url, req.method, req.headers);

    // process.exit(); // 이벤트 루프를 잘라서 프로그램을 종료 시킴

    res.setHeader('Content-Type', 'text/html');
    res.write('<html>');
    res.write('<head><title>My First Page</title></head>');
    res.write('<body><h1>Hello from my Node.js Server!!</h1></body>');
    res.write('</html>');
    res.end(); // 응답을 끝냄. 이 뒤에 write를 작성하면 에러 발생
});

server.listen(8081);