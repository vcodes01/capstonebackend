package com.victoria.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victoria.backend.models.Accessory;
 
@Repository
public interface AccessoryRepository extends JpaRepository <Accessory, Integer>{

	List<Accessory> findByType(String type);

}
