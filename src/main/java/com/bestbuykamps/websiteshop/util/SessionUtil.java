package com.bestbuykamps.websiteshop.util;
import com.bestbuykamps.websiteshop.business_service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class SessionUtil {
    private final CartService cartService;
    private static final Logger logger = LoggerFactory.getLogger(SessionUtil.class);

    public SessionUtil(CartService cartService) {
        this.cartService = cartService;
    }

    public String checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Do not create a new session if it doesn't exist
        if (session != null && session.equals("Order Placed")) {
            String sessionId = session.getId();
            logger.info("Session ID existed: {}", sessionId);
            return sessionId;
        } else {
            session = request.getSession();
            String sessionId = session.getId();
            cartService.createCart(sessionId);
            logger.info("Created new ID: {}", sessionId);
            return sessionId;
        }
    }
}