import { Link } from "react-router-dom";

export default function Home() {
  return (
    <div>
      <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/about?name=sss&age=15">About</Link>
          </li>
          <li>
            <Link to="/contact/KIM/25">contact</Link>
          </li>
        </ul>
      </nav>
      <h1>HOME</h1>
      <p>Welcome to the home page</p>
    </div>
  );
}
