package org.dio.expert.configserver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@SpringBootTest
class ConfigServerApplicationTests {

	@Test
	void contextLoads() {

		final Double[] doubleValues = {
				123.011D,123.015D,123.018D,123.045D,
				123.049D,123.055D,123.059D,123.099D,
				123.4501D,123.4511D,123.4520D,123.453D,
				123.454D,123.455D,123.456D,123.457D,123.458D,123.459D,
				123.460D,123.465D,123.467D,
				123.468D,123.469D,
				123.470D,123.489D,12.499D,
				123.445D,123.455D,123.465D,123.475D,123.485D,123.495D};

		Arrays.stream(doubleValues).forEach(doubleValue ->{

			Double doubleAntigo = Double.parseDouble(String.format("%.2f", doubleValue).replaceAll(",", "."));
			System.out.println("Double antigo: " + doubleAntigo);

			BigDecimal amount = new BigDecimal(doubleValue).setScale(2, RoundingMode.HALF_EVEN);
			Double doubleNovo = amount.doubleValue();
			System.out.println("Double novo: " + doubleAntigo);

			Assertions.assertEquals(doubleAntigo, doubleNovo);
		});



	}

}
