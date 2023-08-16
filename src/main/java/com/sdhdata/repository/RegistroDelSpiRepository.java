package com.sdhdata.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.SpiDatos;

@Repository
public interface RegistroDelSpiRepository extends CrudRepository<RegistrodelSpi, Long> {
	Calendar fecha = Calendar.getInstance();
    int año = fecha.get(Calendar.YEAR);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=1")
	public List<RegistrodelSpi> Listaregistrodelspiinstalaciones(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=2")
	public List<RegistrodelSpi> Listaregistrodelspibienes(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=3")
	public List<RegistrodelSpi> Listaregistrodelspiequipos(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=4")
	public List<RegistrodelSpi> Listaregistrodelspiotros(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=5")
	public List<RegistrodelSpi> Listaregistrodelspimovilidad(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=6")
	public List<RegistrodelSpi> Listaregistrodelspiconectividad(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idinstitucion.idinstitucion=:idinstitucion")
	public List<RegistrodelSpi> Buscaregistroinstitucion(Long idinstitucion);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idactivo.idtipo.idtipo=:idtipo")
	public List<RegistrodelSpi> Buscaregistrotipo(Long idtipo);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idactivo.idactivo=:idactivo")
	public List<RegistrodelSpi> BuscarporActivo(Long idactivo);
	
	public RegistrodelSpi findByArchivo(String archivo);
	
}
