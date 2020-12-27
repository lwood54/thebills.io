import React, { useState } from "react";

function FirstComponent() {
  const [email, setEmail] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");

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
      <h1>Add a user</h1>
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
    </div>
  );
}

export default FirstComponent;
