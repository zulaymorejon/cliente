package com.cliente.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ClienteApirestApplicationTests.class})
@SpringBootTest
class ClienteApirestApplicationTests {

	@Test
	void contextLoads() {
	}

}
