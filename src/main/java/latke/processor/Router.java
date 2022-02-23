package latke.processor;

import org.b3log.latke.http.Dispatcher;
import org.b3log.latke.ioc.BeanManager;

public class Router {

    public static void requestMapping() {
        // 注册处理器
        final BeanManager beanManager = BeanManager.getInstance();
        final HelloProcessor helloProcessor = beanManager.getReference(HelloProcessor.class);
        final UserProcessor userProcessor = beanManager.getReference(UserProcessor.class);

        // 配置路由
        final Dispatcher.RouterGroup routeGroup = Dispatcher.group();
//        routeGroup.get("/", helloProcessor::index).
//                get("/register", registerProcessor::showRegister).
//                post("/register", registerProcessor::register).
//                get("/var/{pathVar}", registerProcessor::paraPathVar).
//                router().get().post().uri("/greeting").handler(helloProcessor::greeting);
        routeGroup.get("/", helloProcessor::index).
                post("/register", userProcessor::register).
                get("/getuser", userProcessor::getUser);

        Dispatcher.mapping();
    }
}
