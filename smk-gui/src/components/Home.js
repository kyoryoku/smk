import React from 'react';

import { makeStyles } from '@material-ui/core/styles';
import {red} from "@material-ui/core/colors";



const useStyles = makeStyles((theme) => ({
    root:{
        backgroundColor: red["200"],
        height: '2000px'
    },
}));

function Home() {

    const classes = useStyles();
    return (
        <div className={classes.root}>
            HOME PAGE
        </div>
    );
}


export default Home;
