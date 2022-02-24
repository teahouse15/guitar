package latke.repository;

import org.b3log.latke.repository.*;
import org.b3log.latke.repository.annotation.Repository;
import org.json.JSONObject;

import java.util.List;

@Repository
public class DriverMapRepository extends AbstractRepository {

    public DriverMapRepository() {
        super("drivermap");
    }

    public List<JSONObject> getAllMap() throws RepositoryException {
        return getList(new Query());
    }
}
