package com.mycompany.product.bo;

import com.mycompany.product.dto.Product;

public interface ProductBO {

	public void create(Product product);

	public Product findProduct(int id);

}
