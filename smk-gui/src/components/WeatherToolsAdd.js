import React, {useEffect, useState} from "react";
import makeStyles from "@material-ui/core/styles/makeStyles";

import Button from "@material-ui/core/Button";
import AddBoxOutlinedIcon from "@material-ui/icons/AddBoxOutlined";
import Dialog from "@material-ui/core/Dialog";
import DialogTitle from "@material-ui/core/DialogTitle";
import DialogContent from "@material-ui/core/DialogContent";
import DialogActions from "@material-ui/core/DialogActions";
import TextField from "@material-ui/core/TextField";
import MuiAlert from '@material-ui/lab/Alert';


import {convertDate} from "../utils/Utils";
import API from "../utils/API";
import Snackbar from "@material-ui/core/Snackbar";

const useStyles = makeStyles((theme) => ({
    root: {
    },
    form: {
        display: 'flex',
        flexDirection: 'column',
        margin: 'auto',
        width: '350px'
    },
}));

function Alert(props) {
    return <MuiAlert elevation={6} variant="filled" {...props} />;
}

function WeatherToolsAdd({ addClick }) {

    const classes = useStyles();
    const [open, setOpen] = useState(false);
    const [alertOpen, setAlertOpen] = useState(false)
    const [complete, setComplete] = useState(false);
    const [errorTemp, setErrorTemp] = useState(false);
    const [errorHum, setErrorHum] = useState(false);
    const [errorPres, setErrorPres] = useState(false);

    const [helperTemp, setHelperTemp] = useState(" ");
    const [helperHum, setHelperHum] = useState(" ");
    const [helperPres, setHelperPres] = useState(" ");

    const [submit, setSubmit] = useState(false);

    const [temperature, setTemperature] = useState(0);
    const [pressure, setPressure] = useState(0);
    const [humidity, setHumidity] = useState(0);

    useEffect(()=>{
        setErrorTemp(false)
        setErrorHum(false)
        setErrorPres(false)
        setSubmit(false)
        setTemperature(0)
        setHumidity(0)
        setPressure(0)
    },[open])

    useEffect(()=>{
        errorTemp ? setHelperTemp("от 15 до 35 градусов") : setHelperTemp(" ")
        errorHum ? setHelperHum("от 45 до 85 процентов") : setHelperHum(" ")
        errorPres ? setHelperPres("от 600 до 800 мм рт.ст.") : setHelperPres(" ")

        errorTemp || errorHum || errorPres ? setSubmit(false) : setSubmit(true)
    },[errorTemp, errorHum, errorPres])

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
        setComplete(false);
    };

    const alertClose = () => {
        setAlertOpen(false);
    };

    const handleSubmit = e => {
        e.preventDefault();

        if (temperature === 0){
            setErrorTemp(true);
        }

        if(humidity === 0){
            setErrorHum(true);
        }

        if (pressure === 0){
            setErrorPres(true);
        }

        if (temperature !== 0
            && humidity !== 0
            && pressure !== 0)
        {
            API.post('/weather', {
                temp: temperature.toString(),
                hum: humidity.toString(),
                pres: pressure.toString()
            }).then(() =>{
                handleClose()
                setComplete(true)
                setAlertOpen(true)
                addClick()
            });
        } else {
            setComplete(false)
            setAlertOpen(true)
        }


    };

    const onChangeTemp = e => {
        const v = Number(e);
        if (isNaN(v) || v < 15 || v > 35 ){
            setErrorTemp(true);
        } else {
            setTemperature(v);
            setErrorTemp(false)
        }
    }

    const onChangePres = e => {
        const v = Number(e);
        if (isNaN(v) || v < 600 || v > 800 ){
            setErrorPres(true);
        } else {
            setPressure(v)
            setErrorPres(false)
        }
    }

    const onChangeHum = e => {
        const v = Number(e);
        if (isNaN(v) || v < 45 || v > 85 ){
            setErrorHum(true);
        } else {
            setHumidity(v)
            setErrorHum(false)
        }
    }

    const aler = complete ?
        <Alert onClose={alertClose} severity="success">
            Добавлено
        </Alert>
        :
        <Alert onClose={alertClose} severity="error">
            Не добавлено
        </Alert>




    return(
        <div>
            <Button onClick={handleClickOpen} style={{width: "50px"}}>
                <AddBoxOutlinedIcon />
            </Button>
            <Snackbar open={alertOpen} autoHideDuration={6000} onClose={alertClose}>
                {aler}
            </Snackbar>
            <Dialog
                onClose={handleClose}
                open={open}
                disableBackdropClick
                disableEscapeKeyDown>
                <DialogTitle>
                    Добавить данные в журнал
                </DialogTitle>
                <DialogContent>
                    <form
                        className={classes.form}
                        id="myform"
                        noValidate
                        autoComplete="off"
                        action='/'
                        method='POST'
                        onSubmit={handleSubmit}>
                        <TextField
                            label="Дата"
                            value={convertDate(Date.now())}
                            helperText={" "}/>
                        <TextField
                            label="Температура"
                            style={{marginTop: '15px'}}
                            helperText={helperTemp}
                            onChange={e => {onChangeTemp(e.target.value)}}
                            error={errorTemp}/>
                        <TextField
                            label="Влажность"
                            style={{marginTop: '15px'}}
                            helperText={helperHum}
                            onChange={e => {onChangeHum(e.target.value)}}
                            error={errorHum}/>
                        <TextField
                            label="Давление"
                            style={{marginTop: '15px', marginBottom: '15px' }}
                            helperText={helperPres}
                            onChange={e => {onChangePres(e.target.value)}}
                            error={errorPres}/>
                    </form>
                </DialogContent>
                <DialogActions>
                    <Button
                        autoFocus
                        type="submit"
                        form="myform"
                        color="primary"
                        size="small"
                        disabled={!submit}>
                        Добавить
                    </Button>
                    <Button
                        color="secondary"
                        size="small"
                        onClick={handleClose}>
                        Закрыть
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    )
}

export default WeatherToolsAdd