package space.eliseev.iplatform.service;

import org.springframework.web.multipart.MultipartFile;
import space.eliseev.iplatform.entity.FileUpload;

public interface FileUploadService {
    FileUpload saveFile(MultipartFile file) throws Exception;
}
