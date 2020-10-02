import React, {useEffect, useState} from 'react';

import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import API from "../utils/API";
import Backdrop from "@material-ui/core/Backdrop";
import CircularProgress from "@material-ui/core/CircularProgress";
import Box from "@material-ui/core/Box";
import { convertDate } from '../utils/Utils'
import WeatherToolsBar from "./WeatherToolsBar";
import WeatherToolsAdd from "./WeatherToolsAdd";


const useStyles = makeStyles((theme) => ({
    root:{

    },
    table: {
        minWidth: 500,
        width: 600,
    },
    backdrop: {
        zIndex: 90,
        color: '#fff',
    },
}));

function Home() {

    const classes = useStyles();
    const [wd, setWd] = useState([]);
    const [showBackDrop, setShowBackDrop] = useState(true);
    const [refresh, setRefresh] = useState(true);

    useEffect(() => {
        const fetchData = async () => {
            const result = await API.get('/weather');

            if (result.status === 200){
                setWd(result.data.reverse());
                setShowBackDrop(false);
            }
        };

        fetchData();
    }, [refresh])

    const addClick = () => {
        setRefresh(true)
    }


    return (
        <Box className={classes.root}>
            <WeatherToolsAdd addClick={addClick} />

            <TableContainer component={Paper}>
                <Table className={classes.table} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="center">Дата</TableCell>
                            <TableCell align="center">Температура</TableCell>
                            <TableCell align="center">Влажность</TableCell>
                            <TableCell align="center">Давление</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {wd.map((row) => (
                            <TableRow key={row.id}>
                                <TableCell align="center">{convertDate(row.date)}</TableCell>
                                <TableCell align="center">{row.temp}</TableCell>
                                <TableCell align="center">{row.pres}</TableCell>
                                <TableCell align="center">{row.hum}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>



            <Backdrop open={showBackDrop} className={classes.backdrop}>
                <CircularProgress color="inherit" />
            </Backdrop>
        </Box>
    );
}


export default Home;
