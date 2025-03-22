package com.example.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.laptopshop.domain.Cart;
import com.example.laptopshop.domain.CartDetail;
import com.example.laptopshop.domain.Product;
import com.example.laptopshop.domain.User;
import com.example.laptopshop.service.ProductService;
import com.example.laptopshop.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IteamController {

    private final DaoAuthenticationProvider authProvider;

    private final AuthenticationSuccessHandler CustomerSuccessHandler;

    private final ProductService productService;

    public IteamController(ProductService productService, AuthenticationSuccessHandler CustomerSuccessHandler, DaoAuthenticationProvider authProvider){
        this.productService = productService;
        this.CustomerSuccessHandler = CustomerSuccessHandler;
        this.authProvider = authProvider;

    }
    
    @GetMapping("/product/{id}")
    public String getDetail(Model model, @PathVariable long id) {
        Optional<Product> product = this.productService.getProductById(id);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }
    
    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(@PathVariable long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        long productId = id;

        String email = (String) session.getAttribute("email");
        this.productService.handleProductToCart(email, productId, session);

        return "redirect:/";
    }
    
    @GetMapping("/cart")
    public String cartDetailPage(Model model, HttpServletRequest request) {

        User currentUser = new User();
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        currentUser.setId(id);

        Cart cart = this.productService.fetchByUser(currentUser);

        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

        double totalPrice = 0;

        for (CartDetail cd : cartDetails){
            totalPrice += cd.getPrice() * cd.getQuantity();
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);

        model.addAttribute("cart", cart);
        return "client/cart/CartHome";
    }

    @PostMapping("/delete-cart-product/{id}")
    public String deleteCartProduct(@PathVariable long id, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        long productId = id;

        this.productService.deleteCartById(productId, session);
        return "redirect:/cart";
    }

    @PostMapping("/confirm-checkout")
    public String checkOut(Model model, Cart cart){
        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();
        this.productService.handleCheckOut(cartDetails);
        return "redirect:client/cart/checkout";
    }

    @GetMapping("/checkout")
    public String getCheckOutPage(Model model, HttpServletRequest request){ 
        User currentUser = new User();
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        currentUser.setId(id);

        Cart cart = this.productService.fetchByUser(currentUser);

        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

        double totalPrice = 0;

        for (CartDetail cd : cartDetails){
            totalPrice += cd.getPrice() * cd.getQuantity();
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);

        model.addAttribute("cart", cart);
        return "client/cart/checkOut";
    }



    @PostMapping("/place-order")
    public String placeOrder(HttpServletRequest request,
    @RequestParam("receiverName") String receiverName,
    @RequestParam("receiverAddress") String receiverAddress,
    @RequestParam("receiverPhone") String receiverPhone
    ) {
        HttpSession session = request.getSession(false);
        return "redirect:/";
    }
    
}
