import React from 'react';
import { SimpleForm,FormInput, EditButton,TextInput,Edit,Create,DisabledInput,List, Datagrid, TextField } from 'react-admin';
import DynamicForm, { RestInput } from './dynamic/DynamicForm';


export const DynamicList = (props) => (
    <List {...props}>
        <DynamicDatagrid>
            <TextField source="id" />
            <TextField source="name" />
            <EditButton />
        </DynamicDatagrid>
    </List>
);

const DynamicTitle = ({ record }) => {
    return <span>Pet {record ? `"${record.name}"` : ''}</span>;
};


export const DynEdit = (props) => (
    <div>  {console.log(props)}</div>
);

export const DynamicEdit = (props) => (
    <div><Edit title={<PetTitle />} {...props}>
        <DynamicForm>
            <RestInput/>
        </DynamicForm>
    </Edit></div>
);

export const DynamicCreate = (props) => (
    <Create {...props}>
        <DynamicForm mode='create'>
            <TextInput source="name" />
            <RestInput/>
        </DynamicForm>
    </Create>
);