package com.example.inventory.controller;

import com.example.inventory.model.Product;
import com.example.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    /**
     * GET - Obtiene todos los productos
     */
    @GetMapping
    public ResponseEntity<List<Product>> obtenerTodos() {
        List<Product> productos = productService.obtenerTodos();
        return ResponseEntity.ok(productos);
    }
    
    /**
     * GET - Obtiene un producto por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> obtenerPorId(@PathVariable Long id) {
        Optional<Product> producto = productService.obtenerPorId(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    /**
     * POST - Crea un nuevo producto
     */
    @PostMapping
    public ResponseEntity<Product> crear(@Valid @RequestBody Product product) {
        Product productoGuardado = productService.guardar(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
    }
    
    /**
     * PUT - Actualiza un producto existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizar(@PathVariable Long id, @RequestBody Product product) {
        Product productoActualizado = productService.actualizar(id, product);
        if (productoActualizado != null) {
            return ResponseEntity.ok(productoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * DELETE - Elimina un producto por ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Product> producto = productService.obtenerPorId(id);
        if (producto.isPresent()) {
            productService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
