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
    console.log(req);
});

server.listen(8081);