package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {

	@GetMapping("/") // 括號中的斜線代表根目錄，除了@GetMapping還有@PostMapping，@PutMapping
	public String index() {
//		return "Greetings from Spring Boot!";
    	return "0";
		//Spring boot 只要在網路上傳輸資料，有request(要求)，response(回應)，public String index(){return}括號內都要有return
		//在網路上的傳輸，不論資料型態是什麼。都是字串!!!

	}
}