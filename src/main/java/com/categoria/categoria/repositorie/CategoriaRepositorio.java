package com.categoria.categoria.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.categoria.categoria.entity.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
    
}



