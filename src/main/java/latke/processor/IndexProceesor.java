package latke.processor;

import latke.repository.UserRepository;
import latke.service.OptionService;
import latke.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.b3log.latke.http.RequestContext;
import org.b3log.latke.ioc.Inject;
import org.b3log.latke.ioc.Singleton;
import org.json.JSONObject;

@Singleton
public class IndexProceesor {

    private static final Logger LOGGER = LogManager.getLogger(IndexProceesor.class);

    @Inject
    private OptionService optionService;

    public void index(final RequestContext context) {
        final JSONObject serverStoragePath = optionService.queryServerDriverPath();
        context.renderJSON(serverStoragePath);
    }

    public void test(final RequestContext context) {
        final String paraVar = context.param("path");
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("path", paraVar);
        System.out.println(jsonObject.toString());
        context.renderJSON(jsonObject);
    }
}
