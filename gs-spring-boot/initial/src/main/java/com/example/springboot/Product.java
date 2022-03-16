package com.example.springboot;

import javax.persistence.*;

@Entity                   //告訴spring boot這是一個資料庫的類別，該檔案包含實體類的屬性和對應屬性的set、get方法
@Table(name = "Product")  //name = Table是對應資料表名稱最好跟Class的名稱相同
public class Product {
    @Id                   //是此資料表的Primary Key (PK)
    @GeneratedValue(strategy = GenerationType.AUTO) //告訴此Column的生成方式，如果設定成GenerationType.AUTO表示讓容器來自動產生
    private long id;
    @Column(name = "NAME")//name = 對應到Table的欄位中的欄位名稱
    private String name;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "Amount")
    private int amount;
    @Column(name = "HINT")
    private String hint;

    public Product(){}

    public Product(String name, int price,int amount, String hint) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.hint = hint;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}