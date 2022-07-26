package space.eliseev.iplatform.service;

import org.springframework.web.multipart.MultipartFile;
import space.eliseev.iplatform.entity.Attachment;

public interface FileUploadService {
    Attachment saveAttachment(MultipartFile file) throws Exception;
}
