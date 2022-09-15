window.onload = function () {

    var challengeData = [
        {"Challenge":"Drink 20 shots"},
        {"Challenge":"Handstand chug a barril"},
        {"Challenge":"Get in a coma"},
        {"Challenge":"Die"}
        ];

    var guestData = [
        {"Guest":"Tobias"},
        {"Guest":"António"},
        {"Guest":"Murcão"},
        {"Guest":"Visconde Venâncio"}
        ];


        for (let i = 0; i < challengeData.length; i++) {
        
            var challengeTable = document.getElementById('Table3')
            var row3 = challengeTable.insertRow(-1);
            row3.innerHTML += "<td>" + guestData[i].Guest + "</td>";
            row3.innerHTML += '<td><a class="btn btn-primary" th:href="@{}">Rate</a></td>';
        }
    }
        
