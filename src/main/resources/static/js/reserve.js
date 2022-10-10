const output = document.getElementById("content")

fetch("http://localhost:8081/available", {
    method: "POST",
    headers: {
        'Content-type': "application/json"
    },
    body: JSON.stringify({
        index: 1
    })
})
.then((res)=> {
    res.json().then((data)=>{
        output.innerHTML=""
        data.forEach((card)=>{
            console.log(card)
             output.innerHTML+= `<div class="card">
                <p> Floor: ${card.floor} </p>
                <p> Available: ${card.available} </p>
                <p> Room Number: ${card.number} </p>
                <p> Information: ${card.information} </p>
                <button id=${card.number} class="book">Book</button>
             </div>`
        })

             document.querySelectorAll(".book").forEach((item)=>{
                item.addEventListener("click",(e)=>{reserve(e)})
             })
    })
})
.catch((e)=>{
    alert("something went wrong")
})

function reserve(event){
//    console.log(event.target.id)
    window.location.href=`/reserve?room=${event.target.id}`
}