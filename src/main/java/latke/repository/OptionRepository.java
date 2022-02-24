package latke.repository;

import org.b3log.latke.repository.annotation.Repository;
import org.json.JSONObject;

@Repository
public class OptionRepository {


    public JSONObject queryOption() {
        return getFirst();
    }
}
