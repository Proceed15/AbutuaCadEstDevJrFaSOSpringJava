//Masks
/*
$("#inputPhone").mask("000.000.000.000.000,00", { reverse: true });

function convertToNumber(phoneFormat){
    return phoneFormat.replace(/\./g, '').replace(',', '.');
}
    */
var students = [];
var course = [];
/*
var students = [
    {
        id: 1,
        name: "Computador M1-TX",
        email: "Intel I7, 16GB, SSD 256, HD 1T",
        phone: 4900,
        course: 1,
        promotion: true,
        new: true
    },
    {
        id: 2,
        name: "Computador M2-TX",
        email: "Intel I7, 32GB, SSD 512, HD 1T",
        phone: 5900,
        course: 2,
        promotion: false,
        new: true
    },
    {
        id: 3,
        name: "Computador M1-T",
        email: "Intel I5, 16GB, HD 1T",
        phone: 2900,
        course: 3,
        promotion: false,
        new: false
    },
];

var courses = [
    { id: 1, name: "Produção Própria" },
    { id: 2, name: "Nacional" },
    { id: 3, name: "Importado" }
];
*/

//OnLoad
loadStudents();
loadCourses();

//Load all Courses
function loadCourses(){
    //Requisição e Respostas
    $.ajax({url:"http://localhost:8080/courses",
        type: "GET",
        async: false,
        success: (response) => {
            courses = response;
            for (var css of courses) {
                //Mostra as Opções do Escolha pelo id, aparecendo 1:1 para cada id e curso, 1 opção por curso
                document.getElementById("selectCourse").innerHTML += `<option value=${css.id}>${css.name}</option>`;
            }
        }
    })
}

//Load all Students
function loadStudents() {
    $.getJSON("http://localhost:8080/students", (response) => {
        students = response;
        for (let std of response) {
            addNewRow(std);
        }
    });
}

//Save a New Student
function save() {
    var std = {
        id: students.length + 1,
        name: document.getElementById("inputName").value,
        email: document.getElementById("inputEmail").value,
        phone: document.getElementById("inputPhone").value,
        course: document.getElementById("selectCourse").value,
        period: document.getElementById("InformPeriod").value
        /*
        promotion: document.getElementById("checkBoxPromotion").checked,
        new: document.getElementById("checkBoxNewstudent").checked
        */
    };



    //Ajustando a função Save para se adequar ao corpo da requisição via Http
    $.ajax({url:"http://localhost:8080/students", 
    type: "POST", 
    async: false, 
    contentType: 'application/json; charset=utf-8', 
    dataType: 'json', data: JSON.stringify(std), 
    success: (student) => { addNewRow(student); students.push(student); document.getElementById("formStudent").reset();},});
    //Add new Row
    addNewRow(std);
    students.push(std);

    document.getElementById("formStudent").reset();

}


//Add new Row
function addNewRow(std) {
    var table = document.getElementById("studentsTable");

    var newRow = table.insertRow();

    //Insert student id
    var idNode = document.createTextNode(std.id);
    newRow.insertCell().appendChild(idNode);

    //Insert student name
    var nameNode = document.createTextNode(std.name);
    newRow.insertCell().appendChild(nameNode);

    //Insert student email
    var emailNode = document.createTextNode(std.email);
    var cell = newRow.insertCell();
    cell.className="d-none d-md-table-cell";
    cell.appendChild(emailNode);

    //Insert student phone
    /*
    var formatter = new Intl.NumberFormat("pt-BR", {
        style: "currency",
        currency: "BRL",
    });
    */
    //formatter.format(std.phone)
    var phoneNode = document.createTextNode(std.phone);
    newRow.insertCell().appendChild(phoneNode);

    //Insert student course name
    var courseNode = document.createTextNode(courses[std.idCourse - 1].name);
    newRow.insertCell().appendChild(courseNode);

    //Informing the Period
    var periodNode = document.createTextNode(std.period);
    newRow.insertCell().appendChild(periodNode);

    //Insert student course number of classes
    var cssClassesNode = document.createTextNode(courses[std.idCourse - 1].classes);
    newRow.insertCell().appendChild(cssClassesNode);

    //Insert student options
    /*
    var options = "";
    if (std.promotion) {
        options = "<span class='badge bg-success me-1'>P</span>";
    }

    if (std.new) {
        options += "<span class='badge bg-primary'>L</span>";
    }
    */

    //Criação de nova Célula na Tabela de Estudantes
    cell = newRow.insertCell();
    cell.className="d-none d-md-table-cell";
    //cell.innerHTML = options;

}












