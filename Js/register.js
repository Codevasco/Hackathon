$("#register-btn").onclick = function() {

    $.ajax({
        url: 'http://localhost:8080/vidaloca/kingofthehill/user/add',
        type: 'POST',
        data: JSON.stringify({
            firstName: $('#name').val(),
            phone: $('#phone').val()
        }),
        async: true,
        contentType: 'application/json',
        success: setup,
        error: errors,
    });

}

function setup () {
    location.reload();
}

function errors() {
    console.log("Error");
}

