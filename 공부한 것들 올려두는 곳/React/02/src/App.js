import React, { useState } from "react";
import {
  Elements,
  Element2,
  Elements3,
  Elements4,
  Elements5,
} from "./01JSX/JSX_Basic";
import CustomModal from "./01JSX/Modeal";
import ALL from "./01JSX/JSX_Basic";
import CustomComponent from "./01JSX/CustomComponent";
// 이벤트 확인
import { Component01, Component02 } from "./01JSX/JSX_EVENT";

function App() {
  const headerTitle = "HEADER TITLE";
  const mainContents = "Main CONTENTS";
  const footerContents = "footer CONTENTS";

  const [open, setOpen] = useState(false);

  return (
    <>
      <div className="App">
        <div
          className="header"
          style={{ fontSize: "30px", background: "green" }}
        >
          {headerTitle}
          <Elements></Elements>
          <Element2></Element2>
        </div>
        <div className="main">{mainContents}</div>
        <div className="footer">
          <Elements3 auth={"ROLE_USER"} name={"홍길동"}></Elements3>
          <Elements4 auth={"ROLE_USER"} name={"김김김"}></Elements4>
          <Elements5 list={["aaa", "bbb", "ccc"]}></Elements5>

          <ALL.DefaultComponent1></ALL.DefaultComponent1>
          <ALL.DefaultComponent2></ALL.DefaultComponent2>
          <CustomComponent></CustomComponent>

          <Component01></Component01>
          <Component02></Component02>
        </div>
      </div>
      <hr></hr>
      <div>
        <div>커스텀 모달창 입니다.</div>
        <button onClick={() => setOpen((prev) => !prev)}> 모달 열기</button>
        <CustomModal onClose={() => setOpen(false)} open={open}></CustomModal>
      </div>
    </>
  );
}

export default App;
