package com.gil.example.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gil.example.beans.LoginDetails;
import com.gil.example.beans.ScheduledMaintenance;
import com.gil.example.beans.Supplier;
import com.gil.example.beans.Token;
import com.gil.example.logic.MaintenanceController;
import com.gil.example.logic.SuppliersController;

@RestController
public class SuppliersApi {

	@Autowired
	private SuppliersController suppliersController;
	
	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public @ResponseBody void addSupplier(@RequestBody Supplier supplier) 
			throws Exception {
		suppliersController.addSupplier(supplier);
	}
	
	@RequestMapping(value = "/getSuppliers", method = RequestMethod.GET)
	 public @ResponseBody ArrayList<Supplier> getSuppliers() throws Exception {
		return suppliersController.getSuppliers();	
	}
}
