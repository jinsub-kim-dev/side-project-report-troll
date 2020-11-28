package gg.troll.report.base.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class RiotApiKetMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        final String TARGET_PARAMETER_NAME = "riotapikey";
        return parameter.getParameterName().toLowerCase().equals(TARGET_PARAMETER_NAME) &&
                parameter.getParameterType().equals(String.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String riotApiKey = webRequest.getHeader("Riot-API-Key");
        return riotApiKey == null ? "" : riotApiKey;
    }
}
