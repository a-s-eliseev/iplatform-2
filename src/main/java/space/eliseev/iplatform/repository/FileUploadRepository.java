package space.eliseev.iplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.eliseev.iplatform.entity.Attachment;

@Repository
public interface FileUploadRepository extends JpaRepository<Attachment, String> {
}
