import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

@Component
public class ResponseHeaderFilter implements WebFilter {

    @Override
    public reactor.core.publisher.Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        serverWebExchange.getResponse()
                .getHeaders().add("X-Broker-API-Version", "2.14");
        return webFilterChain.filter(serverWebExchange);
    }
}