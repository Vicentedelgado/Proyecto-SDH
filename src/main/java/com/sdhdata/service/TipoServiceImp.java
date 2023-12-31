package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.Tipo;
import com.sdhdata.repository.TipoRepository;

@Service
@Transactional
public class TipoServiceImp implements ITipoService {
	
	@Autowired
	private TipoRepository TipoRepository;

	@Override
	public List<Tipo> listatipos() {
		return (List<Tipo>) TipoRepository.findAll();
	}

	@Override
	public void guardar(Tipo Tipo) {
		TipoRepository.save(Tipo);

	}

	@Override
	public Tipo buscarporId(Long idtipo) {
		return TipoRepository.findById(idtipo).orElse(null);
	}

	@Override
	public void eliminar(Long idtipo) {
		TipoRepository.deleteById(idtipo);

	}

	@Override
	public List<Tipo> listapornombre(String nombre) {
		return TipoRepository.listapornombre(nombre);
	}
	
	

}
