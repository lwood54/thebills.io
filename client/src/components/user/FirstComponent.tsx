/**@jsxImportSource @emotion/react */
import React, { useState } from "react";
import { jsx, css } from "@emotion/react";

const base = css`
  color: orange;
`;

const danger = css`
  color: red;
`;

const button = css`
  background-color: teal;
  color: white;
`;

function FirstComponent() {
  const [email, setEmail] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [isDanger, setIsDanger] = useState(false);

  function handleDangerClick() {
    setIsDanger(!isDanger);
  }

  function handleFormInput(e: React.FormEvent<HTMLInputElement>) {
    const name = e.currentTarget.name;
    const val = e.currentTarget.value;
    switch (name) {
      case "email":
        setEmail(val);
        break;
      case "firstName":
        setFirstName(val);
        break;
      case "lastName":
        setLastName(val);
        break;
      default:
        break;
    }
  }

  function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    const user = {
      email,
      firstName,
      lastName,
    };

    console.log("submitting", user);
  }
  return (
    <div>
      <h1 css={[danger, base]}>Add a user</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="email">
          Email
          <input type="text" name="email" onChange={handleFormInput} />
        </label>
        <label htmlFor="firstName">
          First Name
          <input type="text" name="firstName" onChange={handleFormInput} />
        </label>
        <label htmlFor="lastName">
          Last Name
          <input type="text" name="lastName" onChange={handleFormInput} />
        </label>
        <input type="submit" value="submit" />
      </form>
      <h3 css={isDanger ? danger : base}>Danger Will Robinson</h3>
      <button css={button} onClick={handleDangerClick}>
        danger
      </button>
    </div>
  );
}

export default FirstComponent;
