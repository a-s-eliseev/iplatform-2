package space.eliseev.iplatform.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import space.eliseev.iplatform.entity.Attachment;
import space.eliseev.iplatform.model.ResponseData;
import space.eliseev.iplatform.service.FileUploadService;

import static space.eliseev.iplatform.controller.DemoParams.FILE;

@RestController
public class FileUploadController {

    private FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam(FILE)MultipartFile file) throws Exception {
        Attachment attachment = null;
        String downloadURL = "";
        attachment = fileUploadService.saveAttachment(file);
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

        return new ResponseData(attachment.getFileName(),
                downloadURL,
                file.getContentType(),
                file.getSize());
    }
}
