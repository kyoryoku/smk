import React from "react";
import Button from "@material-ui/core/Button";
import AddBoxOutlinedIcon from "@material-ui/icons/AddBoxOutlined";
import EditOutlinedIcon from "@material-ui/icons/EditOutlined";
import SearchOutlinedIcon from "@material-ui/icons/SearchOutlined";




function WeatherToolsBar({ addClick, editClick, searchClick }) {

    return(
        <div>
            <Button onClick={() => {
                addClick()
            }}>
                <AddBoxOutlinedIcon />
            </Button>
            <Button onClick={() => {
                editClick()
            }}>
                <EditOutlinedIcon />
            </Button>
            <Button onClick={ () => {
                searchClick()
            }}>
                <SearchOutlinedIcon />
            </Button>
        </div>
    )
}

export default WeatherToolsBar