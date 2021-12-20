package com.klef.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CityController {
	@Autowired
	private RestTemplate restTemplate;
	
	private static String url = "http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey=53cLgi8FvgZy0IzGycNGJbXVMItMmJwB&q=";
	@GetMapping("/city/{city}")
	public List<Object> getCities(@PathVariable("city")String city){
	    Object[] cities = restTemplate.getForObject(url+city, Object[].class);
		return Arrays.asList(cities);
	}
	
	@GetMapping("city/daily/{cityid}")
	public Object dailyForecast(@PathVariable("cityid")int cityid) {
		return restTemplate.getForObject("http://dataservice.accuweather.com/forecasts/v1/daily/1day/"+cityid+"?apikey=53cLgi8FvgZy0IzGycNGJbXVMItMmJwB",Object.class);
	}
	
	@GetMapping("city/5days/{cityid}")
	public Object FivedayForecast(@PathVariable("cityid")int cityid) {
		return restTemplate.getForObject("http://dataservice.accuweather.com/forecasts/v1/daily/5day/"+cityid+"?apikey=53cLgi8FvgZy0IzGycNGJbXVMItMmJwB",Object.class);
	}
	
	@GetMapping("city/12hour/{cityid}")
	public Object TwelveHourForeCast(@PathVariable("cityid")int cityid) {
		return restTemplate.getForObject("http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/"+cityid+"?apikey=53cLgi8FvgZy0IzGycNGJbXVMItMmJwB",Object.class);
	}
	
	@GetMapping("city/currentcondition/{cityid}")
	public Object currentcondition(@PathVariable("cityid")int cityid) {
		return restTemplate.getForObject("http://dataservice.accuweather.com/currentconditions/v1/"+cityid+"?apikey=53cLgi8FvgZy0IzGycNGJbXVMItMmJwB",Object.class);
	}
}
