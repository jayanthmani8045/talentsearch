import React from "react";
import "./LoginScreen.css"
import LoginHeader from "./LoginHeader";
import LoginForm from "./LoginForm";

export default function LoginScreen()
{
    return(
        <div className="login">
            <LoginHeader></LoginHeader>
            <LoginForm></LoginForm>
        </div>
    )
}