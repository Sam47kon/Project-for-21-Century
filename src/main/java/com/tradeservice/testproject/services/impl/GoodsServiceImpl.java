package com.tradeservice.testproject.services.impl;

import com.tradeservice.testproject.entities.Goods;
import com.tradeservice.testproject.repositories.GoodsRepository;
import com.tradeservice.testproject.services.GoodsService;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

  private GoodsRepository goodsRepository;

  @Autowired
  public GoodsServiceImpl(GoodsRepository goodsRepository) {
    this.goodsRepository = goodsRepository;
  }

  @Override
  public Goods add(Goods goods) {
    return goodsRepository.save(goods);
  }

  @Override
  public Goods getById(Long id) {
    Optional<Goods> optionalGoods = goodsRepository.findById(id);
    Goods goods = optionalGoods.orElse(null);
    if (goods == null) {
      throw new NoSuchElementException("Такого товара нет! ");
    }
    return goods;
  }

  @Override
  public void delete(Long id) {
    goodsRepository.deleteById(id);
  }

  @Override
  public Goods getByName(String name) {
    return goodsRepository.findByName(name);
  }

  @Override
  public Goods edit(Goods goods) {
    return goodsRepository.saveAndFlush(goods);
  }

  @Override
  public List<Goods> getAll() {
    return goodsRepository.findAll();
  }


  // Чтобы изменить можно было по имени. нужно сначала найти товар в БД по имени, затем изменить
  public Goods editWithoutId(Map<String, String> map) {
    String oldName = map.get("oldName");
    if (oldName == null) {
      throw new IllegalArgumentException("Необходим параметр oldName! ");
    }
    String newName = map.get("newName");
    String strNewPrice = map.get("newPrice");

    Goods result = getByName(oldName);
    if (result == null) {
      throw new NoSuchElementException("Такого товара нет! ");
    }
      if (newName != null) {
        result.setName(newName);
      }
      if (strNewPrice != null) {
        Double newPrice = Double.parseDouble(strNewPrice);
        result.setPrice(newPrice);
      }
      return goodsRepository.saveAndFlush(result);
    }
}
