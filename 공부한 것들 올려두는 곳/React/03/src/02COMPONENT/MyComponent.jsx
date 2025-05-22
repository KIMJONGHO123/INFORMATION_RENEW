import { React, useEffect, useState } from "react";

const MyComponent = () => {
  const [count, setCount] = useState(0);

  const handleClick = () => {
    setCount((prev) => prev + 1);
  };

  // 최초 1회 실행
  useEffect(() => {
    console.log("init");
  }, []);

  // count state가 변경될때마다 실행
  useEffect(() => {
    console.log("count state change : ", count);
  }, [count]);

  return (
    <div>
      <h1>TITLE</h1>
      <h2>SUB_TITLE</h2>
      <hr></hr>
      <button onClick={handleClick}>BUTTON COUNT : {count}</button>
    </div>
  );
};

export default MyComponent;
