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
public class Product {
		
		@Id
		
		private  @NonNull int productId;
		private String productName;
		private @NonNull int quantityOnHand;
		private @NonNull int price;
		public int getProductId() {
			// TODO Auto-generated method stub
			return productId;
			
			
		}
	
		
		
}