package com.sdhdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long>{

}
