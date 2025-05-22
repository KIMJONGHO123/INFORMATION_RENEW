//01
function handleClick01() {
  console.log("clicked...");
}

export function Component01() {
  return (
    <div>
      <h1>HELLO WORLD</h1>
      <button onClick={handleClick01}>클릭버튼</button>
    </div>
  );
}
export function Component02() {
  function handleClick02() {
    console.log("clicked02...");
  }
  return (
    <div>
      <h1>HELLO WORLD</h1>
      <button onClick={handleClick02}>클릭 버튼</button>
    </div>
  );
}
