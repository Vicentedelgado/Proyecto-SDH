package com.sdhdata.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdhdata.model.Users;
import com.sdhdata.model.Institucion;
import com.sdhdata.model.Zona;
import com.sdhdata.model.Activo;
import com.sdhdata.model.Tipo;
import com.sdhdata.model.Modalidad;
import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.Unidad;
import com.sdhdata.model.Roles;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.RRHH;
import com.sdhdata.service.IUsersService;
import com.sdhdata.service.IInstitucionService;
import com.sdhdata.service.IZonaService;
import com.sdhdata.service.IActivoService;
import com.sdhdata.service.ITipoService;
import com.sdhdata.service.IUnidadService;
import com.sdhdata.service.IModalidadService;
import com.sdhdata.service.IRolesService;
import com.sdhdata.service.ISpiDatosService;
import com.sdhdata.service.IRegistroDelSpiService;
import com.sdhdata.service.IRRHHService;

@Controller
@RequestMapping("/views/DataSpi/Admin")
public class AdminController {
	
	@Autowired
	private IUsersService IUsersService;
	@Autowired
	private IRolesService IRolesService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private IInstitucionService IInstitucionService;
	@Autowired
	private IActivoService IActivoService;
	@Autowired
	private ITipoService ITipoService;
	@Autowired
	private IUnidadService IUnidadService;
	@Autowired
	private IModalidadService IModalidadService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IRegistroDelSpiService IRegistroDelSpiService;
	@Autowired
	private IRRHHService IRRHHService;
	
	@GetMapping("/")
	public String AdminPage (Model model) {
		List<Zona> listazonas = IZonaService.listazona();
		List<Institucion> listainstituciones = IInstitucionService.listainstitucion();		
		List<Activo> listaactivos = IActivoService.listaactivo();
		List<Tipo> listatipos = ITipoService.listatipos();
		List<Unidad> listaunidades = IUnidadService.listaunidad();
		List<Modalidad> listamodalidades = IModalidadService.listamodalidad();
		//CREAR FORMULARIOS
		Zona zona = new Zona();
		Institucion institucion = new Institucion();
		Tipo tipo= new Tipo();
		Unidad unidad=new Unidad();
		Activo activo=new Activo();
		Modalidad modalidad=new Modalidad();
		//VENTANA
		model.addAttribute("titulo","Página: Admin de SDH");
		model.addAttribute("titulo1","Zonas");
		model.addAttribute("listazonas",listazonas);
		model.addAttribute("listainstituciones",listainstituciones);
		model.addAttribute("listaactivos",listaactivos);
		model.addAttribute("listatipos",listatipos);
		model.addAttribute("listaunidades",listaunidades);
		model.addAttribute("listamodalidades",listamodalidades);
		model.addAttribute("zona",zona);
		model.addAttribute("institucion",institucion);
		model.addAttribute("tipo",tipo);
		model.addAttribute("unidad",unidad);
		model.addAttribute("activo",activo);
		model.addAttribute("modalidad",modalidad);
		return "/views/DataSpi/Admin/admin";
	}
	
	@GetMapping("/usuarios")
	public String AdminPageususrios (Model model) {
		List<Users> listausuarios= IUsersService.listausuarios();
		List<Roles> listaroles= IRolesService.listaroles();
		Users users = new Users();
		//VENTANA
		model.addAttribute("titulo","Página: Registro de Usuarios");
		model.addAttribute("titulo0","Lista de usuarios del sistema");
        model.addAttribute("listausuarios",listausuarios);
        model.addAttribute("listaroles",listaroles);
		model.addAttribute("users", users);
		
		return "/views/DataSpi/Admin/user";
	}
	
	
	@GetMapping("/zonas")
	public String AdminPagezonas (Model model) {
		List<Zona> listazonas = IZonaService.listazona();
		//CREAR FORMULARIOS
		Zona zona = new Zona();
		//VENTANA
		model.addAttribute("titulo","Página: Zonas de la SDH");
		model.addAttribute("listazonas",listazonas);
		model.addAttribute("zona",zona);
		return "/views/DataSpi/Admin/zona";
	}
	
