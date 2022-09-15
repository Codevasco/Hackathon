window.onload = function () {

    var usersTable = document.getElementById('guestTable')

    var row = usersTable.insertRow(-1);

    row.innerHTML = "<td>" + customerData[0].User + "</td>";
    row.innerHTML += "<td>" + customerData[0].Rating + "</td>";

}
