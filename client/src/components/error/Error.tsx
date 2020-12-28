import React from "react";
import { Link } from "react-router-dom";
import { success } from "./Error.styles";

function Error() {
  return (
    <div>
      <h1>There is no page at the location you've navigated to.</h1>
      <Link to="/">Home</Link>
    </div>
  );
}

export default Error;
