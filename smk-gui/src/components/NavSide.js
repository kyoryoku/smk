import React, {useState} from 'react';

import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import { makeStyles } from '@material-ui/core/styles';
import Collapse from "@material-ui/core/Collapse";
import {ExpandLess, ExpandMore} from "@material-ui/icons";
import {useHistory} from 'react-router-dom'


const useStyles = makeStyles((theme) => ({
    subItem: {
        paddingLeft: theme.spacing(4)
    },

}));

function NavSide() {

    const classes = useStyles();
    const history = useHistory();
    const [collapse1, setCollapse1] = useState(false);
    const [collapse2, setCollapse2] = useState(false);
    const [collapse3, setCollapse3] = useState(false);

    return (
        <div>
            <List>
                <ListItem
                    button
                    onClick={() => {setCollapse1(!collapse1)}}
                >
                    <ListItemText primary="Журналы 1" />
                    {
                        collapse1 ?  <ExpandLess /> : <ExpandMore />
                    }
                </ListItem>

                <Collapse in={collapse1}  timeout={50} >
                    <List disablePadding>

                        <ListItem
                            button
                            className={classes.subItem}
                            onClick={() => {history.push('/test')}}
                        >
                            <ListItemText primary="TEST page" />
                        </ListItem>

                        <ListItem
                            button
                            className={classes.subItem}
                            onClick={() => {history.push('/home')}}
                        >
                            <ListItemText primary="Home page" />
                        </ListItem>

                        <ListItem
                            button
                            className={classes.subItem}
                            onClick={() => {history.push('/weather')}}
                        >
                            <ListItemText primary="Журнал погоды" />
                        </ListItem>

                    </List>
                </Collapse>



                <ListItem button onClick={() => {setCollapse2(!collapse2)}} >
                    <ListItemText primary="Меню 2" />
                    {
                        collapse2 ?  <ExpandLess /> : <ExpandMore />
                    }
                </ListItem>
                <Collapse in={collapse2}  timeout={50} >
                    <List disablePadding>
                        <ListItem button className={classes.subItem} >
                            <ListItemText primary="Меню 2 1" />
                        </ListItem>

                        <ListItem button className={classes.subItem} >
                            <ListItemText primary="Меню 2 2" />
                        </ListItem>

                        <ListItem button className={classes.subItem} >
                            <ListItemText primary="Меню 2 3" />
                        </ListItem>

                    </List>
                </Collapse>


                <ListItem button onClick={() => {setCollapse3(!collapse3)}}>
                    <ListItemText primary="Меню 3" />
                    {
                        collapse3 ?  <ExpandLess /> : <ExpandMore />
                    }
                </ListItem>
                <Collapse in={collapse3}  timeout={50} >
                    <List disablePadding>

                        <ListItem button className={classes.subItem} >
                            <ListItemText primary="Меню 3 1" />
                        </ListItem>

                        <ListItem button className={classes.subItem}>
                            <ListItemText primary="Меню 3 2" />
                        </ListItem>

                        <ListItem button className={classes.subItem} >
                            <ListItemText primary="Меню 3 3" />
                        </ListItem>
                    </List>
                </Collapse>


                <ListItem button >
                    <ListItemText primary="Меню 4" />
                </ListItem>
            </List>
        </div>
    );
}


export default NavSide;
