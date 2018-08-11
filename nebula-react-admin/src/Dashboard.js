// in src/Dashboard.js
import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import { ViewTitle } from 'react-admin/lib';
export default () => (
    <Card>
        <ViewTitle title="Welcome to the administration" />
        <CardContent>Lorem ipsum sic dolor amet...</CardContent>
    </Card>
);