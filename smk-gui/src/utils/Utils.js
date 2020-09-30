export function convertDate(date){
    var d = new Date(date);
    var day = d.getDate();
    var month = d.getMonth() + 1;
    if (month <= 9){
        month = '0' + month
    }
    var year = d.getFullYear();
    return day + '.' + month + '.' + year
}