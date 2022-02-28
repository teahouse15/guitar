package latke.repository;

import org.b3log.latke.repository.*;
import org.b3log.latke.repository.annotation.Repository;
import org.json.JSONObject;

@Repository
public class OptionRepository extends AbstractRepository {

    public OptionRepository() {
        super("option");
    }


    public JSONObject queryOption(String optionName) throws RepositoryException {
        // 查询
        return getFirst(new Query().setFilter(new PropertyFilter("optionName", FilterOperator.EQUAL, optionName)));
    }
}
