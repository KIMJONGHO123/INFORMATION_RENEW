import { useContext } from "react";
export default function Son_02({ name, handleChange }) {
  const { globalState, setGlobalState } = useContext;
  return (
    <div>
      <h1>Son_01</h1>
      부모로부터 전달된 내용 확인 : {name}
      전역변수 : {globalState}
      전역변수 변경 : <button>변경하기</button>
      <br />
      <hr />
      <input
        type="text"
        placeholder="변경할 이름"
        onChange={(e) => {
          handleChange(e.target.value);
        }}
      />
    </div>
  );
}
