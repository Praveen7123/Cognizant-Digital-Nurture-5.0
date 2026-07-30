import React from "react";
import CohortDetails from "./CohortDetails";

function App() {
  return (
    <div>
      <h1>Cohort Dashboard</h1>
      <CohortDetails cohortName="Java FSE" cohortCode="C001" technology="Java" status="ongoing" startDate="01-Jan-2026" />
      <CohortDetails cohortName="React Dev" cohortCode="C002" technology="React" status="completed" startDate="01-Jun-2025" />
    </div>
  );
}

export default App;
