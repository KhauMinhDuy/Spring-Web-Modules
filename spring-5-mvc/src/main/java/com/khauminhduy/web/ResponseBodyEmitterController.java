package com.khauminhduy.web;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.khauminhduy.Constants;

@Controller
public class ResponseBodyEmitterController {

	private ExecutorService executorService = Executors.newCachedThreadPool();

	@GetMapping(Constants.API_RBE)
	public ResponseEntity<ResponseBodyEmitter> handleRbe() {
		ResponseBodyEmitter emitter = new ResponseBodyEmitter();
		executorService.execute(() -> {
			try {
				emitter.send(Constants.API_RBE_MSG + " @ " + new Date(), MediaType.TEXT_PLAIN);
				emitter.complete();
			} catch (Exception ex) {
				System.out.println(Constants.GENERIC_EXCEPTION);
				emitter.completeWithError(ex);
			}
		});
		return new ResponseEntity<>(emitter, HttpStatus.OK);
	}

}