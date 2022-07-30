package space.eliseev.iplatform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import space.eliseev.iplatform.entity.FileUpload;
import space.eliseev.iplatform.model.BaseEntity;
import space.eliseev.iplatform.repository.BaseEntytyRepository;
import space.eliseev.iplatform.repository.FileUploadRepository;
import space.eliseev.iplatform.service.factory.FileParserFactory;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {
    private final FileParserFactory factory;
    private final BaseEntytyRepository baseEntytyRepository;
    private final FileUploadRepository fileUploadRepository;

    @Override
    public FileUpload saveFile(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename path invalid " + fileName);
            }
            String type = fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase();
            BaseEntity entity = new BaseEntity();
            entity.setCreationTime(ZonedDateTime.now().toEpochSecond());
            entity.setData(factory.parse(type, file.getBytes()));
            entity.setProducerAPI("Our custom API");
            baseEntytyRepository.save(entity);
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
