import { useEffect, useState, useContext } from "react";
import Son_02 from "./Son_02";

export default function Parent_02() {
  const [name, setName] = useState("");
  const { globalState, setGlobalState } = useContext;
  const handleChange = (name) => {
    setName(name);
  };

  return (
    <>
      <h1>Parent01</h1>
      전역변수 : {globalState}
      전역변수 변경 : <button>번경하기</button>
      <div>
        <Son_02 name={name} handleChange={handleChange}></Son_02>
        자식한테서 넘어온 값 : {name};
      </div>
    </>
  );
}
