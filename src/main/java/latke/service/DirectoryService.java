package latke.service;

import latke.repository.DirectoryRepository;
import latke.utils.DirectoryUtil;
import org.b3log.latke.ioc.Inject;
import org.b3log.latke.repository.FilterOperator;
import org.b3log.latke.repository.PropertyFilter;
import org.b3log.latke.repository.Query;
import org.b3log.latke.repository.RepositoryException;
import org.b3log.latke.repository.annotation.Transactional;
import org.b3log.latke.service.annotation.Service;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

@Service
public class DirectoryService {

    @Inject
    private DirectoryRepository directoryRepository;




    @Transactional
    public void initDirectoryStructure(String serverDriverPath) {
        clearDirectoryRecords();

        final List<JSONObject> dirList = DirectoryUtil.listDir(new File(serverDriverPath), new File(serverDriverPath));
        try {
            for (JSONObject j : dirList) {
                directoryRepository.add(j);
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除目录结构表中所有数据
     */
    @Transactional
    private void clearDirectoryRecords() {
        try {
            directoryRepository.remove(new Query());
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }
}
