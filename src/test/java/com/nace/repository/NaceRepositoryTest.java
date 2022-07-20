package com.nace.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class NaceRepositoryTest {
	@Autowired
	private NaceRepository repository;
	
	@Test
	public  void injectedComponentsAreNotNull(){
		assertThat(repository).isNotNull();
	}

}
