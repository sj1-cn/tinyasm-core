import React from 'react';
import { SimpleForm,FormInput, EditButton,TextInput,Edit,Create,DisabledInput,List, Datagrid, TextField } from 'react-admin';
import DynamicForm, { RestInput } from './dynamic/DynamicForm';
import Rest from './dynamic/Rest';
import DynamicDatagrid from './dynamic/DynamicDatagrid';


export const PetList = (props) => (
    <List {...props}>
        <DynamicDatagrid>
            <TextField source="id" />
            <Rest />
            <EditButton />
        </DynamicDatagrid>
    </List>
);

const PetTitle = ({ record }) => {
    return <span>Pet {record ? `"${record.name}"` : ''}</span>;
};

export const PetEdit = (props) => (
    <div><Edit title={<PetTitle />} {...props}>
        <DynamicForm>
            <Rest/>
        </DynamicForm>
    </Edit></div>
);

export const PetCreate = (props) => (
    <Create {...props}>
        <DynamicForm mode='create'>
            <TextInput source="name" />
        </DynamicForm>
    </Create>
);