import { useState } from "react";
import Basic01 from "./Condition/01Basic";

function App() {
  return (
    <div className="App">
      <Basic01.Component01 isAuth={true}></Basic01.Component01>
      <hr></hr>
      <Basic01.Component02 isAuth={true}></Basic01.Component02>
      <hr></hr>
      <Basic01.Component03 items={["a", "b", "c"]}></Basic01.Component03>
    </div>
  );
}

export default App;
