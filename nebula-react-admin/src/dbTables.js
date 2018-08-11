import React from 'react';
import { SimpleForm,ShowButton,BooleanField,SimpleShowLayout,Show,ReferenceArrayInput, SelectArrayInput ,BooleanInput,ArrayInput,SimpleFormIterator,NumberInput,NumberField,ArrayField,EditButton,TextInput,Edit,Create,DisabledInput,List, Datagrid, TextField } from 'react-admin/lib';

export const DbTableList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="tableType" />
            <TextField source="tableCat" />
            <TextField source="tableSchema" />
            <TextField source="tableName" />
            <ShowButton />
        </Datagrid>
    </List>
);

const DbTableTitle = ({ record }) => {
    return <span>DbTable {record ? `"${record.tableName}"` : ''}</span>;
};

export const DbTableEdit = (props) => (
    <Show title={<DbTableTitle />} {...props}>
        <SimpleShowLayout>
            <TextField source="tableType" />
            <TextField source="tableCat" />
            <TextField source="tableSchema" />
            <TextField source="tableName" />
            <TextField source="selfReferencingColName" />
            <TextField source="refGeneration" />
            <ArrayField source="columns">
                <Datagrid>
                    <NumberField source="ordinalPosition" />
                    <TextField source="columnName" />
                    <NumberField source="dataType" />
                    <TextField source="typeName" />
                    <NumberField source="columnSize" />
                    <TextField source="isNullable" />
                    <TextField source="isAutoIncrement" />
                    <TextField source="remarks" />
                    <BooleanField source="columnDefaultValue" />
                </Datagrid>
            </ArrayField>
        </SimpleShowLayout>
    </Show>
);

const fetchResources = permissions =>
    fetch('http://localhost:8080/api/dbTables', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
    .then(response => response.json());