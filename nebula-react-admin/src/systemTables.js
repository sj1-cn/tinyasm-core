import React from 'react';
import { SimpleForm,ShowButton,ReferenceManyField,SimpleShowLayout,Show,BooleanField,SimpleFormIterator,NumberField,ArrayField,EditButton,Edit,Create,DisabledField,List, Datagrid, TextField } from 'react-admin/lib';

export const SystemTableList = (props) => (
    <List {...props}>
        <Datagrid>
            <TextField source="tableSchema" />
            <TextField source="tableType" />
            <TextField source="tableName" />
            <TextField source="storageType" />
            <TextField source="typeName" />
            <TextField source="tableClass" />
            <NumberField source="rowCountEstimate" />
            <ShowButton />
        </Datagrid>
    </List>
);

const SystemTableTitle = ({ record }) => {
    return <span>SystemTable {record ? `"${record.tableName}"` : ''}</span>;
};

export const SystemTableEdit = (props) => (
    <Show title={<SystemTableTitle />} {...props}>
        <SimpleShowLayout>
            <TextField source="tableCatalog" />
            <TextField source="tableSchema" />
            <TextField source="tableType" />
            <TextField source="storageType" />
            <TextField source="sql" />
            <TextField source="remarks" />
            <NumberField source="lastModification" />
            <NumberField source="id" />
            <TextField source="typeName" />
            <TextField source="tableClass" />
            <NumberField source="rowCountEstimate" />

        </SimpleShowLayout>
    </Show>
);

/*
            <ReferenceManyField label="Columns" reference="systemColumns" target="tableName">
                <Datagrid>
                    <TextField source="tableCatalog" />
                    <TextField source="tableSchema" />
                    <TextField source="tableName" />
                    <TextField source="columnName" />
                    <NumberField source="ordinalPosition" />
                    <TextField source="columnDefault" />
                    <TextField source="isNullable" />
                    <NumberField source="dataType" />
                    <NumberField source="characterMaximumLength" />
                    <NumberField source="characterOctetLength" />
                    <NumberField source="numericPrecision" />
                    <NumberField source="numericPrecisionRadix" />
                    <NumberField source="numericScale" />
                    <TextField source="characterSetName" />
                    <TextField source="collationName" />
                    <TextField source="typeName" />
                    <NumberField source="nullable" />
                    <BooleanField source="isComputed" />
                    <NumberField source="selectivity" />
                    <TextField source="checkConstraint" />
                    <TextField source="sequenceName" />
                    <TextField source="remarks" />
                    <NumberField source="sourceDataType" />
                    <TextField source="columnType" />
                    <TextField source="columnOnUpdate" />
                </Datagrid>
            </ReferenceManyField>
            <ArrayField source="columns">
                <SimpleFormIterator>
                    <TextField source="columnName" />
                    <NumberField source="dataType" />
                    <TextField source="typeName" />
                    <NumberField source="size" />
                    <NumberField source="decimalDigits" />
                    <BooleanField source="nullable" />
                    <BooleanField source="autoIncrment" />
                </SimpleFormIterator>
            </ArrayField>
*/