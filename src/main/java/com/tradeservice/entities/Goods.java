package com.tradeservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "goods")
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

  public Goods(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long goodsId;

  @Column(name = "Name", nullable = false, unique = true)
  private String name;

  @Column(name = "Price", nullable = false)
  private Double price;
}