	@GetMapping("/instituciones")
	public String AdminPageinstituciones (Model model) {
		List<Institucion> listainstituciones = IInstitucionService.listainstitucion();	
		//CREAR FORMULARIOS
		Institucion institucion = new Institucion();
		//VENTANA
		model.addAttribute("titulo","Página: Instituciones de la SDH");
		model.addAttribute("listainstituciones",listainstituciones);
		model.addAttribute("institucion",institucion);
		return "/views/DataSpi/Admin/institucion";
	}
	
	@GetMapping("/activos")
	public String AdminPageactivos (Model model) {		
		List<Activo> listaactivos = IActivoService.listaactivo();
		List<Tipo> listatipos = ITipoService.listatipos();
		//CREAR FORMULARIOS
		Activo activo=new Activo();
		//VENTANA
		model.addAttribute("titulo","Página: Bienes/Servicios de SDH");
		model.addAttribute("titulo1","Zonas");
		model.addAttribute("listaactivos",listaactivos);
		model.addAttribute("listatipos",listatipos);
		model.addAttribute("activo",activo);
		return "/views/DataSpi/Admin/activo";
	}
	
	@GetMapping("/tipos")
	public String AdminPagetipos (Model model) {
		
		List<Tipo> listatipos = ITipoService.listatipos();
		
		//CREAR FORMULARIOS
		
		Tipo tipo= new Tipo();
		
		//VENTANA
		model.addAttribute("titulo","Página: Categoría de bien");
		model.addAttribute("titulo1","Zonas");
		model.addAttribute("listatipos",listatipos);
		model.addAttribute("tipo",tipo);
		return "/views/DataSpi/Admin/tipo";
	}
	
	@GetMapping("/unidades")
	public String AdminPageunidaddes (Model model) {
		List<Unidad> listaunidad = IUnidadService.listaunidad();	
		//CREAR FORMULARIOS
		Unidad unidad = new Unidad();
		//VENTANA
		model.addAttribute("titulo","Página: Unidades de la SDH");
		model.addAttribute("listaunidad",listaunidad);
		model.addAttribute("unidad",unidad);
		return "/views/DataSpi/Admin/unidad";
	}
	
	
	//EDITAR MODAL Usuario
	@Secured("ROLE_ADMIN")
	@GetMapping("/edituser")
	@ResponseBody
	public Users editaruser(Long iduser) {
		return IUsersService.buscarPorId(iduser);
	}
	
	//EDITAR MODAL Usuario
	@Secured("ROLE_ADMIN")
	@GetMapping("/editrol")
	@ResponseBody
	public Roles editarrol(Long idrol) {
		return IRolesService.buscarPorId(idrol);
	}
		
	
	//EDITAR MODAL Zona
	@Secured("ROLE_ADMIN")
	@GetMapping("/editzona")
	@ResponseBody
	public Zona editarzona(Long idzona) {
		return IZonaService.buscarPorId(idzona);
	}
	
	//EDITAR MODAL Institucion
	@Secured("ROLE_ADMIN")
	@GetMapping("/editinstitucion")
	@ResponseBody
	public Institucion editarinstitucion(Long idinstitucion) {
		return IInstitucionService.buscarPorId(idinstitucion);
	}
	
	//EDITAR MODAL Activo
	@Secured("ROLE_ADMIN")
	@GetMapping("/editactivo")
	@ResponseBody
	public Activo editaractivo(Long idactivo) {
		return IActivoService.buscarPorId(idactivo);
	}
	
	//EDITAR MODAL Tipo
	@Secured("ROLE_ADMIN")
	@GetMapping("/edittipo")
	@ResponseBody
	public Tipo editartipo(Long idtipo) {
		return ITipoService.buscarporId(idtipo);
	}
	
	//EDITAR MODAL Unidad
	@Secured("ROLE_ADMIN")
	@GetMapping("/editunidad")
	@ResponseBody
	public Unidad editarunidad(Long idunidad) {
		return IUnidadService.buscarporId(idunidad);
	}
	
