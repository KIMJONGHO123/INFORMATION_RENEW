// 01 기본 JSX 요소 생성
export const Elements = () => <h1>Hello world -1</h1>;

// 02 functino 예약어도 export
export function Element2() {
  return <h2>HEllo world -2</h2>;
}

// 03 외부 인자 받기
export function Elements3(props) {
  if (props.auth == "ROLE_ADMIN") {
    return <h2>HEllo ADMIN, Name : {props.name}</h2>;
  }
  if (props.auth === "ROLE_USER") {
    return <h2>HELLO USWER, Name : {props.name}</h2>;
  }
}

// 03 외부 인자 받기(구조 분해 할당)
// export function Elements4({ auth, name }) {
//   if (auth === "ROLE_ADMIN") {
//     return <h2>HEllo ADMIN, Name : {name}</h2>;
//   }
//   if (auth === "ROLE_USER") {
//     return <h2>HELLO USWER, Name : {name}</h2>;
//   }
// }

export const Elements4 = ({ auth, name }) => {
  if (auth === "ROLE_ADMIN") {
    return <h2>HEllo ADMIN, Name : {name}</h2>;
  }
  if (auth === "ROLE_USER") {
    return <h2>HELLO USWER, Name : {name}</h2>;
  }
};
