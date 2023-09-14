import React from 'react';
import * as ReactDOMClient from 'react-dom/client';
import 'antd/dist/antd.min.css';
import reportWebVitals from './reportWebVitals';
import SideDemo from "./page/SideDemo"


const root = ReactDOMClient.createRoot(document.getElementById('root') );
root.render(<SideDemo />)
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
