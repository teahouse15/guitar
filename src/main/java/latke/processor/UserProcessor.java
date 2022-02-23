package latke.processor;

import latke.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.b3log.latke.http.Request;
import org.b3log.latke.http.RequestContext;
import org.b3log.latke.http.renderer.JsonRenderer;
import org.b3log.latke.ioc.Inject;
import org.b3log.latke.ioc.Singleton;
import org.json.JSONObject;

import java.util.Map;

@Singleton
public class UserProcessor {

    @Inject
    private UserService userService;

    public void showRegister(final RequestContext context) {
        context.setRenderer(new GuitarRenderer("register.ftl"));
    }

    public void register(final RequestContext context) { // 函数式路由，在 Server 中配置

        context.setRenderer(new GuitarRenderer("register.ftl"));
        final Map<String, Object> dataModel = context.getRenderer().getRenderDataModel();

        final Request request = context.getRequest();
        final String name = request.getParameter("name");
        if (StringUtils.isNotBlank(name)) {
            dataModel.put("name", name);

            userService.saveUser(name, 3);
        }
    }

    public void getUser(final RequestContext context) {
        final Request request = context.getRequest();
        final String name = request.getParameter("name");

        JSONObject user = userService.getUser(name);

        context.renderJSON(user);
    }

    public void paraPathVar(final RequestContext context) {
        final String paraVar = context.param("paraVar");
        final String pathVar = context.pathVar("pathVar");
        context.renderJSON(new JSONObject().put("paraVar", paraVar).put("pathVar", pathVar));
    }

    public void getuser(final RequestContext context) {

    }

}
