package betahouse.core.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by Yxm on 2017/11/2.
 */
@Controller
@RequestMapping("/resources")
public class BaseResources {
    public static final String RESOURCES = "Resources";

    private static final Logger log = LoggerFactory.getLogger(BaseResources.class);

    public static final String ROOT = "File"+ File.separator+RESOURCES+ File.separator+"Img";

    private final ResourceLoader resourceLoader;

    @Autowired
    public BaseResources(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    //调用资源方法关键 匹配路径像 localhost:8080/test.jpg
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        log.error("hello");
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}