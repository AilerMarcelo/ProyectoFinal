package com.example.inventory.service;

import com.example.inventory.model.Product;
import com.example.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    /**
     * Obtiene todos los productos
     */
    public List<Product> obtenerTodos() {
        return productRepository.findAll();
    }
    
    /**
     * Obtiene un producto por su ID
     */
    public Optional<Product> obtenerPorId(Long id) {
        return productRepository.findById(id);
    }
    
    /**
     * Guarda un nuevo producto
     */
    public Product guardar(Product product) {
        return productRepository.save(product);
    }
    
    /**
     * Actualiza un producto existente
     */
    public Product actualizar(Long id, Product product) {
        return productRepository.findById(id).map(p -> {
            p.setNombre(product.getNombre());
            p.setCantidad(product.getCantidad());
            p.setPrecio(product.getPrecio());
            return productRepository.save(p);
        }).orElse(null);
    }
    
    /**
     * Elimina un producto por su ID
     */
    public void eliminar(Long id) {
        productRepository.deleteById(id);
    }
}
