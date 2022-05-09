package com.omnia.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.omnia.app.model.Area;
import com.omnia.app.model.Companies;
import com.omnia.app.model.Company;

public interface AreaRepository extends JpaRepository<Area,Long> {
	
@Query("SELECT c FROM  Companies  c  WHERE   c. id  = (select e.company.id from Employee e  where e.id = ?1)")
	
	Companies getCompanyAdmin(long adminid);

}
