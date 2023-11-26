import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function Header(props) {
  // console.log('props', props);
  // console.log('props2', props.title);
  return <header>
  <h1><a href="/" onClick={function(event){
    event.preventDefault(); // 기본동작 방지
    props.onChangeMode();
  }}>{props.title}</a></h1>
</header>
}

function Nav(props) {
  const lis = [];
  for(let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(<li key={t.id}>
        <a id={t.id} href={'/read/' + t.id} onClick={event=>{
          event.preventDefault();
          props.onChangeMode(Number(event.target.id));
        }}>{t.title}</a>
      </li>);
  }
  return <nav>
  <ol>
    {lis}
  </ol>
</nav>
}

function Article(props) {
  return <article>
  <h2>{props.title}</h2>
  {props.body}
</article>
}

function App() {
  // const _mode = useState('WELCOME');
  // const mode = _mode[0];
  // const setMode  = _mode[1];
  const [mode, setMode] = useState('WELCOME'); // 위의 3줄을 한 줄로 표현한 것
  const [id, setId] = useState(null);

  const topics = [
    {id:1, title:'html', body:'html is ~~'},
    {id:2, title:'css', body:'css is ~~'},
    {id:3, title:'js', body:'js is ~~'}
  ]; 
  let content = null;
  if(mode === 'WELCOME') {
    content = <Article title="Welcome" body="Hello Web"></Article>
  } else if(mode === 'Read') {
    let title, body = null;
    for(let i = 0; i < topics.length; i++) {
      if(topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = content = <Article title={title} body={body}></Article>
  }
  return (
    <div>
      <Header title="Web" onChangeMode={()=>{
        setMode('WELCOME'); // setMode가 실행되면 App function이 재실행 되어서 mode값이 변경됨
      }}></Header>
      <Nav topics={topics} onChangeMode={(_id)=>{
        setMode('Read');
        setId(_id);
      }}></Nav>
      {content}
    </div>
  );
}

export default App;
