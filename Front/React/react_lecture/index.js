// module.exports, require => CommonJS라는 모듈 시스템을 이용한 것

const calc = require("./calc");

console.log(calc.add(1, 2));
console.log(calc.add(2, 3));
console.log(calc.sub(5, 3));