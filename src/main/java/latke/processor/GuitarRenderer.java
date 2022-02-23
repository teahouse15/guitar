package latke.processor;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.b3log.latke.http.RequestContext;
import org.b3log.latke.http.renderer.AbstractFreeMarkerRenderer;

import java.util.TimeZone;

public final class GuitarRenderer extends AbstractFreeMarkerRenderer {

    private static final Logger LOGGER = LogManager.getLogger(GuitarRenderer.class);

    /**
     * FreeMarker template configuration.
     */
    public static final Configuration SKIN ;

    static {
        SKIN = new Configuration(Configuration.VERSION_2_3_29);
        SKIN.setDefaultEncoding("UTF-8");
        SKIN.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        SKIN.setClassForTemplateLoading(GuitarRenderer.class, "/template");
        SKIN.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        SKIN.setLogTemplateExceptions(false);
    }

    public GuitarRenderer(final String templateName) {setTemplateName(templateName);}

    protected void beforeRender(RequestContext requestContext) {
    }

    protected void afterRender(RequestContext requestContext) {
    }


    protected Template getTemplate() {
        try {
            return SKIN.getTemplate(getTemplateName());
        } catch (final Exception e) {
            LOGGER.log(Level.ERROR, "Get template [" + getTemplateName() + "] failed", e);
            return null;
        }
    }
}
