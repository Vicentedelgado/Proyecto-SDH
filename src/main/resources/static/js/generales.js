/**
 * GENERALES JS
 */

/*Cambio de color según prioridad en tabal general de bienes*/
$(function() {
	$("table td:nth-child(12):contains(Baja)")
		.parents("tr")
	    .css("background-color", "#d5e8d4");
	 
		 $("table td:nth-child(12):contains(Media)")
	    .parents("tr")
	    .css("background-color", "#fff2cc");
	 
		 $("table td:nth-child(12):contains(Alta)")
	    .parents("tr")
	    .css("background-color", "#f8cecc");
});
$(function() {
	$("table td:nth-child(11):contains(Baja)")
		.parents("tr")
	    .css("background-color", "#d5e8d4");
	 
		 $("table td:nth-child(11):contains(Media)")
	    .parents("tr")
	    .css("background-color", "#fff2cc");
	 
		 $("table td:nth-child(11):contains(Alta)")
	    .parents("tr")
	    .css("background-color", "#f8cecc");
});
//////////////////////////////////////////////////REGISTRO DEL SPI///////////////////////////
//función select dinámico página registro del spi por tipo
$('#filtrarportipo').change(
        function() {
			var loc = window.location;
        	var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
        	var pageurl = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
			$.getJSON(pageurl+"Elegiractivo", {
                idtipo : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un bien/servicio.. </option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idactivo + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idactivo').html(html);
        });
});


//función select dinámico página rrhh 1 modal save
$('#spiporzona').change(
        function() {
			var loc = window.location;
        	var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
        	var pageurl = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
			$.getJSON(pageurl+"Elegirspi", {
                idzona : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un SPI.. </option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idspi + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#spiid').html(html);
        });
});

//función obtener value spi para filtrado en página general modal save

///////////////////////////////////////////////////RRHH//////////////////////////////

//función select dinámico página rrhh 2 modal edit
$('#idzona1').change(
        function() {
			var loc = window.location;
        	var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
        	var pageurl = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
			$.getJSON(pageurl+"Elegirspi", {
                idzona : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un SPI.. </option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idspi + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idspi1').html(html);
        });
});

//función select dinámico página rrhh filtrar 
$('#idzonafiltrar').change(
      function() {
			var loc = window.location;
        	var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
        	var pageurl = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
			$.getJSON(pageurl+"Elegirspi", {
              idzona : $(this).val(),
              ajax : 'true'
          }, function(data) {
              var html = '<option value="">Seleccionar un SPI.. </option>';
              var len = data.length;
              for ( var i = 0; i < len; i++) {
                  html += '<option value="' + data[i].idspi + '">'
                          + data[i].nombre + '</option>';
              }
              html += '</option>';
              $('#idspifiltrar').html(html);
      });
});

//función obtener value spi para filtrado en página RRHH por SPI
$(document).ready(function(){
	$("#idspifiltrar").change(function(){
		var spiValue = $(this).children('option:selected').val();
		$('#filtrarform').attr('action', $('#baseURL').val() + spiValue);
	});
});


/////////////////////////////////////////////////////////////////////COMPARTIDO//////////////////////////
//limpiar form guardar
$('#saveModal').on('show.bs.modal', function (event) {
	var dtToday = new Date();
	var year = dtToday.getFullYear();
    $("#saveModal input").val('');
    $("#archivo2").val('vacio_sdh.pdf');
    $("#saveModal select").val("");
    $("#saveModal textarea").val('');
    $("#saveModal small").val('');
    $("#periodo").val(year);
    $("#Guardar").val("Guardar");
});

$('#saveModalRRHHporSpi').on('show.bs.modal', function (event) {
    $("#saveModalRRHHporSpi input").val('');
    $("#saveModalRRHHporSpi select").val("");
    $("#saveModalRRHHporSpi textarea").val('');
    $("#saveModalRRHHporSpi small").val('');
    $("#idzona14").val(document.getElementById("idzona13").value);
    $("#idspi14").val(document.getElementById("idspi13").value);
    $("#Guardar").val("Guardar");
});

