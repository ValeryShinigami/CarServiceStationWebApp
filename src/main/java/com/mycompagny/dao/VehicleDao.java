package com.mycompagny.dao;

import java.util.List;

public interface VehicleDao<Vehicle> {
	
	List<Vehicle> getVehicles();
	void addVehicle (Vehicle vehicle);
	void deleteVehicle(int id);
	Vehicle getVehicleById(int id);

}

