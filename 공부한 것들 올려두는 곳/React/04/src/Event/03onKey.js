// keydown
function handleKeyDown(event) {
  console.log("key down!", event.keyCode);
}

function MyComponent1() {
  return (
    <div>
      KEYDOWN :
      <input type="text" onKeyDown={handleKeyDown} />
    </div>
  );
}

//keyup
function handleKeyUp(event) {
  console.log("key up! ", event.keyCode);
}

function MyComponent2() {
  return (
    <div>
      키보드 업 :
      <input type="text" onKeyUp={handleKeyUp} />
    </div>
  );
}

//keypress
function handleKeyPress(event) {
  console.log("key pressed! key : ", event.key);
}

function MyComponent3() {
  return (
    <div>
      키 프레스 :
      <input type="text" onKeyPress={handleKeyPress} />
    </div>
  );
}

export default {
  MyComponent1,
  MyComponent2,
  MyComponent3,
};
