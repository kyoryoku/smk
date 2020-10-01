export function convertDate(date){
    let d = new Date(date);

    let day = d.getDate();
    if (day <= 9){
        day = '0' + day;
    }
    let month = d.getMonth() + 1;
    if (month <= 9){
        month = '0' + month;
    }
    let year = d.getFullYear();
    return day + '.' + month + '.' + year;
}