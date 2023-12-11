import MyButton from "./MyButton"

function App() {
    return (
        // JSX 식에는 부모 요소가 하나 있어야 함. 만약 div태그 말고 h1부터 넣고 싶다면 빈 괄호를 넣는다. <></>
        <div>
            <h1>Welcome my App</h1>
            <MyButton />
        </div>
    )
}

export default App

