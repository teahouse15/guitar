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

        try {
            Latkes.setScanPath(Server.class.getPackage().getName());
            Latkes.init();
        } catch (final Exception e) {
            LOGGER.log(Level.ERROR, "Latke init failed, please configure latke.props or run with args, visit https://ld246.com/article/1492881378588 for more details");

            System.exit(-1);
        }
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
