package space.eliseev.iplatform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import space.eliseev.iplatform.entity.FileUpload;
import space.eliseev.iplatform.repository.BaseEntityRepository;
import space.eliseev.iplatform.repository.FileUploadRepository;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    private final BaseEntityRepository baseEntityRepository;
    private final FileUploadRepository fileUploadRepository;

    @Override
    public FileUpload saveFile(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename path invalid " + fileName);
            }

            FileUpload fileUpload =
                    new FileUpload(fileName,
                            file.getContentType(),
                            file.getBytes());
            return fileUploadRepository.save(fileUpload);
        } catch (Exception e) {
            throw new Exception("Could not save file " + fileName);
        }
    }
}
