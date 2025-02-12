//Masks
$("#inputPhone").mask("000.000.000.000.000,00", { reverse: true });

function convertToNumber(phoneFormat){
    return phoneFormat.replace(/\./g, '').replace(',', '.');
}

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

//OnLoad
loadstudents();

//Load all students
function loadstudents() {
    for (let std of students) {
        addNewRow(std);
    }
}

//save a student
function save() {

    var std = {
        id: students.length + 1,
        name: document.getElementById("inputName").value,
        email: document.getElementById("inputEmail").value,
        phone: convertToNumber(document.getElementById("inputPhone").value),
        course: document.getElementById("selectCourse").value,
        promotion: document.getElementById("checkBoxPromotion").checked,
        new: document.getElementById("checkBoxNewstudent").checked
    };

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
    var formatter = new Intl.NumberFormat("pt-BR", {
        style: "currency",
        currency: "BRL",
    });

    var phoneNode = document.createTextNode(formatter.format(std.phone));
    newRow.insertCell().appendChild(phoneNode);

    //Insert student course
    var courseNode = document.createTextNode(courses[std.course - 1].name);
    newRow.insertCell().appendChild(courseNode);

    //Insert student options
    var options = "";
    if (std.promotion) {
        options = "<span class='badge bg-success me-1'>P</span>";
    }

    if (std.new) {
        options += "<span class='badge bg-primary'>L</span>";
    }

    cell = newRow.insertCell();
    cell.className="d-none d-md-table-cell";
    cell.innerHTML = options;

}












