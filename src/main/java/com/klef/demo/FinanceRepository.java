package com.klef.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FinanceRepository extends CrudRepository<Finance,Integer> {
	@Query("from Finance where email = :email")
	public List<Finance> getAllThroughId(@Param("email")String email);
	
//	@Query("delete from Finance where email = :email and id = :id")
//	public String deleteRecord(@Param("email")String email,@Param("id")int id);
}
