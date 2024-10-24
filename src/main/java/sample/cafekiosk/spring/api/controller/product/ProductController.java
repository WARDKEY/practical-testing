package sample.cafekiosk.spring.api.controller.product;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sample.cafekiosk.spring.api.service.product.ProductService;
import sample.cafekiosk.spring.api.service.product.response.ProductResponse;

@RequiredArgsConstructor
@RestController
public class ProductController {
	private final ProductService productService;

	// 팔고 있는 상품을 반환
	@GetMapping("/api/v1/products/selling")
	public List<ProductResponse> getSellingProducts(){
		return productService.getSellingProducts();
	}

}
