import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails(props) {
    // h3 green when status is "ongoing", blue otherwise
    const headingColor = props.status === "ongoing" ? "green" : "blue";

    return (
        <div className={styles.box}>
            <h3 style={{ color: headingColor }}>{props.cohortName}</h3>
            <dl>
                <dt>Cohort Code</dt>
                <dd>{props.cohortCode}</dd>
                <dt>Technology</dt>
                <dd>{props.technology}</dd>
                <dt>Status</dt>
                <dd>{props.status}</dd>
                <dt>Start Date</dt>
                <dd>{props.startDate}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;
