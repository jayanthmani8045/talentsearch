import React from "react";

export default function HomeScreenHeader(props)
{
    return(
        <div className="header">
            <h1>Welcome, {props.firstName}</h1>
        </div>
    )
}