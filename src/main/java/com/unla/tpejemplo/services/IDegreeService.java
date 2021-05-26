package com.unla.tpejemplo.services;

import java.util.List;

import com.unla.tpejemplo.entities.Degree;
import com.unla.tpejemplo.models.DegreeModel;

public interface IDegreeService {
	
public List<Degree> getAll();

public DegreeModel insertOrUpdate(DegreeModel degreeModel);

public boolean remove(int id);

}
