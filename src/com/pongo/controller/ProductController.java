package com.pongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pongo.Dao.ObjectDao;
import com.pongo.bo.Response;
import com.pongo.model.Products;


@RestController
public class ProductController {

	@Autowired
	private ObjectDao objectDao;
	
	@CrossOrigin
	@RequestMapping(value="/web/add-product",method=RequestMethod.POST)
	private Response addPoll(@RequestBody Products products){
		Response response = new Response();
		try {
			Products p=new Products();
			p.setDealerPrice(products.getDealerPrice());
			p.setDistributorPrice(products.getDistributorPrice());
			p.setFinalPrice(products.getFinalPrice());
			p.setMrp(products.getMrp());
			p.setMrpWithGst(products.getMrpWithGst());
			p.setProductName(products.getProductName());
			objectDao.saveObject(p);
			response.setMessage("Product details saved successfully.");
			response.setStatus("200");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("500");
			response.setMessage("Couldn't perform the request.");
			response.setResult(e.getMessage());
			return response;
		}
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/web/list-product",method=RequestMethod.GET)
	private Response listProduct(){
		Response response = new Response();
		try {
			response.setStatus("200");
			response.setMessage("Product list");
			response.setResult(objectDao.listObjectAsc(Products.class, "productId"));
			return response;
		} catch (Exception e) {
			response.setStatus("500");
			response.setMessage(e.getMessage());
			return response;
		}
	}
}
