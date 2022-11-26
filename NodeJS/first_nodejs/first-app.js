// console.log('Hello from Node.js!!');

const fs = require('fs');

// 파일 시스템 모듈을 이용해서 파일을 생성하는 메서드
fs.writeFileSync('hello.txt', 'Hello from Node.js!');