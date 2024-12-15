import React from "react";
import { useLocation } from 'react-router-dom';
import "./HomeScreen.css";
import HomeMenu from "./HomeMenu";
export default function HomeScreen()
{
    const location = useLocation();
    const data = location.state || {}
    console.log(data);
    return(
        <>
            <div className="navBar">
                <h1>Welcome to your space {data.hiringManager.username},</h1>
            </div>
            <HomeMenu hiringManager={data.hiringManager}></HomeMenu>
        </>
    )
}