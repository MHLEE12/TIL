import './App.css';

function App() {
  // 컴포넌트
  let name = 'JSX';

  return (
    <div className="App">
      <header className="App-header">
        <h2>안녕 리액트 {name}</h2>
      </header>
    </div>
  );
}

export default App;
