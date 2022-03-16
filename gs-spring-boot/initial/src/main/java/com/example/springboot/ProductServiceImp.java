package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// 把傳入的參數與資料庫做連結
@Service// 位於controller和model之間，解耦用
public class ProductServiceImp implements ProductService { // 實現該介面

    @Autowired // 通過@Autowired自動產生物件實體(不用我們new一個實體)
    private ProductRepository productRepository;

    @Override // 一般為覆寫父類別方法，這邊是實現介面的抽象方法
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override // 把傳入的Product存入資料庫
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        // 用Optional包裝是為了防止開發者對null操作
        Optional<Product> optional = productRepository.findById(id);
        Product product = null; // 初始化
        if(optional.isPresent()) {  // 如果這個包裝下的物件不是null
            product = optional.get(); // 才get此物件存給lunchBox變數
        }
        return product;
    }

 /*   @Override
    public void putById(Long id, int buyAmount) {
        Optional<Product> optionalLunchBox = productRepository.findById(id);
        Product product= null;
        if(optionalLunchBox.isPresent()) {
            product = optionalLunchBox.get();  // 同上
            // 設定此物件的amount為(原amount - 傳入的amount(購買數量))
            product.setAmount(product.getAmount() - buyAmount);
            productRepository.save(product);  // 改完後，在對應回資料庫
        }
    }*/

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}