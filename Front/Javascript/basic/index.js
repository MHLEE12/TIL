console.log('Hello world!');
console.log(1);
console.log(true);
console.log({ name: '홍길동', age: 20, merried: false });

console.log('로그 - 기본적인 출력');
console.info('로그 - 기능적으로는 log와 같음. 사용하기에 따라 용도 구분 가능');
console.warn('경고 - 문제가 될 수 있는 부분');
console.error('오류 - 에러 발생 상황');

// ※ console 비우기 : ctrl + L (윈도우, 맥 둘 다)
// ※ 브라우저 console에서 줄바꿈: shift + enter 

// ※ Node.js 환경에서 .js파일로 실행하기
//   - .js 파일을 node (파일명) 으로 실행
//   - Code Runner 확장 기능 사용
//     : 윈도우 ctrl + alt + N
//     : 맥     control + option + N

// ※ 변수(variable) : let 사용. 담긴 값이 바뀔 수 있음.
//   - undefined 는 아직 값이 정해지지 않은 것을 뜻함.

// ※ 상수(contant) : const를 쓴다. 담긴 값이 바뀔 수 없음. 흔히 대문자로 명명

// 상수를 변수로 변수를 상수로 재선언하면 오류남