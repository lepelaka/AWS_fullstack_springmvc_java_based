package co.lepelaka.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ImageUploadController {
	private static final String UPLOAD_PATH = "c:/upload/";
	
	@GetMapping("/image/upload")
	public String upload() {
		return "image";
	}
	@PostMapping("/image/upload")
	public void upload(List<MultipartFile> files) {
		log.info(files);
	}
	@PostMapping("/image/uploadAjax") @ResponseBody
	public Map<String, Object> uploadAjax(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		log.info(request);
		MultipartFile multipartFile = request.getFile("upload");
		String origin =  multipartFile.getOriginalFilename();
		String ext = origin.substring(origin.indexOf("."));
		
		String newName = UUID.randomUUID() + ext;
		String path = UPLOAD_PATH + newName;
		multipartFile.transferTo(new File(path));
		
		Map<String, Object> map = new HashMap<>();
		map.put("uploaded", true);
		map.put("url", "/image/display?filename="+newName);
		log.info(map);
		return map;
	}
	
	@GetMapping("image/display") @ResponseBody
	public ResponseEntity<byte[]> getFile(String filename) throws IOException {
		File file = new File(UPLOAD_PATH + filename);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", Files.probeContentType(file.toPath()));
		return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers ,HttpStatus.OK);
	}
}
