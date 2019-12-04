/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * TODO miyamoto.daisuke.
 */
public class Hoge {
	
	@Test
	public void testName() throws Exception {
		// setup
		ObjectMapper mapper = new ObjectMapper();
		// exercise
		// verify
		BigDecimal a = new BigDecimal("1");
		assertThat(a.scale()).isEqualTo(0);
		assertThat(a.precision()).isEqualTo(1);
//		assertThat(value2.scale()).isEqualTo(4);
//		assertThat(mapper.writeValueAsString(value1)).isEqualTo("0.0276");
	}
}
