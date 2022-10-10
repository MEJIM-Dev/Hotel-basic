const email = document.getElementById("email")
const firstname = document.getElementById("firstname")
const lastname = document.getElementById("lastname")
const mobile = document.getElementById("mobile")
const roomno = document.getElementById("roomno")
const checkin = document.getElementById("checkin")
const checkout = document.getElementById("checkout")
//const msg = document.getElementById("msg")

const msg= (status, msg) =>{
    if(status=="success"){
        document.getElementById("msg").classList.toggle("success")
        document.getElementById("msg").innerHTML= `<div class="msg-con">
                <p> ${msg}</p>
            </div>`

        setTimeout(()=>{
            document.getElementById("msg").innerHTML=""
            document.getElementById("msg").classList.toggle("success")
        }, 5000)
        return
    }

    document.getElementById("msg").classList.toggle("fail")
    document.getElementById("msg").innerHTML= `<div class="msg-con">
                    <p> ${msg} </p>
                </div>`

    setTimeout(()=>{
        document.getElementById("msg").innerHTML=""
        document.getElementById("msg").classList.toggle("fail")
    }, 5000)
}

document.getElementById("sub").addEventListener("click", (e)=>{
    e.preventDefault()

    console.log(checkin.value)

    fetch("http://localhost:8081/reserve",{
        method: "POST",
        headers: {
            'Content-type': "application/json",
        },
        body: JSON.stringify({
            email: email.value,
            firstname: firstname.value,
            lastname: lastname.value,
            roomno: roomno.value,
            mobile: mobile.value,
            checkin: checkin.value,
            checkout: checkout.value,
        })
    })
    .then((data)=>{
        if(data.status==200||data.status==201){
            msg("success", "Room booked successfully")
            return data.json()
        }
        data.text().then((d)=>
        msg("fail", d)
        )
    })
    .then((data)=>{
        console.log(data)
    })
    .catch((e)=>{ msg("fail", "Server failed to respond")})

})

//
//document.innerHTML="<p>deez</p>"
//document.querySelector(".form").innerHTML= `<div id="msg" class="msg fail active">
//                <div class="msg-con">
//                    <p> ${msg} </p>
//                </div>
//          </div>`