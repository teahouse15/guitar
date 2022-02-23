package latke.repository;

import org.b3log.latke.repository.*;
import org.b3log.latke.repository.annotation.Repository;
import org.json.JSONObject;

@Repository
public class UserRepository extends AbstractRepository {
    public UserRepository() {
        super("user");
    }

    public JSONObject getByName(final String name) throws RepositoryException {
        return getFirst(new Query().setFilter(new PropertyFilter("name", FilterOperator.EQUAL, name)));
    }
}
