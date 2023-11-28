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
function Create(props) {
  return <article>
    <h2>Create</h2>
    <form onSubmit={event=>{
      event.preventDefault();
      const title = event.target.title.value;
      const body = event.target.body.value;
      props.onCreate(title, body);
    }}>
      <p><input type="text" name="title" placeholder='title'/></p>
      <p><textarea name="body" placeholder='body'></textarea></p>
      <p><input type="submit" value="Create"></input></p>
    </form>
  </article>
}

function App() {
  // const _mode = useState('WELCOME');
  // const mode = _mode[0];
  // const setMode  = _mode[1];
  const [mode, setMode] = useState('WELCOME'); // 위의 3줄을 한 줄로 표현한 것
  const [id, setId] = useState(null);
  
  const [nextId, setNextId] = useState(4);
  const [topics, setTopics] = useState([
    {id:1, title:'html', body:'html is ~~'},
    {id:2, title:'css', body:'css is ~~'},
    {id:3, title:'js', body:'js is ~~'}
  ]); 
  let content = null;
  if(mode === 'WELCOME') {
    content = <Article title="Welcome" body="Hello Web"></Article>
  } else if(mode === 'READ') {
    let title, body = null;
    for(let i = 0; i < topics.length; i++) {
      if(topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = content = <Article title={title} body={body}></Article>
  } else if(mode === 'CREATE') {
    content = <Create onCreate={(_title, _body)=>{
      const newTopic = {id: nextId, title: _title, body: _body};
      // setTopics 실행시 기존 배열(객체 등)과 같은지 비교 후에 같으면 set이 실행하지 않고, 달라야 실행하므로 새로운 배열로 복제해서 set실행
      const newTopics = [...topics];
      newTopics.push(newTopic);
      setTopics(newTopics);
      setMode('READ');
      setId(nextId);
      setNextId(nextId + 1);
    }}></Create>
  }
  return (
    <div>
      <Header title="Web" onChangeMode={()=>{
        setMode('WELCOME'); // setMode가 실행되면 App function이 재실행 되어서 mode값이 변경됨
      }}></Header>
      <Nav topics={topics} onChangeMode={(_id)=>{
        setMode('READ');
        setId(_id);
      }}></Nav>
      {content}
      <a href="/create" onClick={event=>{
        event.preventDefault();
        setMode('CREATE');
      }}>Create</a>
    </div>
  );
}

export default App;
