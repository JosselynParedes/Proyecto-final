var $table = $('#table');
var $tableS = $('#tableS');
let idtoDel = 0;

function operations() {
    return [
        `<button type='button'
            class='btn btn-warning actionBtn' 
            data-bs-toggle='modal' 
            data-bs-target='#upDate'
            onclick="getUpdateData(this)">
            Actualizar
    </button>
    <button 
            type='button' 
            class='btn btn-danger actionBtn'
             data-bs-toggle="modal" 
             data-bs-target="#delete"
            onclick="delButton(this)">
            Eliminar
    </button>`
    ];
}

function operationsSubjects() {
    return [
        `<button type='button'
            class='btn btn-warning actionBtn' 
            data-bs-toggle='modal' 
            data-bs-target='#upDateS'
            onclick="getUpdateDataS(this)">
            Actualizar
    </button>
    <button 
            type='button' 
            class='btn btn-danger actionBtn'
             data-bs-toggle="modal" 
             data-bs-target="#deleteS"
            onclick="delButton(this)">
            Eliminar
    </button>`
    ];
}

function doPost(event, form) {
    fetch(form.action, {
        method: "POST",
        body: new FormData(form)
    }).then((response) => {
        if (response.ok) {
            successToast();
        } else {
            errorToast();
        }
    });
    event.preventDefault();
    document.getElementById('closeInsert').click();
    document.getElementById('closeInsertS').click();
}

function doPut(event, form) {
    fetch(form.action, {
        method: "PUT",
        body: new FormData(form)
    }).then((response) => {
        if (response.ok) {
            successToast();
        } else {
            errorToast();
        }
    });
    event.preventDefault();
    document.getElementById('CloseUp').click();
    document.getElementById('CloseUpS').click();
}

function doDelete(id) {
    fetch(`./students?nui=${id}`, {
        method: "DELETE"
    }).then((response) => {
        if (response.ok) {
            successToast();
        } else {
            alert("registro no eliminada");
        }
    });
    document.getElementById('closeDelete').click();
}

function doDeleteT(id) {
    fetch(`./teachers?nui=${id}`, {
        method: "DELETE"
    }).then((response) => {
        if (response.ok) {
            successToast();
        } else {
            alert("registro no eliminada");
        }
    });
    document.getElementById('closeDelete').click();
}

function doDeleteC(id) {
    fetch(`./careers?idCareers=${id}`, {
        method: "DELETE"
    }).then((response) => {
        if (response.ok) {
            successToast();
        } else {
            errorToast();
        }
    });
    document.getElementById('closeDelete').click();
}

function doDeleteS(id) {
    fetch(`./subjects?idSubjects=${id}`, {
        method: "DELETE"
    }).then((response) => {
        if (response.ok) {
            successToast();
        } else {
            errorToast();
        }
    });
    document.getElementById('closeDeleteS').click();
}

function delButton(e) {
    idtoDel = e.parentElement.parentElement.querySelector("td").innerHTML;
}

const getUpdateData = (e) => {
  let updateData = e.parentElement.parentElement.getElementsByTagName("td");
  let uForm = document
    .getElementById("upDate")
    .getElementsByClassName("form-control");
  for (let i = 0; i < updateData.length - 1; i++) {
    uForm[i].value = updateData[i].innerHTML;
  }  
}

const getUpdateDataS = (e) => {
  let updateData = e.parentElement.parentElement.getElementsByTagName("td");
  let uForm = document
    .getElementById("upDateS")
    .getElementsByClassName("form-control");
  for (let i = 0; i < updateData.length - 1; i++) {
    uForm[i].value = updateData[i].innerHTML;
  }  
}

const successToast = () => {
    let toastLiveExample = document.getElementById("successToast")
    new bootstrap.Toast(toastLiveExample).show()
    $("#table").bootstrapTable("refresh")
    $("#tableS").bootstrapTable("refresh")
    $(".modal").modal("hide")
    writeTables()
}

const errorToast = () => {
    let toastLiveExample = document.getElementById("errorToast")
    let toast = new bootstrap.Toast(toastLiveExample)
    toast.show()
}

function detailFormatter(index, row) {
    var html = []
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>')
    })
    return html.join('')
}