package sample.cafekiosk.unit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import sample.cafekiosk.unit.beverage.Beverage;
import sample.cafekiosk.unit.order.Order;

// 요구사항들을 전부 충족시키는 객체
@Getter
public class CafeKiosk {

	private final List<Beverage> beverages = new ArrayList<>();

	// 음료 추가 메서드
	public void add(Beverage beverage) {
		beverages.add(beverage);
	}

	// 음료 삭제 메서드
	public void remove(Beverage beverage){
		beverages.remove(beverage);
	}

	// 음료 전체 삭제 메서드
	public void clear(){
		beverages.clear();
	}

	// 총 주문 가격 계산 메서드
	public int calculateTotalPrice() {
		int totalPrice = 0;
		for (Beverage beverage : beverages) {
			totalPrice += beverage.getPrice();
		}

		return totalPrice;
	}

	// 주문 목록 생성
	public Order createOrder() {
		return new Order(LocalDateTime.now(), beverages);
	}

}
