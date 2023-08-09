package com.system.bhakundo_management_system.Service;

import com.system.bhakundo_management_system.Pojo.BhakundoPojo;
import com.system.bhakundo_management_system.entity.Bhakundo;

import java.io.IOException;
import java.util.List;

public interface BhakundoService {
    BhakundoPojo savebhakundo(BhakundoPojo bhakundoPojo) throws IOException;

    Bhakundo fetchById(Integer id);

    List<Bhakundo> fetchAll();

    void deleteById(Integer id);
}
