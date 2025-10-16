package com.ncu.cartservice.controller;

import com.ncu.cartservice.model.CartItem;
import com.ncu.cartservice.model.CartModel;
import com.ncu.cartservice.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public CartModel getCart(@PathVariable String userId) {
        return cartService.getCart(userId);
    }

    @PostMapping("/{userId}/add")
    public CartModel addItem(@PathVariable String userId, @RequestBody CartItem item) {
        return cartService.addItem(userId, item);
    }

    @DeleteMapping("/{userId}/remove/{itemId}")
    public CartModel removeItem(@PathVariable String userId, @PathVariable Long itemId) {
        return cartService.removeItem(userId, itemId);
    }

    @DeleteMapping("/{userId}/clear")
    public void clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
    }
}
