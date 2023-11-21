const submitted = document.getElementById("submitted");
const resultID = document.getElementById("resultID");
const employeeForm = document.getElementById("employee-form");



function form(){

    const formData = new FormData(employeeForm);
    
    fetch("/employee", {

        method: "POST",
        body: formData,

    }).then(response => {
        if(response.ok){
            submit();
        }
        
    })
}

function submit(){
   
    resultID.style.display = 'block';

}

submitted.addEventListener('click', function(e){
    e.preventDefault();
    form();
})


window.addEventListener("load", function() {
    resultID.style.display = 'none';
});