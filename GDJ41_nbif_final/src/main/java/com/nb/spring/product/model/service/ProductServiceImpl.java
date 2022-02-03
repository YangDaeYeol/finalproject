package com.nb.spring.product.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nb.spring.product.model.dao.ProductDao;
import com.nb.spring.product.model.vo.Product;
import com.nb.spring.product.model.vo.ProductImage;
import com.nb.spring.product.model.vo.Review;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private ProductDao dao;
	
	@Override
	public Product selectOneProductNo(String productNo) {
		
		Product product = dao.selectOneProductNo(session, productNo);
		return product;
	}
	
	@Override
	public int insertProduct(Product p) {
		int result = dao.insertProduct(session, p);
		if(result>0 && !p.getImages().isEmpty()) {
			try {
				for(ProductImage pi : p.getImages()) {
					pi.setProductNo(p.getProductNo());
					result = dao.insertProductImg(session, pi);
				}				
			} catch(RuntimeException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int updateBid(Map<String, String> param) {
		int result = dao.updateBid(session,param);
		return result;
	}

	@Override
	public List<Review> selectReview(String sellerNo) {
		List<Review> list = dao.selectReview(session,sellerNo);
		return list;
	}

	@Override
	public int insertWishList(Map<String, String> param) {
		int result = dao.insertWishList(session, param);
		return result;
	}

	@Override
	public int selectWishList(Map<String, String> param) {
		int result = dao.selectWishList(session, param);
		return result;
	}

	@Override
	public Product updateProduct(String productNo) {
		Product p = dao.updateProduct(session, productNo);
		return p;
	}

	@Override
	public int updateProductEnd(Product p) {
		int result = dao.updateProductEnd(session, p);
		if(result>0 && !p.getImages().isEmpty()) {
			try {
				for(ProductImage pi : p.getImages()) {
					pi.setProductNo(p.getProductNo());
					result = dao.updateProductImg(session, pi);
				}				
			} catch(RuntimeException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
