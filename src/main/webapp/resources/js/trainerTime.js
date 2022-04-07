const selectName = document.getElementById("selectName");

console.log("1")

selectName.addEventListener(click,function(event){
    console.log("d")
    if(event.target.classList.contains("optionName")){
        console.log("변경");
    }
})