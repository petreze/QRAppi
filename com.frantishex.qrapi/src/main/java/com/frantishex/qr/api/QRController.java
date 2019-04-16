package com.frantishex.qr.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

@RestController
public class QRController {

	@Autowired
	QRService qrService;
	
	@RequestMapping(value = "/qr", method = RequestMethod.GET, produces={"image/png"})
	private ResponseEntity<byte[]> createQR(@RequestParam String qrCodeText) throws WriterException, IOException{
		return new ResponseEntity<byte[]>(qrService.createQRFile(qrCodeText), HttpStatus.OK);
	}
}
