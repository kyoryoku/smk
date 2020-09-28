import React, {useState} from 'react';

import { makeStyles, useTheme } from '@material-ui/core/styles';
import {blue} from "@material-ui/core/colors";
import Box from "@material-ui/core/Box";


const useStyles = makeStyles((theme) => ({
    root:{
        backgroundColor: blue["200"],
        height: "45px"
    }

}));

function NavTop() {

    const classes = useStyles();
    return (
        <div className={classes.root}>
            <Box>
                sadasd
            </Box>

        </div>
    );
}


export default NavTop;
