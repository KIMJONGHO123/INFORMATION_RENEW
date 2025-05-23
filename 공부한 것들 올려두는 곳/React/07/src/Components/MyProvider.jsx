import { useState } from "react";
import AppContext from "./MyContext";
export default function MyProvider({ children }) {
  console.log(children);
  const [globalState, setGlobalState] = useState("KOREA01");
  const value = { globalState, setGlobalState };
  return <AppContext.Provider value={value}>{children}</AppContext.Provider>;
}
