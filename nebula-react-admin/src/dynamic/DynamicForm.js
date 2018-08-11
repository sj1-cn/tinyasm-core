import React, { Children, Component } from 'react';
import PropTypes from 'prop-types';
import { SimpleForm,TextInput} from 'react-admin/lib';

import asyncViews from './asyncViews';
import AsyncInputs from './AsyncInputs';
import {extend} from 'lodash';
import Rest from './Rest';

export class DynamicForm extends Component {
    _hasUnmounted = false;
    _exclude = {};

    state = {
      definedView: null,
    };
  
    constructor(props) {
      super(props);
      asyncViews(this.props.resource);
      if("create"==props.mode){
        this._exclude['id']='id';
      }
      if(this.props.exclude)this.props.exclude.split(",").map(source=>this._exclude[source]=source);
    }


    componentDidMount() {
      // Now that this component has mounted,
      // Wait for earlier pre-fetch to complete and update its state.
      // (This assumes some kind of external cache to avoid duplicate requests.)
      asyncViews(this.props.resource).then(definedView => {
        if (!this._hasUnmounted) {
          this.setState({ definedView });
        }
      });
    }
  

    componentWillUnmount() {
      this._hasUnmounted = true;
    }


    render() {
        const {
            children,
            classes = {},
            className,
            invalid,
            pristine,
            saving,
            submitOnEnter,
            toolbar,
            ...rest
        } = this.props;
    const renderRest = function(rendered,fields){
      return fields.map(function(field){
        if(!rendered[field.name]){
          const Input=AsyncInputs[field.type];
          return (
            <Input key={field.name} source={field.name}/>
          )
        }
        })
    }

        if (this.state.definedView === null) {
          return (            
            <SimpleForm {...rest}>
                {children}
            </SimpleForm>
            );
          } else {
              var restRendered = false;
              const rendered = extend({},this._exclude);
              const fields=this.state.definedView.fields;

              React.Children.map(children, function(input){
                if(input.type !== Rest){
                  rendered[input.props.source]=input.props.source;
                }
              });


            return (            
            <SimpleForm {...rest}>
              {
                React.Children.map(children, function(field){
                  if(field.type !== Rest){
                    return field;
                  }else{
                    restRendered = true;
                    return renderRest(rendered,fields);
                  }
                }
              )
              } 
              {!restRendered?renderRest(rendered,fields):null}
            </SimpleForm>
            );
          }
    }
}

DynamicForm.propTypes = {
    basePath: PropTypes.string,
    children: PropTypes.node,
    classes: PropTypes.object,
    className: PropTypes.string,
    defaultValue: PropTypes.oneOfType([PropTypes.object, PropTypes.func]),
    handleSubmit: PropTypes.func, // passed by redux-form
    invalid: PropTypes.bool,
    pristine: PropTypes.bool,
    record: PropTypes.object,
    exclude: PropTypes.string,
    mode: PropTypes.string,
    resource: PropTypes.string,
    redirect: PropTypes.oneOfType([
        PropTypes.string,
        PropTypes.bool,
        PropTypes.func,
    ]),
    save: PropTypes.func, // the handler defined in the parent, which triggers the REST submission
    saving: PropTypes.oneOfType([PropTypes.object, PropTypes.bool]),
    submitOnEnter: PropTypes.bool,
    toolbar: PropTypes.element,
    validate: PropTypes.func,
    version: PropTypes.number,
};

export default DynamicForm;
