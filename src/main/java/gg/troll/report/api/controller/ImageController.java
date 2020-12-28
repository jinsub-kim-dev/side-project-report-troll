package gg.troll.report.api.controller;

import gg.troll.report.api.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @ResponseBody
    @GetMapping("/{imageType}/{imageFileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageType, @PathVariable String imageFileName) throws Exception {
        return imageService.serveImage(imageType, imageFileName);
    }
}
