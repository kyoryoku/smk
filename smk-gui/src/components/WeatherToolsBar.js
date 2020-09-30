import React from "react";
import Button from "@material-ui/core/Button";
import AddBoxOutlinedIcon from "@material-ui/icons/AddBoxOutlined";
import EditOutlinedIcon from "@material-ui/icons/EditOutlined";
import SearchOutlinedIcon from "@material-ui/icons/SearchOutlined";


function addClick(){

}

function WeatherToolsBar() {
    return(
        <div>
            <Button onClick={() => {

            }}>
                <AddBoxOutlinedIcon />
            </Button>
            <Button>
                <EditOutlinedIcon />
            </Button>
            <Button>
                <SearchOutlinedIcon />
            </Button>
        </div>
    )
}

export default WeatherToolsBar