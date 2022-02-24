package latke.processor;

import org.b3log.latke.http.Dispatcher;
import org.b3log.latke.ioc.BeanManager;
import org.b3log.latke.ioc.Inject;

public class Router {

    public void requestMapping() {
        // 注册处理器
        final BeanManager beanManager = BeanManager.getInstance();
        final UserProcessor userProcessor = beanManager.getReference(UserProcessor.class);
        final IndexProceesor indexProceesor = beanManager.getReference(IndexProceesor.class);

        // 配置路由
        final Dispatcher.RouterGroup routeGroup = Dispatcher.group();
//        routeGroup.get("/", helloProcessor::index).
//
//                get("/register", registerProcessor::showRegister).
//                // asf1
//                post("/register", registerProcessor::register).
//                get("/var/{pathVar}", registerProcessor::paraPathVar).
//                router().get().post().uri("/greeting").handler(helloProcessor::greeting);
        // Index处理 第一次访问作为匿名用户
        routeGroup.get("/", indexProceesor::index);

        Dispatcher.mapping();
    }
}
