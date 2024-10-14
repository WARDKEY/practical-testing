package sample.cafekiosk.unit.order;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sample.cafekiosk.unit.beverage.Beverage;

@Getter
@RequiredArgsConstructor
public class Order {

	// final 붙이면 필수로 받게 됨

	// 주문 일시
	private final LocalDateTime orderDateTime;

	// 음료 리스트
	private final List<Beverage> beverages;
}
