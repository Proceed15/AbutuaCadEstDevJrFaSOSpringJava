//Masks
$("#inputPrice").mask("000.000.000.000.000,00", { reverse: true });

function convertToNumber(priceFormat){
    return priceFormat.replace(/\./g, '').replace(',', '.');
}

var students = [
    {
        id: 1,
        name: "Computador M1-TX",
        description: "Intel I7, 16GB, SSD 256, HD 1T",
        price: 4900,
        course: 1,
        promotion: true,
        new: true
    },
    {
        id: 2,
        name: "Computador M2-TX",
        description: "Intel I7, 32GB, SSD 512, HD 1T",
        price: 5900,
        course: 2,
        promotion: false,
        new: true
    },
    {
        id: 3,
        name: "Computador M1-T",
        description: "Intel I5, 16GB, HD 1T",
        price: 2900,
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

//save a stduct
function save() {

    var std = {
        id: students.length + 1,
        name: document.getElementById("inputName").value,
        description: document.getElementById("inputDescription").value,
        price: convertToNumber(document.getElementById("inputPrice").value),
        course: document.getElementById("selectcourse").value,
        promotion: document.getElementById("checkBoxPromotion").checked,
        new: document.getElementById("checkBoxNewstduct").checked
    };

    addNewRow(std);
    students.push(std);

    document.getElementById("formStudent").reset();

}


//Add new Row
function addNewRow(std) {
    var table = document.getElementById("studentsTable");

    var newRow = table.insertRow();

    //Insert stduct id
    var idNode = document.createTextNode(std.id);
    newRow.insertCell().appendChild(idNode);

    //Insert stduct name
    var nameNode = document.createTextNode(std.name);
    newRow.insertCell().appendChild(nameNode);

    //Insert stduct description
    var descriptionNode = document.createTextNode(std.description);
    var cell = newRow.insertCell();
    cell.className="d-none d-md-table-cell";
    cell.appendChild(descriptionNode);

    //Insert stduct price
    var formatter = new Intl.NumberFormat("pt-BR", {
        style: "currency",
        currency: "BRL",
    });

    var priceNode = document.createTextNode(formatter.format(std.price));
    newRow.insertCell().appendChild(priceNode);

    //Insert stduct course
    var courseNode = document.createTextNode(courses[std.course - 1].name);
    newRow.insertCell().appendChild(courseNode);

    //Insert stduct options
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