	//EDITAR MODAL Modalidad
	@Secured("ROLE_ADMIN")
	@GetMapping("/editmodalidad")
	@ResponseBody
	public Modalidad editarmodalidad(Long idmodalidad) {
		return IModalidadService.buscarporId(idmodalidad);
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/saveuser")
	public String guardarusuarios(@Valid @ModelAttribute Users users, BindingResult result, RedirectAttributes alerta) {
		List<Users> listaporusuario= IUsersService.filtrarporusuario(users.getUsername());
		if(listaporusuario.size()==1 && users.getIduser()==null) {
			System.out.print("EXISTE OTRO USUARIO CON ESTE NOMBRE");
			alerta.addFlashAttribute("info", "EXISTE OTRO USUARIO CON ESTE NOMBRE");
			return "redirect:/views/DataSpi/Admin/usuarios";
			
		}
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO USUARIO");
			return "/views/DataSpi/Admin/user";
		}
		IUsersService.guardar(users);
		System.out.print("REGISTRO USUARIO GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO USUARIO GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/usuarios";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/saverol")
	public String guardarroles(@Valid @ModelAttribute Roles roles, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO DE ASIGNAR ROL");
			return "/views/DataSpi/Admin/user";
		}
		
		IRolesService.guardar(roles);
		System.out.print("REGISTRO DE ASIGNACIÓN DE ROL A USUARIO GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO DE ASIGNACIÓN DE ROL A USUARIO GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/usuarios";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/savezona")
	public String guardarzona(@Valid @ModelAttribute Zona zona, BindingResult result, RedirectAttributes alerta) {
		List<Zona> listazonanombre = IZonaService.listazonanombre(zona.getNombre());
		if(listazonanombre.size()==1 && zona.getIdzona()==null ) {
			System.out.print("YA EXISTE LA: "+ zona.getNombre());
			alerta.addFlashAttribute("info", "YA EXISTE LA: "+ zona.getNombre());
			return "redirect:/views/DataSpi/Admin/zonas";
			
		}
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO ZONA");
			return "/views/DataSpi/Admin/zona";
		}
		IZonaService.guardar(zona);
		System.out.print("REGISTRO ZONA GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ZONA GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/zonas";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/saveinstitucion")
	public String guardarinstitucion(@Valid @ModelAttribute Institucion institucion, BindingResult result, RedirectAttributes alerta) {
		List<Institucion> listainsnombre = IInstitucionService.listainsnombre(institucion.getNombre());
		if(listainsnombre.size()==1 && institucion.getIdinstitucion()==null) {
			System.out.print("YA EXISTE LA: "+ institucion.getNombre());
			alerta.addFlashAttribute("info", "YA EXISTE LA INSTITUCIÓN: "+ institucion.getNombre());
			return "redirect:/views/DataSpi/Admin/instituciones";
			
		}
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO INSTITUCION");
			return "/views/DataSpi/Admin/instituciones";
		}
		IInstitucionService.guardar(institucion);
		System.out.print("REGISTRO INSTITUCIÓN GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO INSTITUCIÓN GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/instituciones";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/saveactivo")
	public String guardaractivo(@Valid @ModelAttribute Activo activo, BindingResult result, RedirectAttributes alerta) {
		
		alerta.addFlashAttribute("warning", "Quiere eliminar este activo");
		List<Activo> listaactivotipo =IActivoService.Buscarportipo(activo.getIdtipo());
		Long tipoactivo = listaactivotipo.get(1).getIdtipo().getIdtipo();
		Long activotipo = activo.getIdtipo().getIdtipo();
		System.out.print("TIPO TIPO TIPO: "+tipoactivo + activotipo);
		List<Activo> listanombre = IActivoService.Buscarpornombre(activo.getNombre());
		if(tipoactivo==activotipo && listanombre.size()==1 && activo.getIdactivo()==null) {
			System.out.print("YA EXISTE EL ACTIVO: "+ activo.getNombre()+" en la categoría "+ activo.getIdtipo().getNombre());
			alerta.addFlashAttribute("info", "YA EXISTE EL ACTIVO: "+ activo.getNombre()+" en la categoría "+ activo.getIdtipo().getNombre());
			return "redirect:/views/DataSpi/Admin/activos";
		}
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO ACTIVO");
			return "/views/DataSpi/Admin/activo";
		}
		IActivoService.guardar(activo);
		System.out.print("REGISTRO INSTITUCIÓN GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ACTIVO GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/activos";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/savetipo")
	public String guardaritipo(@Valid @ModelAttribute Tipo tipo, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO TIPO");
			return "/views/DataSpi/Admin/tipo";
		}
		ITipoService.guardar(tipo);
		System.out.print("REGISTRO TIPO GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO TIPO GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/tipos";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/saveunidad")
	public String guardarunidad(@Valid @ModelAttribute Unidad unidad, BindingResult result, RedirectAttributes alerta) {
		List<Unidad> listaunidad = IUnidadService.listauninombre(unidad.getNombre());
		if(listaunidad.size()==1 && unidad.getIdunidad()==null ) {
			System.out.print("YA EXISTE LA UNIDAD: "+ unidad.getNombre());
			alerta.addFlashAttribute("info", "YA EXISTE LA UNIDAD: "+ unidad.getNombre());
			return "redirect:/views/DataSpi/Admin/unidades";
			
		}
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO UNIDAD");
			return "/views/DataSpi/Admin/unidades";
		}
		IUnidadService.guardar(unidad);
		System.out.print("REGISTRO UNIDAD GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO UNIDAD GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/unidades";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/savemodalidad")
	public String guardarmodalidad(@Valid @ModelAttribute Modalidad modalidad, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO MODALIDAD");
			return "/views/DataSpi/Admin/admin";
		}
		IModalidadService.guardar(modalidad);
		System.out.print("REGISTRO MODALIDAD GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO MODALIDAD GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/";
	}
	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteuser/{iduser}")
	public String deleteuser(@PathVariable("iduser") Long iduser, RedirectAttributes alerta) {
		Users User = null;
		
		if(iduser > 0) {
			User = IUsersService.buscarPorId(iduser);
			if(User == null) {
				alerta.addFlashAttribute("warning", "NO EXISTE ESTE USUARIO");
				return "redirect:/views/DataSpi/Admin/usuarios";
			}
		}else {
			alerta.addFlashAttribute("info", "ERROR DE ID DE USUARIO");
			return "redirect:/views/DataSpi/Admin/usuarios";
		}
		IUsersService.eliminar(iduser);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/usuarios";
	}
	
	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deleterol/{idrol}")
	public String deleterol(@PathVariable("idrol") Long idrol, RedirectAttributes alerta) {
		Roles Rol = null;
		
		if(idrol > 0) {
			Rol = IRolesService.buscarPorId(idrol);
			if(Rol == null) {
				System.out.print("Error: El usuario no existe");
				alerta.addFlashAttribute("warning", "NO EXISTE ESTE USUARIO");
				return "redirect:/views/DataSpi/Admin/usuarios";
			}
		}else {
			System.out.print("Error: El usario no existe");
			alerta.addFlashAttribute("info", "ERROR DE ID DE USUARIO");
			return "redirect:/views/DataSpi/Admin/usuarios";
		}
		
		IRolesService.eliminar(idrol);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/usuarios";
	}

	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deletezona/{idzona}")
	public String deletezona(@PathVariable("idzona") Long idzona, RedirectAttributes alerta) {
		Zona Zon = null;
		if(idzona > 0) {
			Zon = IZonaService.buscarPorId(idzona);
			if(Zon == null) {
				System.out.print("Error: La zona no existe");
				alerta.addFlashAttribute("warning", "NO EXISTE ESTA ZONA");
				return "redirect:/views/DataSpi/Admin/zonas";
			}
		}else {
			System.out.print("Error: La zona no existe");
			alerta.addFlashAttribute("warning", "NO EXISTE ESTA ZONA");
			return "redirect:/views/DataSpi/Admin/zonas";
		}
		
		IZonaService.eliminar(idzona);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/zonas";
	}
	
	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteinstitucion/{idinstitucion}")
	public String deleteinstitucion(@PathVariable("idinstitucion") Long idinstitucion, RedirectAttributes alerta) {
		Institucion Ins = null;
		
		List<SpiDatos> spidatos = ISpiDatosService.BuscarporInstitucion(idinstitucion);
		List<RegistrodelSpi> registrospi = IRegistroDelSpiService.Buscaregistroinstitucion(idinstitucion);
		if(idinstitucion > 0) {
			Ins = IInstitucionService.buscarPorId(idinstitucion);
			if(Ins == null) {
				System.out.print("Error: La institución no existe");
				alerta.addFlashAttribute("warning", "NO EXISTE ESTA INSTITUCIÓN");
				return "redirect:/views/DataSpi/Admin/instituciones";
			}
		}else {
			System.out.print("Error: La institución no existe");
			alerta.addFlashAttribute("warning", "NO EXISTE ESTA INSTITUCIÓN");
			return "redirect:/views/DataSpi/Admin/instituciones";
		}
		if(spidatos.size()>=1 || registrospi.size()>=1 ) {
			System.out.print("NO SE PUEDE ELIMINAR PORQUE: "+ Ins.getNombre()+
					" está siendo usada en un registro del SPI");
			alerta.addFlashAttribute("error", "NO SE PUEDE ELIMINAR PORQUE: "+ Ins.getNombre()+
					" está siendo usada en un registro del SPI");
			return "redirect:/views/DataSpi/Admin/instituciones";
			
		}
		
		IInstitucionService.eliminar(idinstitucion);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/instituciones";
	}
	
	//Eliminar
	@GetMapping("/deleteactivo/{idactivo}")
	public String deleteactivo(@PathVariable("idactivo") Long idactivo, RedirectAttributes alerta) {
		
		
		IActivoService.eliminar(idactivo);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/activos";
	}
	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deletetipo/{idtipo}")
	public String deletetipo(@PathVariable("idtipo") Long idtipo, RedirectAttributes alerta) {
		
		
		ITipoService.eliminar(idtipo);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/tipos";
	}

	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deletemodalidad/{idmodalidad}")
	public String deletemoddalidad(@PathVariable("idmodalidad") Long idmodalidad, RedirectAttributes alerta) {
		
		
		IModalidadService.eliminar(idmodalidad);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/";
	}
	
	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteunidad/{idunidad}")
	public String deleteunidad(@PathVariable("idunidad") Long idunidad, RedirectAttributes alerta) {
		Unidad Uni = null;
		List<RRHH> rrhhunidad = IRRHHService.Buscarporunidad(idunidad);
		if(idunidad > 0) {
			Uni = IUnidadService.buscarporId(idunidad);
			if(Uni == null) {
				System.out.print("Error: La unidad no existe");
				alerta.addFlashAttribute("warning", "NO EXISTE ESTA UNIDAD");
				return "redirect:/views/DataSpi/Admin/unidades";
			}
		}else {
			System.out.print("Error: La unidad no existe");
			alerta.addFlashAttribute("warning", "NO EXISTE ESTA UNIDAD");
			return "redirect:/views/DataSpi/Admin/unidades";
		}
		if(rrhhunidad.size()>=1 ) {
			System.out.print("NO SE PUEDE ELIMINAR PORQUE: "+ Uni.getNombre()+
					" está siendo usada en un registro del RRHH");
			alerta.addFlashAttribute("error", "NO SE PUEDE ELIMINAR PORQUE: "+ Uni.getNombre()+
					" está siendo usada en un registro del RRHH");
			return "redirect:/views/DataSpi/Admin/unidades";
			
		}
		IUnidadService.eliminar(idunidad);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/unidades";
	}


}
