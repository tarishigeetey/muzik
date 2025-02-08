package tarishi.project.muzik.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class HttpSessionInitializer extends AbstractHttpSessionApplicationInitializer{
    public HttpSessionInitializer() {
        super(RedisHttpSessionConfig.class);
    }
}
