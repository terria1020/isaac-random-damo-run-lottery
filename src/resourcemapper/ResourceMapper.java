package resourcemapper;

import java.net.URL;
import java.util.Arrays;

public class ResourceMapper {
    private String[] names;
    private int size;

    public static URL getUrl(String name) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(name);
        return url;
    }

    public static URL[] getAllUrl(String[] names) {
        int size = names.length;
        URL[] urls = new URL[size];
        for (int i = 0; i < size; i++) {
            urls[i] = Thread.currentThread().getContextClassLoader().getResource(names[i]);
        }

        return urls;
    }
}
