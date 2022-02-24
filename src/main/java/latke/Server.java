package latke;

import latke.processor.Router;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.b3log.latke.Latkes;
import org.b3log.latke.http.BaseServer;
import org.b3log.latke.repository.jdbc.util.JdbcRepositories;

public class Server extends BaseServer {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Server.class);

    /**
     * Guitar version.
     */
    private static final String VERSION = "0.0.1";

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "test...");
        Latkes.setScanPath(Server.class.getPackage().getName());
        Latkes.init();

        // 初始化数据库表
        JdbcRepositories.initAllTables();

        final Server server = new Server();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.shutdown();
            Latkes.shutdown();
        }));

        // 读取sharing_option表中 配置信息




        Router router = new Router();
        router.requestMapping();


        LOGGER.log(Level.INFO, "Guitar [" + VERSION + "] Running...");
        server.start(8080);
    }
}
