import { Link, useLocation } from "react-router-dom";

export default function About() {
  const location = useLocation();
  const query = new URLSearchParams(location.search);
  return (
    <div>
      <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
          <li>
            <Link to="/contact">contact</Link>
          </li>
        </ul>
      </nav>
      <h1>About</h1>
      Param : {query.get("name")},{query.get("age")}
      <p>Welcome to the About page</p>
    </div>
  );
}
