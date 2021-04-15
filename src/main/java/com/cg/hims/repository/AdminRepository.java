package com.cg.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.hims.entities.Admin;
/**
 * 
 * @author Manas
 * Admin entity's repository
 *
 */

public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
