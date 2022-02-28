package latke.repository;

import org.b3log.latke.repository.AbstractRepository;
import org.b3log.latke.repository.annotation.Repository;

@Repository
public class DirectoryRepository extends AbstractRepository {

    public DirectoryRepository() {
        super("directory");
    }
}
