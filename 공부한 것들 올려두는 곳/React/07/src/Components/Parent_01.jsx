import { useContext, useState } from "react";
import Son_01 from "./Son_01";
import MyContext from "./MyContext";
export default function Parent_01() {
  const [name, setName] = useState("김김김");
  const { globalState, setGlobalState } = useContext(MyContext); // provider에서 관리하는 상태값
  return (
    <>
      <div>Parent01</div>
      전역변수 : {globalState} <br></br>
      전역변수 변경 :{" "}
      <button onClick={(e) => setGlobalState("Parent01 변경")}>변경하기</button>
      <div>
        <Son_01 name={name}></Son_01>
      </div>
    </>
  );
}
