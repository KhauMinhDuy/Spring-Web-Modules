package com.khauminhduy.persistence;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.stream.IntStream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khauminhduy.model.Foo;

@Component
public class DataSetupBean implements InitializingBean {

	@Autowired
	private FooRepository fooRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		IntStream.range(1, 5).forEach(e -> fooRepository.save(new Foo(randomAlphabetic(e))));
	}

}
