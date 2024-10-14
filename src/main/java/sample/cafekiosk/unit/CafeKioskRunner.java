package sample.cafekiosk.unit;

import java.time.LocalDateTime;

import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Latte;
import sample.cafekiosk.unit.order.Order;

// 작업을 실행
public class CafeKioskRunner {

	public static void main(String[] args) {
		CafeKiosk cafeKiosk = new CafeKiosk();

		// 아메리카노 추가
		cafeKiosk.add(new Americano());
		System.out.println(">>> 아메리카노 추가");

		// 라떼 추가
		cafeKiosk.add(new Latte());
		System.out.println(">>> 라떼 추가");

		// 총 주문가격 계산
		int totalPrice = cafeKiosk.calculateTotalPrice();
		System.out.println("총 주문가격 : " + totalPrice);

		// 주문 생성
		Order order = cafeKiosk.createOrder(LocalDateTime.now());
	}
}