$('#saveModalActivo').on('show.bs.modal', function (event) {
	$("#saveModalActivo input").val('');
	$("#saveModalActivo select").val("");
	$("#saveModalActivo textarea").val('');
    $("#Guardaractivo").val("Guardar");
});

$('#saveinstitucionModal').on('show.bs.modal', function (event) {
	$("#saveinstitucionModal input").val('');
    $("#GuardarInstitucion").val("Guardar");
});

$('#saveuserModal').on('show.bs.modal', function (event) {
	$("#saveuserModal input").val('');
	$("#enabled1").val("1");
	$("#saveuserModal select").val("");
    $("#GuardarUser").val("Guardar");
});

$('#saverolModal').on('show.bs.modal', function (event) {
	$("#saverolModal input").val('');
	$("#saverolModal select").val("");
    $("#GuardarRol").val("Guardar");
});
$('#saveunidadModal').on('show.bs.modal', function (event) {
	$("#saveunidadModal input").val('');
    $("#GuardarUnidad").val("Guardar");
});
$('#savezonaModal').on('show.bs.modal', function (event) {
	$("#savezonaModal input").val('');
    $("#GuardarZona").val("Guardar");
});
$('#saveactivoModal').on('show.bs.modal', function (event) {
	$("#saveactivoModal input").val('');
	$("#saveactivoModal select").val("");
	$("#saveactivoModal textarea").val('');
    $("#GuardarActivo").val("Guardar");
});
//Calcular el valor faltante
function faltante(){
	try{
		var value1= parseInt(document.getElementById("cantidadrequerida").value) || 0;
		var value2= parseInt(document.getElementById("cantidad").value) ||	0;
		document.getElementById("holguradecantidad").value = value1-value2;	
	}catch (e){}
};
function faltanteeditar(){
	try{
		var value1= parseInt(document.getElementById("cantidadrequerida1").value) || 0;
		var value2= parseInt(document.getElementById("cantidad1").value) ||	0;
		document.getElementById("holguradecantidad1").value = value1-value2;	
	}catch (e){}
};
function faltanteeditar2(){
	try{
		var value1= parseInt(document.getElementById("cantidadrequerida2").value) || 0;
		var value2= parseInt(document.getElementById("cantidad2").value) ||	0;
		document.getElementById("holguradecantidad2").value = value1-value2;	
	}catch (e){}
};
//Mostras contraseña
function Showpass(){
	var pass1 = document.getElementById("userpassword1");
	var pass = document.getElementById("userpassword");
	if (pass1.type == "password"){
		pass1.type = "text";
	}else{
		pass1.type = "password";
	}
	if (pass.type == "password"){
		pass.type = "text";
	}else{
		pass.type = "password";
	}
}

//Alerta de verificacion borrar rol
function Delete(idrol){
	swal({
  title: "¿Estás seguro?",
  text: "¡Una vez eliminado, no podrá recuperar este usuario!",
  icon: "warning",
  buttons: ["Cancelar", true],
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url: "//localhost:9898/views/DataSpi/Admin/deleteuser/"+ idrol,
		success: function (res){
			console.log(res);
		}
	});
    swal("¡Puf! ¡Tu usuario ha sido eliminado!", {
      icon: "success",
    }).then((OK)=>{
		if(OK){
			location.href="http://localhost:9898/views/DataSpi/Admin/usuarios";
		}
    });
  } else {
    swal("¡Tu usuario está a salvo!");
  }
});
}

//Alerta de verificacion borrar institucion
function Deleteinstitucion(idinstitucion){
	swal({
  title: "¿Estás seguro?",
  text: "¡Una vez eliminado, no podrá recuperar esta institución!",
  icon: "warning",
  buttons: ["Cancelar", true],
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url: "//localhost:9898/views/DataSpi/Admin/deleteinstitucion/"+ idinstitucion,
		success: function (res){
			console.log(res);
		}
	});
    
  } else {
    swal("¡Institución está a salvo!");
  }
});
}

