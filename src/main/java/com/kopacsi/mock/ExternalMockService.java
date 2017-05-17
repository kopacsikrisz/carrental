package com.kopacsi.mock;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExternalMockService {

	public static boolean checkCarUsageForCountry(String carType, List<String> countries) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return countries.size() % 2 == 0;
	}
}
