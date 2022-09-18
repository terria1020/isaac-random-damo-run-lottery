package resourcemapper;

import java.net.URL;
import java.util.Arrays;

public class ResourceMapper {
    private String[] names;
    private int size;

    public ResourceMapper(String[] names, int size) {
        this.names = names;
        this.size = size;
    }

    public URL getUrl(int index) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(names[index]);
        return url;
    }

    public URL[] getAllUrl() {
        URL[] urls = new URL[size];
        for (int i = 0; i < size; i++) {
            urls[i] = getUrl(i);
        }

        return urls;
    }
}
