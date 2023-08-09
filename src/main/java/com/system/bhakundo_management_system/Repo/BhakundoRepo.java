package com.system.bhakundo_management_system.Repo;

import com.system.bhakundo_management_system.entity.Bhakundo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BhakundoRepo extends JpaRepository <Bhakundo, Integer>{
}
