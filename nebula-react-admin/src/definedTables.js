import React from 'react';
import { SimpleForm,BooleanField,BooleanInput,ArrayInput,SimpleFormIterator,NumberInput,NumberField,ArrayField,EditButton,TextInput,Edit,Create,DisabledInput,List, Datagrid, TextField } from 'react-admin/lib';

export const DefinedTableList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="id" />
            <TextField source="name" />
            <EditButton />
        </Datagrid>
    </List>
);

const DefinedTableTitle = ({ record }) => {
    return <span>DefinedTable {record ? `"${record.name}"` : ''}</span>;
};

export const DefinedTableEdit = (props) => (
    <Edit title={<DefinedTableTitle />} {...props}>
        <SimpleForm>
            <DisabledInput source="id" />
            <TextInput source="name" />

            <ArrayInput source="columns">
                <SimpleFormIterator>
                    <TextInput source="columnName" />
                    <NumberInput source="dataType" />
                    <TextInput source="typeName" />
                    <NumberInput source="size" />
                    <NumberInput source="decimalDigits" />
                    <BooleanInput source="nullable" />
                    <BooleanInput source="autoIncrment" />
                </SimpleFormIterator>
            </ArrayInput>
        </SimpleForm>
    </Edit>
);

export const DefinedTableCreate = (props) => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="name" />
        </SimpleForm>
    </Create>
);