import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Test {

    //JSONObject

    public static void main(String[] args) {
        String path = "D:/Document";

        List<JSONObject> dir = listDir(new File(path));
        for (JSONObject jsonObject:dir) {
            System.out.println(jsonObject.toString());
        }

    }


    public static List<JSONObject> listDir(File dir) {
        List<JSONObject> jsonObjectList = new ArrayList<JSONObject>();


        File files[] = dir.listFiles();

        for (File f:files) {
            if (f.isDirectory()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", f.getName());
                jsonObject.put("path", f.getPath());
                jsonObject.put("absolutePath", f.getAbsolutePath());
                jsonObjectList.add(jsonObject);
                jsonObjectList.addAll(listDir(f));
            }
        }
        return new ArrayList<JSONObject>(new LinkedHashSet<>(jsonObjectList));
    }
}
