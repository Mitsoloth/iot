package com.codeschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codeschool.entities.Device;

@Transactional
@Repository("deviceRepository")
public interface DeviceRepository extends JpaRepository<Device, Long> {
    //List<Device> findBypname(String pname);
    //Device findByEmail(String email);
    Device findById(Integer id);
    //List<Person> findAll();
}
