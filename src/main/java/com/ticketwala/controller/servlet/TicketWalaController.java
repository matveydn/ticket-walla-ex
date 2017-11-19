package com.ticketwala.controller.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.http.client.protocol.ResponseContentEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ticketwala.model.MovieShow;
import com.ticketwala.service.api.TicketWalaService;


@RestController
public class TicketWalaController {
	
	@Autowired
	TicketWalaService tws;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		return "TicketWala Web Application custom Matvey";
	}
	
	@RequestMapping(value = "/movieshow/", method = RequestMethod.GET)
	public List<MovieShow> getAllMovieShows(){
		return this.tws.getMovieShows();
	}
	
	@RequestMapping(value = "/movieshow/{id}", method = RequestMethod.GET)
	public ResponseEntity<MovieShow> getMovieShow(@PathVariable("id") String id){
		MovieShow movieShow = this.tws.getMovieShow(id);
		HttpStatus s = movieShow == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<MovieShow>(movieShow, s);
	}
	
	@RequestMapping(value = "/postmymap", method = RequestMethod.POST)
	public Map<String, String> postData(@RequestBody Map<String, String> map){
		Map<String, String> res = new HashMap<String, String>();
		String fullName = map.get("lname") + " " + map.get("fname");
		res.put(fullName, "OK");
		return res;
	}
	
}

