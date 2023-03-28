package com.categoria.categoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.categoria.categoria.entity.Categoria;
import com.categoria.categoria.service.CategoriaServicio;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaServicio servicio;

    @GetMapping({ "/", "/categorias", "/index" })
    public String listarCategorias(Model modelo) {
        modelo.addAttribute("categorias", servicio.listarTodosLasCategorias());
        
        return "categorias"; // nos retorna al archivo categorias
    }

    @GetMapping("/categorias/nuevo")
    public String mostrarFormularioDeRegistrtarCategoria(Model modelo) {
        Categoria categoria = new Categoria();
        modelo.addAttribute("categoria", categoria);
        return "crear_categoria";
    }

    @PostMapping("/categorias")
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        servicio.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("categoria", servicio.obtenerCategoriaPorId(id));
        return "editar_categoria";
    }

    @PostMapping("/categorias/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("categoria") Categoria categoria,
                                       Model modelo) {
        Categoria categoriaExistente = servicio.obtenerCategoriaPorId(id);
        categoriaExistente.setCodigo(id);
        categoriaExistente.setNombreProducto(categoria.getNombreProducto());
        categoriaExistente.setDescripcion(categoria.getDescripcion());


        servicio.actualizarCategoria(categoriaExistente);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        servicio.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}
