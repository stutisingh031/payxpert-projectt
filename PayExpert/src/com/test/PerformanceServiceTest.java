package com.test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.model.Performance;
import com.service.PerformanceService;

public class PerformanceServiceTest {
	PerformanceService performanceService = new PerformanceService();

	@Test
	public void getPerformanceEfficiencyAscSort() {
		// Preparing input
		Performance p1 = new Performance(3, 20, 10, "10", 6, 1);
		Performance p2 = new Performance(10, 25, 5, "8", 6, 6);
		Performance p3 = new Performance(2, 22, 8, "16", 7, 1);
		Performance p4 = new Performance(4, 22, 8, "0", 7, 2);
		Performance p5 = new Performance(8, 26, 4, "10", 7, 1);
		Performance p6 = new Performance(11, 26, 4, "9", 7, 5);
		Performance p7 = new Performance(1, 15, 15, "10", 8, 2);
		Performance p8 = new Performance(5, 18, 12, "5", 8, 3);
		Performance p9 = new Performance(6, 28, 2, "8", 8, 7);
		Performance p10 = new Performance(7, 29, 1, "9", 8, 8);
		Performance p11 = new Performance(9, 27, 3, "12", 8, 7);
		Performance p12 = new Performance(12, 27, 3, "10", 8, 4);

		// -------------Use Case 1-------------
		List<Performance> expectedList = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
		List<Performance> actualList = null;
		try {
			actualList = performanceService.findAll();
			Assert.assertEquals(expectedList, actualList);
		} catch (SQLException e) {
		}

		// -------------Use Case 2-------------
		expectedList = Arrays.asList(p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
		actualList = null;
		try {
			actualList = performanceService.findAll();
			actualList.remove(0);
			//actualList.remove(actualList.size() - 1);// last element
			Assert.assertEquals(expectedList, actualList);
		} catch (SQLException e) {
		}

	}
}
