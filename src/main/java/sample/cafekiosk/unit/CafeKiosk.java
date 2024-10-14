package sample.cafekiosk.unit;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import sample.cafekiosk.unit.beverage.Beverage;
import sample.cafekiosk.unit.order.Order;

// 요구사항들을 전부 충족시키는 객체
@Getter
public class CafeKiosk {

	// 시간에 대한 상수값 생성
	private static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);
	private static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);

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
	// public int calculateTotalPrice() {
	// 	int totalPrice = 0;
	// 	for (Beverage beverage : beverages) {
	// 		totalPrice += beverage.getPrice();
	// 	}
	//
	// 	return totalPrice;

	// }

	public int calculateTotalPrice() {
		return beverages.stream().mapToInt(Beverage::getPrice).sum();
	}

	// 주문 목록 생성
	public Order createOrder() {
		// 현재 날짜와 시간(실행할 때마다 변경됨)
		LocalDateTime currentDateTime = LocalDateTime.now();
		// 현재 시간만 뽑기
		LocalTime currentTime = currentDateTime.toLocalTime();
		// 오픈 시간 이전이거나 클로즈 시간 이후이면 예외처리
		if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)){
			throw new IllegalArgumentException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
		}
		return new Order(LocalDateTime.now(), beverages);
	}

	// 주문 목록 생성
	// 주문 시간을 파라미터로 받도록 수정(위에는 실행될 때마다 시간이 변경되었기 때문)
	public Order createOrder(LocalDateTime currentDateTime) {

		// 현재 시간만 뽑기
		LocalTime currentTime = currentDateTime.toLocalTime();
		// 오픈 시간 이전이거나 클로즈 시간 이후이면 예외처리
		if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)){
			throw new IllegalArgumentException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
		}
		return new Order(LocalDateTime.now(), beverages);
	}
}
