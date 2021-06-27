package adbistju.system.controller;


import adbistju.system.DTO.ProductDTO;
import adbistju.system.repo.Product;
import adbistju.system.repo.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    private ProductService productService;
    private ProductDTO productDTO;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping
    public List getProductPage(){
        return productService.showAllProducts();
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductDTO(@PathVariable("id") long id) {
        Product product = productService.getProductById(id);
         return productDTO = new ProductDTO(
                product.getCategory(),
                product.getTitle(),
                product.getPrice());
    }

    @PostMapping("/create/{category}&{title}&{price}")
    public void createProduct(@PathVariable("price") int id, @PathVariable("title") String title, @PathVariable("category") String category){
        ProductDTO productDTO = new ProductDTO(category, title, id);
        productService.insertProduct(productDTO.getProduct());
    }

}
