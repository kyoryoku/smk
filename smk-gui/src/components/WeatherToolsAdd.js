import React, {useEffect, useState} from "react";
import Button from "@material-ui/core/Button";
import AddBoxOutlinedIcon from "@material-ui/icons/AddBoxOutlined";
import EditOutlinedIcon from "@material-ui/icons/EditOutlined";
import SearchOutlinedIcon from "@material-ui/icons/SearchOutlined";
import Dialog from "@material-ui/core/Dialog";
import DialogTitle from "@material-ui/core/DialogTitle";
import DialogContent from "@material-ui/core/DialogContent";
import Typography from "@material-ui/core/Typography";
import DialogActions from "@material-ui/core/DialogActions";
import TextField from "@material-ui/core/TextField";
import Box from "@material-ui/core/Box";
import {convertDate} from "../utils/Utils";
import makeStyles from "@material-ui/core/styles/makeStyles";
import FormControl from "@material-ui/core/FormControl";
import InputLabel from "@material-ui/core/InputLabel";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Switch from "@material-ui/core/Switch";

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



function WeatherToolsAdd({ addClick }) {

    let weather = {
        temp: 0,
        hum: 0,
        pres: 0
    }

    const classes = useStyles();
    const [open, setOpen] = useState(false);
    const [errorTemp, setErrorTemp] = useState(false);
    const [errorHum, setErrorHum] = useState(false);
    const [errorPres, setErrorPres] = useState(false);

    const [helperTemp, setHelperTemp] = useState("");
    const [helperHum, setHelperHum] = useState("");
    const [helperPres, setHelperPres] = useState("");

    const [submit, setSubmit] = useState(true);

    const [temperature, setTemperature] = useState(0);
    const [pressure, setPressure] = useState(0);
    const [humidity, setHumidity] = useState(0);


    useEffect(()=>{
        setErrorTemp(false)
        setErrorHum(false)
        setErrorPres(false)
        setSubmit(true)
    },[open])

    useEffect(()=>{

        errorTemp ? setHelperTemp("от 15 до 35 градусов") : setHelperTemp("")
        errorHum ? setHelperHum("от 45 до 85 процентов") : setHelperHum("")
        errorPres ? setHelperPres("от 600 до 800 мм рт.ст.") : setHelperPres("")
        errorTemp || errorHum || errorPres ? setSubmit(false) : setSubmit(true)

    },[errorTemp, errorHum, errorPres])


    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
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

        weather = {
            temp: temperature,
            hum: humidity,
            pres: pressure
        }

        console.log(weather)
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

    return(
        <div>
            <Button onClick={handleClickOpen} style={{width: "50px"}}>
                <AddBoxOutlinedIcon />
            </Button>
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
                            value={convertDate(Date.now())}/>
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