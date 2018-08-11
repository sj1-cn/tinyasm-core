// in src/NotFound.js
import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import { ViewTitle } from 'react-admin/lib';

export default () => (
    <Card>
        <ViewTitle title="Not Found" />
        <CardContent>
            <h1>404: Page not found</h1>
        </CardContent>
    </Card>
);