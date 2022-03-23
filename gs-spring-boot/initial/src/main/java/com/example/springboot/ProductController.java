package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
public class ProductController{

    @Autowired  // 通過@Autowired自動產生物件(不用我們new一個實體)
    private ProductService productService;

    @GetMapping("/products/getAll") // 處理get方法的傳入請求
    public List<Product> list() {   // 取得全部的便當
        return productService.getAll(); // 取得全部
    }


    @GetMapping("/products/get/{id}")
    public ResponseEntity<Product> getById(@PathVariable(value = "id")Long id) {
        try{
            Product product = productService.getById(id);
            if(product == null) {
                return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
     }

    @PostMapping("/products/add")
    public void add(@RequestBody Product product){ productService.saveProduct(product);
    }

    @PutMapping("/products/put/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable(value = "id")Long id) {
        try{
            Product existProduct = productService.getById(id);
            if(existProduct == null) {
                return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            } //下面兩行若同時存在，前端再買便當時，數量雖然會正常扣，但是會新增名稱為空的欄位
            productService.putById(id,product.getAmount()); //有這行前端再買便當時，數量才會正常扣
            productService.saveProduct(product); //有這行才可以用put修改便當名稱及數量
            return new ResponseEntity<Product>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/delete/{id}")
    public void delete(@PathVariable(value = "id")Long id) {
        productService.deleteById(id);
    }
}