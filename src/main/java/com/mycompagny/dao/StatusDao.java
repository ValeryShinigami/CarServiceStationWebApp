package com.mycompagny.dao;

import java.util.List;

public interface StatusDao<Status> {
	
	List<Status> getAllStatus();
	
	Status getStatusById(int id);

}
