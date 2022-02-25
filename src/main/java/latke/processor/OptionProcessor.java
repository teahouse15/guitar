package latke.processor;

import latke.service.OptionService;
import latke.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.b3log.latke.http.Request;
import org.b3log.latke.http.RequestContext;
import org.b3log.latke.ioc.Inject;
import org.b3log.latke.ioc.Singleton;
import org.json.JSONObject;

@Singleton
public class OptionProcessor {

    // 注册日志
    private static final Logger LOGGER = LogManager.getLogger(OptionProcessor.class);

    @Inject
    private OptionService optionService;

    public void setServerDriverPath(final RequestContext context) {

        // 提取参数
        final JSONObject requestJSONRequest = context.requestJSON();
        System.out.println(requestJSONRequest.toString());

        final String driverPath = requestJSONRequest.getString("serverDriverPath");
        System.out.println("DriverPath: "  + driverPath);

        final String adminToken = requestJSONRequest.getString("adminToken");
        System.out.println("UserToken: " + adminToken);

        final JSONObject jsonObject = new JSONObject();
        context.renderJSON(jsonObject);

        if (!adminToken.equals("123456")) {
            jsonObject.put("code", 401);
            jsonObject.put("msg", "not admin");
            return;
        }
        jsonObject.put("code", 200);
        jsonObject.put("msg", "ok");

        optionService.setServerDriverPath(driverPath);
    }

}
