// in src/MyLayout.js
import React, { Component } from 'react';
import { Layout } from 'react-admin';
// import MyAppBar from './MyAppBar';
// import MyMenu from './MyMenu';
// import MyNotification from './MyNotification';

const MyLayout = (props) => <Layout 
    {...props}
    // appBar={MyAppBar}
    // menu={MyMenu}
    // notification={MyNotification}
/>;

export default MyLayout;