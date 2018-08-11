import assert from 'assert';
import { shallow } from 'enzyme';
import React from 'react';

import { DynamicForm } from './DynamicForm';
import TextInput from '../input/TextInput';

describe('<DynamicForm />', () => {
    it('should embed a form with given component children', () => {
        const wrapper = shallow(
            <DynamicForm>
                <TextInput source="name" />
                <TextInput source="city" />
            </DynamicForm>
        );
        const inputs = wrapper.find('WithStyles(FormInput)');
        assert.deepEqual(inputs.map(i => i.prop('input').props.source), [
            'name',
            'city',
        ]);
    });

    it('should display <Toolbar />', () => {
        const wrapper = shallow(
            <DynamicForm>
                <TextInput source="name" />
            </DynamicForm>
        );
        const button = wrapper.find('WithStyles(Toolbar)');
        assert.equal(button.length, 1);
    });

    it('should pass submitOnEnter to <Toolbar />', () => {
        const handleSubmit = () => {};
        const wrapper1 = shallow(
            <DynamicForm submitOnEnter={false} handleSubmit={handleSubmit}>
                <TextInput source="name" />
            </DynamicForm>
        );
        const button1 = wrapper1.find('WithStyles(Toolbar)');
        assert.equal(button1.prop('submitOnEnter'), false);

        const wrapper2 = shallow(
            <DynamicForm submitOnEnter={true} handleSubmit={handleSubmit}>
                <TextInput source="name" />
            </DynamicForm>
        );
        const button2 = wrapper2.find('WithStyles(Toolbar)');
        assert.equal(button2.prop('submitOnEnter'), true);
    });
});
