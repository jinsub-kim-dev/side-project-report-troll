package gg.troll.report.api.image.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;

@Service
public class ImageService {

    @Value("${image.base.path}")
    String imageBasePath;

    public ResponseEntity<byte[]> serveImage(String imageType, String imageFileName) throws Exception {
        String imagePath = String.format("%s/%s/%s", imageBasePath, imageType, imageFileName);
        File imageFile = new File(imagePath);
        byte[] bytes = Files.readAllBytes(imageFile.toPath());
        return ResponseEntity.ok(bytes);
    }
}
