package com.amigoscode.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

	private final FraudCheckHistoryRepository checkHistoryRepository;

	public boolean isFraudulentCustomer(Integer customerId) {
		checkHistoryRepository.save(
				FraudCheckHistory.builder()
						.isFraudster(false)
						.createdAt(LocalDateTime.now())
						.customerId(customerId)
						.build()
		);
		return false;
	}
}
