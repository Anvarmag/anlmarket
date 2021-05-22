package tech.itpark.anlmarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.anlmarket.domain.Store;
import tech.itpark.anlmarket.manager.ProductManager;
import tech.itpark.anlmarket.domain.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductManager manager;


    @GetMapping
    public List<Product> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable long id) {
        return manager.getById(id);
    }



    @GetMapping("/search")
    public Product search(@RequestParam String text) {
        return manager.search(text);
    }


    @PostMapping
    public Product save(@RequestBody Product item) {
        return manager.save(item);
    }


    @DeleteMapping("/{id}")
    public Product removeById(@PathVariable long id) {
        return manager.removeById(id);
    }
}
