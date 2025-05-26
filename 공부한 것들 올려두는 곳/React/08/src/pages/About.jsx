import Layouts from "../layouts/Layout";

export default function About() {
  const asideLinks = [
    { title: "회사소개", href: "/about/1" },
    { title: "연혁", href: "/about/2" },
    { title: "팀 소개", href: "/about/3" },
    { title: "오시는길", href: "/about/4" },
  ];
  return (
    <Layouts showAside={true} asideLinks={asideLinks}>
      <h1>About Page</h1>
      <p>이곳은 홈페이지의 about 페이지입니다.</p>
    </Layouts>
  );
}
