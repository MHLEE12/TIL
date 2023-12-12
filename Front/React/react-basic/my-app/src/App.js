import React from "react";
import { Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import Counter from "./pages/Counter";
import Input from "./pages/input";

function App() {
  return (
    // JSX문법(XML)
    // 이 안에서는 class가 아닌 className을 써야 한다.
    <div className="App">
      <nav>
        <Link to="/">Home</Link> | <Link to="/about">About</Link> | <Link to="/counter">Counter</Link> |{" "}
        <Link to="/input">Input</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/counter" element={<Counter />} />
        <Route path="/input" element={<Input />} />
      </Routes>
    </div>
  );
}

export default App;
