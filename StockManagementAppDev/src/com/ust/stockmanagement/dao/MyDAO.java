package com.ust.stockmanagement.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust.stockmanagement.model.OrderDTO;
import com.ust.stockmanagement.model.ProductDTO;
import com.ust.stockmanagement.model.UserDTO;

public interface MyDAO {
	 public boolean register(UserDTO dto);
	 public UserDTO login(UserDTO dto);
	public boolean additem(ProductDTO dto);
	public List<ProductDTO> view();
	public ProductDTO edit(int id);
	public boolean updateitem(HttpServletRequest req);
	public List<ProductDTO> search(HttpServletRequest req);
	public List<ProductDTO> addtocart(int id);
//	public List<ProductDTO> generatebill(HttpServletRequest req);
	//public List<ProductDTO> order();
	public List<OrderDTO> mycart();

}
