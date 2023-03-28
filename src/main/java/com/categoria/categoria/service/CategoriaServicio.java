package com.categoria.categoria.service;

import java.util.List;

import com.categoria.categoria.entity.Categoria;

public interface CategoriaServicio {

    public List<Categoria> listarTodosLasCategorias();

    public Categoria guardarCategoria(Categoria categoria);

    public Categoria obtenerCategoriaPorId(Long id);

    public Categoria actualizarCategoria(Categoria categoria);

    public void eliminarCategoria(Long id);
    
}
