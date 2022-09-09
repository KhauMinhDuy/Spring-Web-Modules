package com.khauminhduy.html;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HtmlController.class)
class HtmlControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	private final String expectedHtmlResponse = "<html>\n" + "<header><title>Welcome</title></header>\n" + "<body>\n"
			+ "Hello world\n" + "</body>\n" + "</html>";

	@Test
	void whenGETRequestToCorrectURL_thenReturnCorrectWelcomeMessage() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		assertEquals(expectedHtmlResponse, content);
	}

}
