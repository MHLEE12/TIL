import React from 'react';
// import './App.css';
import MyHeader from './MyHeader';
import MyFooter from './MyFooter';

function App() {
  // 컴포넌트
  let name = 'JSX';
  const number = 5;

  const style = {
    App: {
      backgroundColor: "black"
    },
    h2: {
      color: "red"
    },
    bold_text: {
      color: "green"
    }
  };

  return (
    <div className="App" style={style.App}> 
      <MyHeader/>
      <header className="App-header">
        <h2 style={style.h2}>안녕 리액트 {name}</h2>
        <b id="bold_text" style={style.bold_text}>{number}는 : {number % 2 === 0 ? "짝수" : "홀수"}</b>
      </header>
      <MyFooter/>
    </div>
  );
}
// ES module system
export default App;
