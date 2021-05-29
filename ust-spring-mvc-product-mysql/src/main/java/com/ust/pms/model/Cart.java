package com.ust.pms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor		//default
@RequiredArgsConstructor		//default
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class Cart {
		
		@Id
		
		private  @NonNull int cartProductId;
		private String cartProductName;
		private @NonNull int cartQuantityOnHand;
		private @NonNull int price;
		private int totalPrice;
		/*
		 * public int getProductId() { // TODO Auto-generated method stub //return
		 * productId;
		 * 
		 * 
		 * }
		 */
	
		
		
}