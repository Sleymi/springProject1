package com.example.dao;

import java.util.List;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long> {

	
	
	public List<Produit> findByDesignation(String des );

	public Page<Produit> findByDesignation(String des,Pageable p );
	
	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> rechercheParDes(@Param("x")String des,Pageable p );
	
	

}
