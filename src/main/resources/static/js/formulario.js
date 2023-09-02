 /**
 * FORMULARIO JS
 */


/*Cambio de color según prioridad en formulario*/
$(function() {
	$("table td:nth-child(7):contains(Baja)")
	.parents("tr")
    .css("background-color", "#78cf8c");
	
	$("table td:nth-child(7):contains(Media)")
	.parents("tr")
    .css("background-color", "#fff2cc");
	
	$("table td:nth-child(7):contains(Alta)")
	.parents("tr")
    .css("background-color", "#f8cecc");
});
$(function() {
	$("table td:nth-child(6):contains(Baja)")
	.parents("tr")
    .css("background-color", "#78cf8c");
	
	$("table td:nth-child(6):contains(Media)")
	.parents("tr")
    .css("background-color", "#fff2cc");
	
	$("table td:nth-child(6):contains(Alta)")
	.parents("tr")
    .css("background-color", "#f8cecc");
});

//////////////////////////////////////////////////////////////////////////////////
//función select dinámico página formulario
$('#spiporzonaformulario').change(
        function() {
			var loc = window.location;
            var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
            var pageurl = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
			$.getJSON(pageurl+"Elegirspi", {
           /*$.getJSON("http://localhost:9898/views/DataSpi/Formulario/Elegirspi", {*/
           /* $.getJSON("http://192.168.61.28:8080/views/DataSpi/Formulario/Elegirspi", {*/
                idzona : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un SPI...</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idspi + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idspi').html(html);
        });
    });

//función obtener value spi para filtrado en página formulario
$(document).ready(function(){
	$("#idspi").change(function(){
		var spiValue = $(this).children('option:selected').val();
		$('#filtrarform').attr('action', $('#baseURL').val() + spiValue);
	});
});
/////////////////////////////////////////////////////////////////////////////

//función select dinámico página formulario por tipo
$('#filtrarportipo').change(
        function() {
			var loc = window.location;
            var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
            var pageurl = loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
			$.getJSON(pageurl+"Elegiractivo", {
            /*$.getJSON("http://localhost:9898/views/DataSpi/RegistroDelSpi/Elegiractivo", {*/
            /*$.getJSON("http://192.168.61.28:8080/views/DataSpi/RegistroDelSpi/Elegiractivo", {*/
                idtipo : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un bien/servicio...</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idactivo + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idactivo').html(html);
        });
});


///////////////////////////////////////////////////////////////////////////////

/*cambio de valores para la ventana modal editar y guardar en formulario */


/*REGISTRO DEL SPI*/
$(document).ready(function(){
	
$('.table .editModal2').on('click',function(event){
	event.preventDefault();
	var href = $(this).attr('href');
	$.get(href,function(registrospi,status){
		$('.editar #idregistro').val(registrospi.idregistro);
		$('.editar #idactivo1').val(registrospi.idactivo.idactivo);
		document.getElementById('idactivonombre').innerHTML=registrospi.idactivo.nombre;
		$('.editar #idspi1').val(registrospi.idspi.idspi);
		$('.editar #idinstitucion1').val(registrospi.idinstitucion.idinstitucion);
		$('.editar #estado1').val(registrospi.estado);
		$('.editar #cantidad').val(registrospi.cantidad);
		$('.editar #cantidadrequerida').val(registrospi.cantidadrequerida);
		$('.editar #holguradecantidad').val(registrospi.holguradecantidad);
		$('.editar #prioridad1').val(registrospi.prioridad);
		$('.editar #accionrealizada1').val(registrospi.accionrealizada);
		$('.editar #periodo1').val(registrospi.periodo);
		document.getElementById('periodonombre').innerHTML=registrospi.periodo;
		$('.editar #fechaaccion1').val(registrospi.fechaaccion.substr(0,10));
		$('.editar #observaciones1').val(registrospi.observaciones);
		$('.editar #archivo3').val(registrospi.archivo);
	});
	
	$('.editar #editarModal2').modal();
});
});

