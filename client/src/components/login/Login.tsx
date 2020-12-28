/**@jsxImportSource @emotion/react */
import React, { useState } from "react";
import { withRouter } from "react-router-dom";
import { jsx, css } from "@emotion/react";
import { danger, success } from "../login/Login.styles";

function Login(props: any) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loggedIn, setLoggedIn] = useState(false);
  const [loginError, setLoginError] = useState(false);

  function handleLoginFieldInput(e: React.ChangeEvent<HTMLInputElement>) {
    let name = e.currentTarget.name;
    let val = e.currentTarget.value;
    switch (name) {
      case "username":
        setUsername(val);
        break;
      case "password":
        setPassword(val);
        break;
      default:
        break;
    }
  }

  function handleLogin(e: React.SyntheticEvent) {
    e.preventDefault();
    // hard coded validation
    if (username === "logan" && password === "password") {
      setLoggedIn(true);
      props.history.push("/creditcards"); // to use, import withRouter from 'react-router-dom' and export default withRouter(component)
    } else {
      setLoggedIn(false);
      setLoginError(true);
    }
  }
  return (
    <div>
      {!loggedIn ? (
        <>
          <h1>Login</h1>
          {loginError && <h3 css={danger}>Invalid Credentials</h3>}
        </>
      ) : (
        <h3 css={success}>Successfully Logged In</h3>
      )}
      <form>
        <label>
          <h3>Username</h3>
          <input type="text" name="username" onChange={handleLoginFieldInput} value={username} placeholder="username" />
        </label>
        <label>
          <h3>Password</h3>
          <input type="password" name="password" onChange={handleLoginFieldInput} value={password} placeholder="password" />
        </label>
        <button onClick={handleLogin}>Login</button>
      </form>
    </div>
  );
}

export default withRouter(Login);
