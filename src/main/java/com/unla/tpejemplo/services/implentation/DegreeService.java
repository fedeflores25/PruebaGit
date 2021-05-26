package com.unla.tpejemplo.services.implentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.tpejemplo.converters.DegreeConverter;
import com.unla.tpejemplo.entities.Degree;
import com.unla.tpejemplo.models.DegreeModel;
import com.unla.tpejemplo.repositories.IDegreeRepository;
import com.unla.tpejemplo.services.IDegreeService;

@Service("degreeService")
public class DegreeService implements IDegreeService{

	@Autowired
	@Qualifier("degreeRepository")
	private IDegreeRepository degreeRepository;
	
	@Autowired
	@Qualifier("degreeConverter")
	private DegreeConverter degreeConverter;
	
	@Override
	public List<Degree> getAll(){
		return degreeRepository.findAll();
		
	}
	
	@Override
	public DegreeModel insertOrUpdate(DegreeModel degreeModel){
		Degree degree = degreeRepository.save(degreeConverter.modelToEntity(degreeModel));
		return degreeConverter.entityToModel(degree);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			degreeRepository.deleteById(id);;
			return true;
						
		}catch (Exception e) {
			return false;
		}
	}
	
	
	
		
		
	
	
}
