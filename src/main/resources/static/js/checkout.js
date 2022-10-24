const subBtn = document.getElementById("sub")
const referenceId = document.getElementById("reference")

subBtn.addEventListener("click",(e)=>{
    e.preventDefault();

    fetch("http://localhost:8081/api/checkout",{
        method: "POST",
        headers: {
            'Content-type': "application/json",
        },
        body: JSON.stringify({
            reference: referenceId.value
        })
    })
    .then((res)=>{
        if(res.status==200){
            return alert("Successfully Checked out")
        }
        return alert("Failed to checkout")
    })
    .catch((e)=>{
        alert("500 Error")
    })
})
