package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.IProduitRepository;
import com.example.entities.Produit;


import java.util.List;

import javax.print.attribute.standard.PageRanges;

@RestController
public class CatalogueController {
	
//injection d'independance	
@Autowired	
private IProduitRepository Ip;

@RequestMapping("/test")
public String test() {
	
	return "test";
}

@RequestMapping("/save")
public Produit saveProduit(Produit p){
	Ip.save(p);
	return p;
}

@RequestMapping("/all")
public List<Produit> AllProduit(){
	return Ip.findAll();
}

@RequestMapping("/npage")
public Page<Produit> AllProduit(int page){
	return Ip.findAll(new PageRequest(page, 5));
}


@RequestMapping("/mc")
public Page<Produit> ProduitParMC(String des,int page){
	return Ip.findByDesignation(des, new PageRequest(page, 5));
}
@RequestMapping("/mc2")
public Page<Produit> ProduitParMC2(String des,int page){
	return Ip.rechercheParDes("%"+des+"%", new PageRequest(page, 5));
}

@RequestMapping("/get")
public Produit getProduit(long id){
	return Ip.findOne(id);
}
@RequestMapping("/delete")
public boolean delete(long id){
	 Ip.delete(id);
	 return true;
}
@RequestMapping("/update")
public Produit update(Produit p){
	// Ip.update(p);
	 Ip.saveAndFlush(p);
	 return p;
}


}
