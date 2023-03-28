package com.categoria.categoria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.categoria.categoria.entity.Categoria;
import com.categoria.categoria.repositorie.CategoriaRepositorio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {
    @Autowired
    private CategoriaRepositorio repositorio;

    @Override
    public List<Categoria> listarTodosLasCategorias() {

        return repositorio.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {

        return repositorio.save(categoria);
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long id) {

        return repositorio.findById(id).get();
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return repositorio.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        repositorio.deleteById(id);

    }

}
