function callProcedure(event, form){
    fetch(form.action,{
        method: "POST",
        body: new FormData(form)
    }).then((response) => {
        if (response.ok) {
            successToast();
            return response.text()
        } else {
            errorToast();
        }
    }).then((data)=>writeResponse(data))
    event.preventDefault();
}

function writeResponse(response){
    let result = document.getElementById("response")
    if (response!==undefined){
        result.innerHTML = response
    }else{
        result.innerHTML = "Cédula no registrada"
    }
}

const successToast = () => {
    let toastLiveExample = document.getElementById("successToast")
    new bootstrap.Toast(toastLiveExample).show()
    writeResponse()
}

const errorToast = () => {
    let toastLiveExample = document.getElementById("errorToast")
    let toast = new bootstrap.Toast(toastLiveExample)
    toast.show()
}