/*RRHH*/
$(document).ready(function(){
	
	$('.table .editModal3').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(rrhh,status){
			$('.editar #idusuario').val(rrhh.idusuario);
			$('.editar #nombres1').val(rrhh.nombres);
			$('.editar #apellidos1').val(rrhh.apellidos);
			$('.editar #cargo1').val(rrhh.cargo);
			$('.editar #cedula1').val(rrhh.cedula);
			$('.editar #idzona1').val(rrhh.idzona.idzona);
			$('.editar #idspi11').val(rrhh.idspi.idspi);
			$('.editar #cargo1').val(rrhh.cargo);
			$('.editar #idmodalidad1').val(rrhh.idmodalidad.idmodalidad);
			$('.editar #idunidad1').val(rrhh.idunidad.idunidad);
			$('.editar #estado2').val(rrhh.estado);
			$('.editar #telefono1').val(rrhh.telefono);
			$('.editar #email1').val(rrhh.email);
			$('.editar #direccion1').val(rrhh.direccion);
																	
		});
		
		$('.editar #editarModal3').modal();
	});
});

$('#saveModal').on('show.bs.modal', function (event) {
	var dtToday = new Date();
	var year = dtToday.getFullYear();
    $("#saveModal input").val('');
    $("#archivo2").val('vacio_sdh.pdf');
    $("#saveModal select").val("");
    $("#saveModal textarea").val('');
    $("#saveModal small").val('');
    $("#periodo").val(year);
    $("#spi").val(document.getElementById("spi1").value);
    $("#Guardar").val("Guardar");
});

$('#saveModalActivo').on('show.bs.modal', function (event) {
	$("#saveModalActivo input").val('');
	$("#saveModalActivo select").val("");
	$("#saveModalActivo textarea").val('');
	$("#spi31").val('N');
	$("#spi32").val('N');
	$("#spi33").val('1');
	$("#spi34").val('1');
	$("#spi35").val('1');
	$("#spi36").val('0000');
    $("#spi3").val(document.getElementById("spi1").value);
    $("#Guardaractivo").val("Guardar");
});

$('#saveModalInstitucion').on('show.bs.modal', function (event) {
	$("#saveModalInstitucion input").val('');
	$("#spi41").val('N');
	$("#spi42").val('N');
	$("#spi43").val('1');
	$("#spi44").val('1');
	$("#spi45").val('1');
	$("#spi46").val('0000');
    $("#spi4").val(document.getElementById("spi1").value);
    $("#GuardarInstitucion").val("Guardar");
});

$('#saveModalRRHH').on('show.bs.modal', function (event) {
	$("#saveModalRRHH input").val('');
	$("#saveModalRRHH select").val("");
	$("#saveModalRRHH textarea").val('');
	$("#idzona2").val(document.getElementById("zona1").value);
    $("#idspi12").val(document.getElementById("spi1").value);
    $("#estado3").val("Activo");
    $("#Guardarrrhh").val("Guardar");
});

//Calcular el valor faltante
function faltante(){
	try{
		var value1= parseInt(document.getElementById("cantidadrequerida1").value) || 0;
		var value2= parseInt(document.getElementById("cantidad1").value) ||	0;
		document.getElementById("holguradecantidad1").value = value1-value2;	
	}catch (e){}
};
function faltanteeditar(){
	try{
		var value1= parseInt(document.getElementById("cantidadrequerida").value) || 0;
		var value2= parseInt(document.getElementById("cantidad").value) ||	0;
		document.getElementById("holguradecantidad").value = value1-value2;	
	}catch (e){}
};

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

//Validacion cedula

function verificarCedula(cedula) {
  if (typeof(cedula) == 'string' && cedula.length == 10 && /^\d+$/.test(cedula)) {
    var digitos = cedula.split('').map(Number);
    var codigo_provincia = digitos[0] * 10 + digitos[1];

    //if (codigo_provincia >= 1 && (codigo_provincia <= 24 || codigo_provincia == 30) && digitos[2] < 6) {

    if (codigo_provincia >= 1 && (codigo_provincia <= 24 || codigo_provincia == 30)) {
      var digito_verificador = digitos.pop();

      var digito_calculado = digitos.reduce(
        function (valorPrevio, valorActual, indice) {
          return valorPrevio - (valorActual * (2 - indice % 2)) % 9 - (valorActual == 9) * 9;
        }, 1000) % 10;
      return digito_calculado === digito_verificador;
}
  //}
  return false;
}
}
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


