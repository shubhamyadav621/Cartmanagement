package com.ncu.cartservice.service;

import com.ncu.cartservice.model.CartItem;
import com.ncu.cartservice.model.CartModel;
import com.ncu.cartservice.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Fetch cart by userId or create new
    public CartModel getCart(String userId) {
        return cartRepository.findByUserId(userId)
                .orElse(new CartModel(userId, new ArrayList<>()));
    }

    // Add an item to the cart
    public CartModel addItem(String userId, CartItem item) {
        CartModel cart = getCart(userId);
        List<CartItem> items = cart.getItems();
        items.add(item);
        cart.setItems(items);
        return cartRepository.save(cart);
    }

    // Remove an item by ID
    public CartModel removeItem(String userId, Long itemId) {
        CartModel cart = getCart(userId);
        List<CartItem> items = cart.getItems();
        items.removeIf(i -> i.getId().equals(itemId));
        cart.setItems(items);
        return cartRepository.save(cart);
    }

    // Clear all items in the cart
    public void clearCart(String userId) {
        CartModel cart = getCart(userId);
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
