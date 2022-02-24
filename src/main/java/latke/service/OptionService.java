package latke.service;

import latke.repository.OptionRepository;
import org.b3log.latke.ioc.Inject;
import org.b3log.latke.service.annotation.Service;
import org.json.JSONObject;

@Service
public class OptionService {

    @Inject
    private OptionRepository optionRepository;

    public JSONObject queryOption(String index) {
        JSONObject option = optionRepository.queryOption();
        return option;
    }
}
