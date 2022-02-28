package latke.utils;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class DirectoryUtil {

    public static List<JSONObject> listDir(File dir, File rootPath) {
        List<JSONObject> dirList = new ArrayList<JSONObject>();
        for (File f:dir.listFiles()) {
            if (f.isDirectory()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("directoryName", f.getName());
                jsonObject.put("directoryAbsolutePath", f.getAbsolutePath());
                jsonObject.put("directoryRootPath", rootPath.getAbsolutePath());
                dirList.add(jsonObject);
                dirList.addAll(listDir(f, rootPath));
            }
        }
        return new ArrayList<JSONObject>(new LinkedHashSet<>(dirList));
    }
}
