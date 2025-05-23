import { useContext, useState } from "react";
import MyContext from "./MyContext";
export default function Son_02({ name }) {
  const { globalState, setGlobalState } = useContext(MyContext);
  return (
    <div>
      <h1>Son_01</h1>
      전역변수 : {globalState}
      <button onClick={(e) => setGlobalState("Son01 변경")}>번경하기</button>
      <br></br>
      <hr></hr>
      부모로부터 전달된 내용 확인 : {name}
    </div>
  );
}
