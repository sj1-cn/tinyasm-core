import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import { Admin, Resource } from 'react-admin/lib';
import simpleRestProvider from 'ra-data-simple-rest';

/* Main Module */
import Dashboard from './Dashboard';
import authProvider from './authProvider';
import NotFound from './NotFound';
import MyLayout from './MyLayout';

/* Resource Module */
import { PetList,PetEdit,PetCreate } from './pets';
import { DefinedTableList,DefinedTableEdit,DefinedTableCreate } from './definedTables';
import { DbTableList,DbTableEdit } from './dbTables';
import { DbColumnList,DbColumnEdit } from './dbColumns';
import { SystemTableList,SystemTableEdit } from './systemTables';

// const dataProvider = jsonServerProvider('http://jsonplaceholder.typicode.com');
const dataProvider = simpleRestProvider('http://localhost:8080/api');
const knownResources = [
  <Resource name="posts" list={DefinedTableList} />,
  <Resource name="comments" list={DefinedTableList} />,
];
const App = () => (
  <Admin title="Nebula Admin" appLayout={MyLayout} catchAll={NotFound} dashboard={Dashboard} authProvider={authProvider} dataProvider={dataProvider}>
      <Resource name="pets" list={PetList}  edit={PetEdit} create={PetCreate} />
      <Resource name="definedTables" list={DefinedTableList}  edit={DefinedTableEdit} create={DefinedTableCreate} />
      <Resource name="dbTables" list={DbTableList}  show={DbTableEdit}/>
      <Resource name="systemTables" list={SystemTableList}  show={SystemTableEdit}/>  
      <Resource name="systemColumns"/> 
  </Admin>   
);

/* <Resource name="dbColumns" list={DbColumnList}  edit={DbColumnEdit}/>*/



export default App;

