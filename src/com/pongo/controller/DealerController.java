package com.pongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.pongo.Dao.ObjectDao;
import com.pongo.bo.Response;
import com.pongo.utility.FileUtility;

@RestController
public class DealerController {

	@Autowired
	private ObjectDao objectDao;

	@Autowired
	private FileUtility fileUtility;

	@Autowired
	private Environment environment;
	
	private Response 
	

}
