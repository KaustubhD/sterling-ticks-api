package org.ibm.sterling_ticks.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.ibm.sterling_ticks.model.entities.EmailTemplate;

public class FileUtil {
	
	private static final String OTP_TEMPLATE_PATH = "src/main/resources/templates/otp-template.json";
	private static final String SUCCESS_TEMPLATE_PATH = "src/main/resources/templates/order-success-template.json";
	
	public static String readFile(String path) throws IOException {
		Path filePath = Paths.get(path);
		Files.readAllLines(filePath);
		String data = Files.readAllLines(filePath).stream().collect(Collectors.joining());
		return data;
	}
	
	public static EmailTemplate readOtpEmailTemplate() throws IOException {
		String json = readFile(OTP_TEMPLATE_PATH);
		EmailTemplate template = (new ObjectMapper()).readValue(json, EmailTemplate.class);
		
		return template;
	}
	public static EmailTemplate readOrderSuccessEmailTemplate() throws IOException {
		String json = readFile(SUCCESS_TEMPLATE_PATH);
		EmailTemplate template = (new ObjectMapper()).readValue(json, EmailTemplate.class);
		
		return template;
	}
}
