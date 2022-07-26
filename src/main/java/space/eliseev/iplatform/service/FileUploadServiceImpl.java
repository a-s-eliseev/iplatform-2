package space.eliseev.iplatform.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import space.eliseev.iplatform.entity.Attachment;
import space.eliseev.iplatform.repository.FileUploadRepository;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private FileUploadRepository fileUploadRepository;

    public FileUploadServiceImpl(FileUploadRepository fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path" + fileName);
            }
            Attachment attachment = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes());
            return fileUploadRepository.save(attachment);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }
}
