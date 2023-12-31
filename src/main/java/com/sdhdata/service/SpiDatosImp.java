package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
import com.sdhdata.repository.SpiDatosRepository;

@Service
@Transactional
public class SpiDatosImp implements ISpiDatosService {

	@Autowired
	private SpiDatosRepository SpiDatosRepository;
	
	@Override
	public List<SpiDatos> listaspidatos() {
		return (List<SpiDatos>) SpiDatosRepository.findAll();
	}

	@Override
	public void guardar(SpiDatos SpiDatos) {
		SpiDatosRepository.save(SpiDatos);

	}

	@Override
	public SpiDatos buscarPorId(Long idspi) {
		return SpiDatosRepository.findById(idspi).orElse(null);
	}

	@Override
	public void eliminar(Long idspi) {
		SpiDatosRepository.deleteById(idspi);

	}

	@Override
	public List<SpiDatos> Listaporspi(Long idspi) {
		return SpiDatosRepository.Listaporspi(idspi);
	}

	@Override
	public List<SpiDatos> FindByZona(Zona idzona) {
		return SpiDatosRepository.FindByZona(idzona);
	}

	@Override
	public List<SpiDatos> BuscarporInstitucion(Long idinstitucion) {
		return SpiDatosRepository.BuscarporInstitucion(idinstitucion);
	}

	@Override
	public List<SpiDatos> BuscarporZona(Long idzona) {
		return SpiDatosRepository.BuscarporZona(idzona);
	}

	
	
}
