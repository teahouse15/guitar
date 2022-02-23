package latke.processor;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.b3log.latke.http.RequestContext;
import org.b3log.latke.ioc.Singleton;
import org.b3log.latke.util.Requests;

import java.util.Map;


// 请求处理
@Singleton
public class HelloProcessor {
    private static final Logger LOGGER = LogManager.getLogger(HelloProcessor.class);

    public void index(final RequestContext context) {
        context.setRenderer(new GuitarRenderer("index.ftl"));

        final Map<String, Object> dataModel = context.getRenderer().getRenderDataModel();
        dataModel.put("greeting", "Hello Latke");
        Requests.log(context.getRequest(), Level.DEBUG, LOGGER);

    }

}
