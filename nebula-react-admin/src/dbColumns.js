import React from 'react';
import { SimpleForm,BooleanField,ReferenceArrayInput, SelectArrayInput ,BooleanInput,ArrayInput,SimpleFormIterator,NumberInput,NumberField,ArrayField,EditButton,TextInput,Edit,Create,DisabledInput,List, Datagrid, TextField } from 'react-admin/lib';

export const DbColumnList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="tableCatalog" />
            <TextField source="tableSchema" />
            <TextField source="tableName" />
            <TextField source="columnName" />
            <NumberField source="dataType" />
            <TextField source="typeName" />
            <NumberField source="columnSize" />
            <TextField source="isNullable" />
            <EditButton />
        </Datagrid>
    </List>
);

const DbColumnTitle = ({ record }) => {
    return <span>DbColumn {record ? `"${record.tableName}"` : ''}</span>;
};

export const DbColumnEdit = (props) => (
    <Edit title={<DbColumnTitle />} {...props}>
        <SimpleForm>
            <TextField source="tableCatalog" />
            <TextField source="tableSchema" />
            <TextField source="tableName" />
            <NumberField source="ordinalPosition" />
            <TextField source="columnName" />
            <NumberField source="dataType" />
            <TextField source="typeName" />
            <NumberField source="columnSize" />
            <TextField source="isNullable" />
            <TextField source="isAutoIncrement" />
            <TextField source="remarks" />
            <BooleanField source="columnDefaultValue" />
        </SimpleForm>
    </Edit>
);

export const DbColumnCreate = (props) => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="name" />
        </SimpleForm>
    </Create>
);
