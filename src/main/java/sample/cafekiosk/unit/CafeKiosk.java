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

	// 한 번에 음료 여러 잔 추가 메서드
	public void add(Beverage beverage, int count){
		// 0잔 이하를 선택하면 예외처리
		if (count <= 0){
			throw new IllegalArgumentException("음료는 한 잔 이상 주문하실 수 있습니다.");
		}

		// 예외가 안 났으면 추가
		for (int i = 0; i < count; i++) {
			beverages.add(beverage);

		}
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
