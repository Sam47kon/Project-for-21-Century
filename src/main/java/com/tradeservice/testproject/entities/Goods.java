package com.tradeservice.testproject.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Goods")
public class Goods {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long goodsId;

  @Column(name = "Name", nullable = false, unique = true)
  private String name;

  @Column(name = "Price", nullable = false)
  private Double price;

  @OneToMany(mappedBy = "goods")
  private Set<OrderLine> orderLineSet;  // геттеры и сеттеры не ставить

  public Goods() {
  }

  public Goods(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public Goods(Long goodsId, String name, Double price) {
    this.goodsId = goodsId;
    this.name = name;
    this.price = price;
  }

  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Goods{" +
        "goodsId=" + goodsId +
        ", name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
