import { useState } from "react";

const MyComponent = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
    console.log(e.target.value);
  };
  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
    console.log(e.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log("username :", username, "passsword : ", password);
  };
  return (
    <form onSubmit={handleSubmit}>
      USERNAME :{" "}
      <input type="text" name="username" onChange={handleUsernameChange} />
      PASSWORD : <input type="password" onChange={handlePasswordChange} />
      <button type="submit">Submit</button>
    </form>
  );
};
export default {
  MyComponent,
};
