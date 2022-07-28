package space.eliseev.iplatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import space.eliseev.iplatform.entity.FileUpload;

@Repository
public interface FileUploadRepository extends MongoRepository<FileUpload, String> {
}