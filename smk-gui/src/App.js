import React from 'react';
import NavSide from './components/NavSide'
import NavTop from './components/NavTop'
import Home from './components/Home'
import Test from './components/Test'
import Weather from './components/Weather'
import {Switch, Route} from "react-router-dom";
import {makeStyles} from "@material-ui/core/styles";


const useStyles = makeStyles((theme) => ({
    root:{
        margin: '-10px',
    },
    navTop:{
        position: 'fixed',
        top: '0px',
        left: '0px',
        zIndex: '1',
        width: '100%'
    },
    navSide: {
        position: 'fixed',
        top: '60px',
        left: '0px',
        width: '245px'
    },
    main: {
        marginTop: '80px',
        marginLeft: '250px'
    },

}));



function App() {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <div className={classes.navTop}>
                <NavTop />
            </div>
            <div className={classes.navSide}>
                <NavSide />
            </div>
            <div className={classes.main}>
                <Switch>
                    <Route path='/home' component={Home}/>
                    <Route path='/test' component={Test}/>
                    <Route path='/weather' component={Weather}/>
                </Switch>
            </div>
        </div>
    );
}

export default App
