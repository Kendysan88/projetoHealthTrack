package br.com.healthtrack.model.physicalactivity.dao;

import java.util.ArrayList;

import br.com.healthtrack.model.physicalactivity.PhysicalActivityBySeries;

public interface PhysicalActivityBySeriesDAO {
	
    void create(PhysicalActivityBySeries pa);
    
    ArrayList<PhysicalActivityBySeries> getAll();
    
    PhysicalActivityBySeries searchById(int physicalActivityId);
    
    void update(PhysicalActivityBySeries pa);
  
    void destroy(int physicalActivityId);
    

}
