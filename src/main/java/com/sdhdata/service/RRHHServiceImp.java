package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.RRHH;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
import com.sdhdata.repository.RRHHRepository;

@Service
@Transactional
public class RRHHServiceImp implements IRRHHService {
	
	@Autowired
	private RRHHRepository RRHHRepository;

	@Override
	public List<RRHH> listarrrhh() {
		return (List<RRHH>) RRHHRepository.findAll();
	}

	@Override
	public void guardar(RRHH RRHH) {
		RRHHRepository.save(RRHH);

	}

	@Override
	public RRHH buscarPorId(Long id) {
		return RRHHRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		RRHHRepository.deleteById(id);

	}

	@Override
	public List<RRHH> Listaporspirrhh(SpiDatos idspi) {
		return RRHHRepository.Listaporspirrhh(idspi);
	}
	
	@Override
	public List<RRHH> ListaporspirrhhFor(SpiDatos idspi) {
		return RRHHRepository.ListaporspirrhhFor(idspi);
	}
	
	@Override
	public List<RRHH> Listaporzonarrhh(Zona idzona) {
		return RRHHRepository.Listaporzonarrhh(idzona);
	}

	@Override
	public List<RRHH> listarrhhzona1() {
		return RRHHRepository.listarrhhzona1();
	}

	@Override
	public List<RRHH> listarrhhzona2() {
		return RRHHRepository.listarrhhzona2();
	}

	@Override
	public List<RRHH> listarrhhzona3() {
		return RRHHRepository.listarrhhzona3();
	}

	@Override
	public List<RRHH> listarrhhzona4() {
		return RRHHRepository.listarrhhzona4();
	}

	@Override
	public List<RRHH> listarrhhzona5() {
		return RRHHRepository.listarrhhzona5();
	}

	@Override
	public List<RRHH> listarrhhzona6() {
		return RRHHRepository.listarrhhzona6();
	}

	@Override
	public List<RRHH> listarrhhzona7() {
		return RRHHRepository.listarrhhzona7();
	}

	@Override
	public List<RRHH> listarrhhzona8() {
		return RRHHRepository.listarrhhzona8();
	}

	@Override
	public List<RRHH> listarrhhzona9() {
		return RRHHRepository.listarrhhzona9();
	}

	@Override
	public List<RRHH> ListaporrrhhActivo() {
		return RRHHRepository.ListaporrrhhActivo();
	}

	@Override
	public List<RRHH> Listaporcedularrhh(String cedula) {
		return RRHHRepository.Listaporcedularrhh(cedula);
	}

	@Override
	public List<RRHH> Buscarporunidad(Long idunidad) {
		return RRHHRepository.Buscarporunidad(idunidad);
	}

	
		

}
