package com.FMSv2.FMSv2.parameters.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FMSv2.FMSv2.parameters.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}