//Alerta de verificacion borrar unidad
function Deleteunidad(idunidad){
	swal({
  title: "¿Estás seguro?",
  text: "¡Una vez eliminado, no podrá recuperar esta unidad de la SDH!",
  icon: "warning",
  buttons: ["Cancelar", true],
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url: "//localhost:9898/views/DataSpi/Admin/deleteunidad/"+ idunidad,
		success: function (res){
			console.log(res);
		}
	});
    swal("¡Puf! ¡Unidad ha sido eliminada!", {
      icon: "success",
    }).then((OK)=>{
		if(OK){
			location.href="http://localhost:9898/views/DataSpi/Admin/unidades";
		}
    });
  } else {
    swal("¡Unidad está a salvo!");
  }
});
}
//Validaciones fecha en input date
$(function(){
	var dtToday = new Date();
	var month = dtToday.getMonth() + 1;
	var day = dtToday.getDate();
	var year = dtToday.getFullYear();
	if(month < 10)
	month ='0' + month.toString();
	if(day< 10)
	day = '0' + day.toString();
	var maxDate = year + '-' + month + '-' + day;
	$('.valDate').attr('max',maxDate);
	$('.valDateNext').attr('min',maxDate);
	document.getElementById('footertext').innerHTML=maxDate;
	
});

//Validaciones input solo letras
function ValidOnlyWords(e) {
	key = e.keyCode || e.which;
	tecla = String.fromCharCode(key).toString();
	letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚabcdefghijklmnopqrstuvwxyzáéíóú";

	especiales = [8, 13];
	tecla_especial = false
	for (var i in especiales) {
		if (key == especiales[i]) {
			tecla_especial = true;
			break;
		}
	}

	if (letras.indexOf(tecla) == -1 && !tecla_especial) {
		
		return false;
	}
}
	
//Validaciones de Bootstrap 
(function() {
	  'use strict';
	  window.addEventListener('load', function() {
	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
	    var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {
	      form.addEventListener('submit', function(event) {
	        if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	        }
	        form.classList.add('was-validated');
	      }, false);
	    });
	  }, false);
})();

//Cerrar alertas
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 3000);



//Validación peso maximo del archivo
const MAXIMO_TAMANIO_BYTES = 5000000; // 1MB = 1 millón de bytes

//Obtener referencia al elemento
const $miArchivo = document.querySelector("#archivo");
const $miArchivo1 = document.querySelector("#archivo1");

$miArchivo.addEventListener("change", function () {
	// si no hay archivos, regresamos
	if (this.files.length <= 0) return;

	// Validamos el primer archivo únicamente
	const archivo = this.files[0];
	if (archivo.size > MAXIMO_TAMANIO_BYTES) {
		const tamanioEnMb = MAXIMO_TAMANIO_BYTES / 1000000;
		alert(`El tamaño máximo del Verificable es de ${tamanioEnMb} MB`);
		// Limpiar
		$miArchivo.value = "";
	} else {
		// Validación pasada. Envía el formulario o haz lo que tengas que hacer
	}
});

$miArchivo1.addEventListener("change", function () {
	// si no hay archivos, regresamos
	if (this.files.length <= 0) return;

	// Validamos el primer archivo únicamente
	const archivo = this.files[0];
	if (archivo.size > MAXIMO_TAMANIO_BYTES) {
		const tamanioEnMb = MAXIMO_TAMANIO_BYTES / 1000000;
		alert(`El tamaño máximo del Verificable es de ${tamanioEnMb} MB`);
		// Limpiar
		$miArchivo1.value = "";
	} else {
		// Validación pasada. Envía el formulario o haz lo que tengas que hacer
	}
});


