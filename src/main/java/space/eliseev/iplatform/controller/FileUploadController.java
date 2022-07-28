package space.eliseev.iplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import space.eliseev.iplatform.entity.FileUpload;
import space.eliseev.iplatform.model.ResponseData;
import space.eliseev.iplatform.service.FileUploadService;


@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        FileUpload fileUpload = null;
        String downloadURL = "";
        fileUpload = fileUploadService.saveFile(file);
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileUpload.getId())
                .toUriString();

        return new ResponseData(fileUpload.getFileName(),
                downloadURL,
                file.getContentType(),
                file.getSize());
    }
}
