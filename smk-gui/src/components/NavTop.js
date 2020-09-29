import React from 'react';

import { makeStyles } from '@material-ui/core/styles';
import {blue} from "@material-ui/core/colors";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import logo from '../images/logo.png'
import {useHistory} from 'react-router-dom'


const useStyles = makeStyles((theme) => ({
    root:{
        backgroundColor: blue["200"],
        display: 'flex',
        alignItems: 'center',
    },
    logo: {
        height: '50px',
        width: '50px'
    },
    softname: {
        flexGrow: 1,
        paddingLeft: '10px'
    },
    username: {

    }

}));

function NavTop() {

    const classes = useStyles();
    const history = useHistory();

    return (
        <Box p={1} className={classes.root}>
            <img src={logo} alt="11" className={classes.logo} onClick={() => history.push('/home')}/>

            <Typography className={classes.softname} variant='h5'>
                СМК ИЛ НИИ ТЗИ
            </Typography>
            <Button>
                <Typography variant='button' >
                    username (user@mail.lab)
                </Typography>
            </Button>
        </Box>
    );
}


export default NavTop;
