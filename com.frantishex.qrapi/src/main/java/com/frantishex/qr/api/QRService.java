package com.frantishex.qr.api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Service
public class QRService {

	private static final int IMAGE_SIZE = 125;

	byte[] createQRFile(String qrCodeText) throws WriterException, IOException {

		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		
		MatrixToImageWriter.writeToStream(new QRCodeWriter().encode(qrCodeText, BarcodeFormat.QR_CODE, IMAGE_SIZE, IMAGE_SIZE,hintMap), "PNG", pngOutputStream);
	
		return pngOutputStream.toByteArray();
	}
}