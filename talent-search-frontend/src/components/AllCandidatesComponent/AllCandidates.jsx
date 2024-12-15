import React from "react";
import { useLocation } from "react-router-dom"; 
import CandidateCard from "./CandidateCard";
import CandidateHeader from "./CandidateHeader";
import "./AllCandidates.css"

export default function AllCandidates() {
    const location = useLocation();
    const data = location.state.data || []; 

    console.log("Data:", data);

    return (
        <>       
            <CandidateHeader></CandidateHeader>
                {data.map(candidate => (
                    <div className="card">
                         <CandidateCard candidate={candidate}/>
                    </div>
                ))} 
            
        </>
    );
}
