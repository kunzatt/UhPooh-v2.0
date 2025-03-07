package com.ssafy.uhpooh.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

import com.ssafy.uhpooh.place.repository.PlaceRepository;

@DataJpaTest
@ActiveProfiles("test")
@EnableJpaAuditing
public class PlaceRepositoryTest {

	@Autowired
	private PlaceRepository placeRepository;
}
