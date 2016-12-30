package com.gil.example.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gil.example.beans.EventMaintenance;
import com.gil.example.beans.ScheduledMaintenance;
import com.gil.example.beans.Supplier;
import com.gil.example.dao.SuppliersManager;

@Controller
public class SuppliersController {

	@Autowired
	SuppliersManager suppliersManager;
	
	public void addSupplier(Supplier supplier){
		System.out.println("addScheduledMaintenance :: " + supplier);
		suppliersManager.persistSupplier(supplier);
	}

	public ArrayList<Supplier> getSuppliers() throws Exception {
		return suppliersManager.getAllSuppliers();
	}
}
