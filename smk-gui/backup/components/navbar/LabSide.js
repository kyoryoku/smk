import React, { useEffect, useState } from 'react';


import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import Drawer from "@material-ui/core/Drawer";
import {ExpandLess, ExpandMore} from "@material-ui/icons";
import Collapse from "@material-ui/core/Collapse";
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    nested: {
        paddingLeft: theme.spacing(4),
    },
}));

const LabSide = () => {
    const classes = useStyles();
    const [open1, setOpen1] = useState(false);

    return (
        <div className='lab-nav-side'>
            <Drawer
                variant="permanent"
                anchor="left"
            >

                <List>
                    <ListItem button >
                        <ListItemText primary="111" />
                    </ListItem>
                    <ListItem button >
                        <ListItemText primary="222" />
                    </ListItem>
                    <ListItem button >
                        <ListItemText primary="333" />
                    </ListItem>

                    <ListItem button onClick={setOpen1()}>
                        <ListItemText primary="Inbox" />
                        {
                            open1 ?  <ExpandLess /> : <ExpandMore />
                        }
                    </ListItem>
                    <Collapse in={open1}  timeout="auto" unmountOnExit>
                        <List disablePadding>
                            <ListItem button className={classes.nested}>
                                <ListItemText primary="Starred" />
                            </ListItem>
                            <ListItem button >
                                <ListItemText primary="Starred" />
                            </ListItem>
                            <ListItem button >
                                <ListItemText primary="Starred" />
                            </ListItem>
                        </List>
                    </Collapse>
                </List>
            </Drawer>

        </div>
    );
}

export default LabSide;