import React from "react"
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import LoginScreen from "../components/LoginScreen/LoginScreen"
import HomeScreen from "../components/HomeScreen/HomeScreen";
import AllCandidates from "../components/AllCandidatesComponent/AllCandidates";
import TopCandidates from "../components/TopCandidatesComponent/TopCandidates";
import UpdateTasks from "../components/UpdateTasks/UpdateTasks";

export default function AppRoute() {
    return (
        <Router>
        <Routes>
          <Route path="/" element={<LoginScreen />} />
          <Route path="/home" element={<HomeScreen />} />
          <Route path="/allCandidates" element={<AllCandidates />} />
          <Route path="/topCandidates" element={<TopCandidates />} />
          <Route path="/updateTasks" element={<UpdateTasks />} />
        </Routes>
      </Router>
    )
}


