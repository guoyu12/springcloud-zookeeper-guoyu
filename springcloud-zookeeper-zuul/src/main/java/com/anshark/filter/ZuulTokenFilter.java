package com.anshark.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Author GUOYU
 * @Date 2021/1/19
 * @Desc 网关过滤器
 */
@Component
public class ZuulTokenFilter extends ZuulFilter {
    /**
     * 返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 过滤器的具体逻辑。在该函数中，我们可以实现自定义的过滤逻辑，来确定是否要拦截当前的请求，不对其进行后续的路由，或是在请求路由返回结果之后，
     * 对处理结果做一些加工等。
     */
    @Override
    public Object run() throws ZuulException {
        // 拦截所有的服务接口 ，判断服务接口上是否有传递参数UserToken

        // 获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 获取request
        HttpServletRequest request = currentContext.getRequest();
        // 获取token的时候，从请求头中获取
        String userToken = request.getParameter("token");
        if (StringUtils.isEmpty(userToken)) {
            // 不会继续执行 不会去调用服务接口 网关服务直接响应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("token null");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        return null;
    }

    /**
     * 过滤器类型 pre 表示请求路由之前调用 routing 在路由请求时被调用 post 在routing和error过滤器之后调用 error
     * 处理请求发生错误时调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder：通过int值来定义过滤器的执行顺序，数值越小优先级越高。
     */
    @Override
    public int filterOrder() {
        return 0;
    }
}
