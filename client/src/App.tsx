import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Welcome from "./components/login/Welcome";
import CreditCards from "./components/creditcards/CreditCards";
import Error from "./components/error/Error";

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path="/" exact component={Welcome} />
          <Route path="/creditcards" component={CreditCards} />
          <Route component={Error} />
        </Switch>
      </Router>
    </div>
  );
}

export default App;
