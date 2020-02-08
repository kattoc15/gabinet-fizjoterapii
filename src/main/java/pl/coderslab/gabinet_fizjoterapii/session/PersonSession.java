package pl.coderslab.gabinet_fizjoterapii.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.gabinet_fizjoterapii.dto.Reserve;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonSession {

    private String email;
    private Reserve reserve;

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserveAsk(Reserve reserve) {
        this.reserve = reserve;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
