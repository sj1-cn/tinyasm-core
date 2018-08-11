import React, { Children, Component } from 'react';
import PropTypes from 'prop-types';
import { Datagrid,TextField} from 'react-admin/lib';

import asyncViews from './asyncViews';
import AsyncInputs from './AsyncInputs';
import {extend} from 'lodash';
import Rest from './Rest';

export class DynamicDatagrid extends Component {
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
            ...rest
        } = this.props;
    const renderRest = function(rendered,fields){
      return fields.map(function(field){
        if(!rendered[field.name]){
          const Input=TextField;//AsyncInputs[field.type];
          return (
            <Input key={field.name} source={field.name}/>
          )
        }
        })
    }

        if (this.state.definedView === null) {
          return (            
            <Datagrid {...rest}>
                {children}
            </Datagrid>
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
            <Datagrid {...rest}>
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
            </Datagrid>
            );
          }
    }
}

DynamicDatagrid.propTypes = {
  basePath: PropTypes.string,
  children: PropTypes.node,
  classes: PropTypes.object,
  className: PropTypes.string,
  currentSort: PropTypes.shape({
      sort: PropTypes.string,
      order: PropTypes.string,
  }),
  data: PropTypes.object,
  hasBulkActions: PropTypes.bool,
  hover: PropTypes.bool,
  ids: PropTypes.arrayOf(PropTypes.any),
  isLoading: PropTypes.bool,
  onSelect: PropTypes.func,
  onToggleItem: PropTypes.func,
  resource: PropTypes.string,
  rowStyle: PropTypes.func,
  selectedIds: PropTypes.arrayOf(PropTypes.any),
  setSort: PropTypes.func,
  version: PropTypes.number,
};

export default DynamicDatagrid;
