import React from 'react';

import { makeStyles } from '@material-ui/core/styles';
import green from "@material-ui/core/colors/green";


const useStyles = makeStyles((theme) => ({
    root:{
        backgroundColor: green["200"],
        height: '2000px'
    },
}));

function Test() {

    const classes = useStyles();
    return (
        <div className={classes.root}>
            Test PAGE
        </div>
    );
}


export default Test;
