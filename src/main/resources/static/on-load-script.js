function getResult(){
    fetch("/employee-result")
    .then(data => {
      return data.json();
    })
    .then(employee => {
       const employeeList = document.getElementById("container");
       employee.forEach(employees => {

            //Elememts
            const employeeCard = document.createElement("div");
            const employeeCompany = document.createElement("p");
            const employeeName = document.createElement("p");
            const employeeRole = document.createElement("p");
            const employeeAge = document.createElement("p");
         
            const employeeImg = document.createElement("img");

           


            //Classes
            employeeCard.classList.add("cardContainer");
            employeeName.classList.add("bigFont");
       
            
         

            //Employee Info
            employeeCompany.innerHTML = employees.companyName;
            employeeName.innerHTML = employees.firstName + " " + employees.lastName;
            employeeRole.innerHTML = employees.role;
            employeeAge.innerHTML = "Age: " + employees.age;
            employeeImg.src = employees.image;
            employeeImg.alt = "Employee Image";
            
            //Employee Card append
            employeeCard.append(employeeName, employeeCompany, employeeRole, employeeAge, employeeImg);
            employeeList.appendChild(employeeCard);
       });
    })
    .catch(error => {
        console.log(error);
    });
}

window.addEventListener("load", getResult);