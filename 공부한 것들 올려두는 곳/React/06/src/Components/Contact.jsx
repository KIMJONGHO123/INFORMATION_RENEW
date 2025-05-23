import { Link, useNavigate, useParams } from "react-router-dom";

export default function Contact() {
  const { name, age } = useParams();
  const navigate = useNavigate();
  const handleHome = () => {
    console.log("Home");
    navigate("/");
  };
  const handleAbout = () => {
    console.log("About");
    navigate("/about?name=Hone&age=18");
  };
  const handleContact = () => {
    console.log("Contact");
    navigate("/contact");
  };
  return (
    <div>
      <nav>
        <ul>
          <li>
            <button onClick={handleHome}>Home</button>
          </li>
          <li>
            <button onClick={handleAbout}>About</button>
          </li>
          <li>
            <button onClick={handleContact}>Contact</button>
          </li>
        </ul>
      </nav>
      <h1>Contact</h1>
      name : {name} , age : {age} <br></br>
      <p>Welcome to the contact page</p>
    </div>
  );
}
