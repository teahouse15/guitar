package latke.service;

import latke.repository.OptionRepository;
import org.b3log.latke.ioc.Inject;
import org.b3log.latke.repository.*;
import org.b3log.latke.repository.annotation.Transactional;
import org.b3log.latke.service.annotation.Service;
import org.json.JSONObject;

@Service
public class OptionService {

    @Inject
    private OptionRepository optionRepository;

    /**
     * 查询程序主目录所在位置
     * @return
     */
    public JSONObject queryServerDriverPath() {
        try {
            return optionRepository.queryOption("serverDriverPath");
        } catch (RepositoryException e) {
            e.printStackTrace();
            return null;
        }
    }



    public JSONObject queryOption(String optionName) {
        try {
            return optionRepository.queryOption(optionName);
        } catch (RepositoryException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void setServerDriverPath(String serverDriverPath) {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("optionName", "serverDriverPath");
        jsonObject.put("optionValue", serverDriverPath);

        try {
            JSONObject driverPathInfo = optionRepository.getFirst(new Query().setFilter(new PropertyFilter("optionName", FilterOperator.EQUAL, "serverDriverPath")));
            System.out.println(driverPathInfo);

            // 没有配置信息
            if (null == driverPathInfo) {
                optionRepository.add(jsonObject);
            } else {
                optionRepository.update(driverPathInfo.getString("oId"), driverPathInfo);
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }
}
