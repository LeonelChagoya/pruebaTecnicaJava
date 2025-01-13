package com.java.domain.repository;


import com.java.domain.model.Prestamos;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrestamosLibrosRepository {
    List<Prestamos> findAllByUser(String username);
}
