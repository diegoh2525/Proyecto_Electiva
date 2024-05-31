function all() {
    $.ajax({
        url: 'http://localhost:9000/electiva2/api/moduloRol', // Reemplaza con la URL de tu API
        method: 'GET',
        success: function(data) {
            console.log(data); // Imprimir los datos recibidos en la consola para verificar
            // Limpiar el cuerpo de la tabla
            $('#loadData').empty();

            // Iterar sobre los datos y agregar filas a la tabla
            $.each(data, function(index, item) {
                console.log(item); // Imprimir cada objeto para verificar sus propiedades
                if (item.fechaEliminacion == null) {
                    $('#loadData').append(`
                        <tr>
                            <td>${item.moduloId.id}</td>
                            <td>${item.rolId.id}</td>
                            <td>
                                <input type="button" class="btn btn-success" value="Editar" onclick="findById(${item.id})">
                                <input type="button" class="btn btn-warning" value="Eliminar" onclick="deleteLogical(${item.id})">
                            </td>
                        </tr>
                    `);
                }
            });
        },
        error: function(error) {
            console.error('Error al cargar datos desde la API:', error);
        }
    });
}


function findById(id){
    $.ajax({
        url: 'http://localhost:9000/electiva2/api/moduloRol/'+id, // Reemplaza con la URL de tu API
        method: 'GET',
        success: function(data) {
            $("#id").val(data.id);
            $("#moduloId").val(data.moduloId.id);
            $("#rolId").val(data.rolId.id);

            // Cambiar el evento onclick y el valor del botón
            $("#botones input").attr("onclick", "update()").val("Actualizar");

        },
        error: function(error) {
            console.error('Error al cargar datos desde la API:', error);
        }
    });
}

function save() {    
    var nuevoModuloId = parseInt($("#moduloId").val(), 10);
    if (isNaN(nuevoModuloId)) {
        alert('Modulo ID no es un número válido');
        return;
    } 
    var nuevoRolId = parseInt($("#rolId").val(), 10);
    if (isNaN(nuevoRolId)) {
        alert('Rol ID no es un número válido');
        return;
    } 

    // Crear un objeto JSON con los datos
    var jsonData = {
        "moduloId": {
            "id": nuevoModuloId
        },
        "rolId": {
            "id": nuevoRolId
        }
    };

    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:9000/electiva2/api/moduloRol', // Reemplaza con la URL de tu API
        method: 'POST',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function(response) {
            alert('Datos guardados exitosamente: ' + response);
            // Puedes realizar acciones adicionales después de guardar los datos

            // Cargar o actualizar los datos
            all();
            cleanData();
        },
        error: function(error) {
            alert('Error al guardar datos:', error);
        }
    });
}


function update(){
    var nuevoModuloId = parseInt($("#moduloId").val(), 10);
    if (isNaN(nuevoModuloId)) {
        alert('Modulo ID no es un número válido');
        return;
    } 
    var nuevoRolId = parseInt($("#rolId").val(), 10);
    if (isNaN(nuevoRolId)) {
        alert('Rol ID no es un número válido');
        return;
    } 

    // Crear un objeto JSON con los datos
    var jsonData = {
        "moduloId": {
            "id": nuevoModuloId
        },
        "rolId": {
            "id": nuevoRolId
        }
    };

    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:9000/electiva2/api/moduloRol/'+$("#id").val(), // Reemplaza con la URL de tu API
        method: 'PUT',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function(response) {
            alert('Datos se modificaron exitosamente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
            cleanData();
        },
        error: function(error) {
            alert('Error al modificar datos:', error);
        }
    });    
}

function deletePhysical(id){
 
    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:9000/electiva2/api/moduloRol/'+id, // Reemplaza con la URL de tu API
        method: 'DELETE',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        success: function(response) {
            alert('Datos se eliminó exitosamente de manera permanente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
            cleanData();
        },
        error: function(error) {
            alert('Error al eliminar dato:', error);
        }
    });  
}

function deleteLogical(id){
   // Crear un objeto JSON con los datos
    var jsonData = {
    };
    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:9000/electiva2/api/moduloRol/'+id, // Reemplaza con la URL de tu API
        method: 'PUT',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function(response) {
            alert('Dato se eliminó exitosamente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
        },
        error: function(error) {
            alert('Error al eliminar el registro:', error);
        }
    });  
}

function cleanData(){
    $("#id").val("");
    $("#moduloId").val("");
    $("#rolId").val("");
}

