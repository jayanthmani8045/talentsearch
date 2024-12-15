import React from "react";
import { useLocation } from "react-router-dom"; 
import TopCandidateHeader from "./TopCandidatesHeader";
import TopCandidateCard from "./TopCandidatesCard";
export default function TopCandidates() {
    const location = useLocation();
    const data = location.state.hiringManager || []; 

    console.log("Data:", data);

    return (
        <>       
            <TopCandidateHeader></TopCandidateHeader>
                {data.map(candidate => (
                    <div className="card">
                         <TopCandidateCard key={candidate.username} candidate={candidate}/>
                    </div>
                ))} 
            
        </>
    );
}
