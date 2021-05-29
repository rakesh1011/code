package com.ust.pms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.pms.model.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart,Integer>{

}
