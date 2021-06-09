package org.ibm.sterling_ticks.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.ibm.sterling_ticks.entities.EmailTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FileUtil {
	
	private static final String OTP_TEMPLATE_PATH = "src/main/resources/templates/otp-template.json";
	
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
}
