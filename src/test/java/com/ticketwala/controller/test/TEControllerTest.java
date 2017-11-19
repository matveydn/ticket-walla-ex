package com.ticketwala.controller.test;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ticketwala.dao.api.DataAccessService;
import com.ticketwala.dao.impl.DataAccessServiceImpl;
import com.ticketwala.model.MovieShow;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class TEControllerTest {
	
	private void prepareDatabase() {
		DataAccessService das = new DataAccessServiceImpl();
		das.deleteAllMovieShows();
		das.createMovieShow(new MovieShow("12345", "Star Wars III", LocalDateTime.now(), 120));
		das.createMovieShow(new MovieShow("12346", "Star Wars V", LocalDateTime.now(), 120));
	}
	
	@Test
	public void testGetMovieShow() {
		prepareDatabase();
		get("movieshow/12345").
		then().body("id", equalTo("12345")).
		and().body("movieName", equalTo("Star Wars III"));
	}
	

}
