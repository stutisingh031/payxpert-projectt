package com.utility;

import java.util.Comparator;
import com.model.Performance;

public class PerformanceEfficienctAscSort implements Comparator<Performance> {
	@Override
	public int compare(Performance c1, Performance c2) {
		if (c1.getEfficiency() < c2.getEfficiency())
			return -1;
		else if (c1.getEfficiency() > c2.getEfficiency())
			return 1;
		return 0;
	}
}
