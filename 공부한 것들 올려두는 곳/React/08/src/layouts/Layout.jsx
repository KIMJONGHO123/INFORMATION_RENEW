import Header from "./Header";
import Footer from "./Footer";
import Aside from "./Aside";
import Section from "./Section";

export default function Layouts({ children, showAside, asideLinks }) {
  return (
    <div className="App">
      <Header></Header>
      <main>
        {showAside && <Aside></Aside>}

        <Section>{children}</Section>
      </main>
      <Footer />
    </div>
  );
}
