package com.example.laptopshop.service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import com.example.laptopshop.controller.admin.DashboardController;
import com.example.laptopshop.domain.Cart;
import com.example.laptopshop.domain.CartDetail;
import com.example.laptopshop.domain.Product;
import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.CartDetailRepository;
import com.example.laptopshop.repository.CartRepository;
import com.example.laptopshop.repository.ProductRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class ProductService {

    private final SecurityFilterChain filterChain;

    private final DashboardController dashboardController;

    private final DaoAuthenticationProvider authProvider;

    private final AuthenticationSuccessHandler CustomerSuccessHandler;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository, CartDetailRepository cartDetailRepository, UserService userService, AuthenticationSuccessHandler CustomerSuccessHandler, DaoAuthenticationProvider authProvider, DashboardController dashboardController, SecurityFilterChain filterChain) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
        this.CustomerSuccessHandler = CustomerSuccessHandler;
        this.authProvider = authProvider;
        this.dashboardController = dashboardController;
        this.filterChain = filterChain;
    }
    
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public Product getProductSave(Product product){
        Product eric = this.productRepository.save(product);
        System.out.println(eric);
        return eric;
    }

    public Optional<Product> getProductById(long id){
        return this.productRepository.findById(id);
    }

    public void deleteProductById(long id){
        this.productRepository.deleteById(id);
    }

    public void handleProductToCart(String email, long productId, HttpSession session){

        User user = this.userService.getUserByEmail(email);
        // check xem user đã có giỏ hàng chưa ? nếu chưa -> tạo mới
        if(user != null){
            
            Cart cart = this.cartRepository.findByUser(user);

            if (cart == null) {
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(1);

                cart = this.cartRepository.save(otherCart);
            }


            // save vào cart_detail
            // tìm product by id

            Optional<Product> productOptional = this.productRepository.findById(productId);
            if (productOptional.isPresent()) {
                Product rProduct = productOptional.get();

                // check xem sản phẩm này đã từng được thêm giỏ hàng trước đó hay chưa

                CartDetail olDetail = this.cartDetailRepository.findByCartAndProduct(cart, rProduct);

                if (olDetail == null) {
                    CartDetail cartDetail = new CartDetail();
                    cartDetail.setCart(cart);
                    cartDetail.setProduct(rProduct);
                    cartDetail.setPrice(rProduct.getPrice());
                    cartDetail.setQuantity(1);
                    this.cartDetailRepository.save(cartDetail);

                    // update cart (sum)
                    int s = cart.getSum() + 1;
                    cart.setSum(s);
                    this.cartRepository.save(cart);
                    session.setAttribute("sum", s);
                } else {
                    olDetail.setQuantity(olDetail.getQuantity() + 1);
                    this.cartDetailRepository.save(olDetail);
                }
            }

        }

    }

    public Cart fetchByUser(User user){
        return this.cartRepository.findByUser(user);
    }

    public void deleteCartById(long productId, HttpSession session){
        Optional<CartDetail> cartDetail = this.cartDetailRepository.findById(productId);

        if (cartDetail.isPresent()) {
            Cart cart = cartDetail.get().getCart();
            this.cartDetailRepository.deleteById(productId);
            int sum = cart.getSum() -1;
            if (sum > 1) {
                cart.setSum(sum);
                this.cartRepository.save(cart);
                session.setAttribute("sum", sum);
            } else {
                this.cartRepository.delete(cart);
            }
        }
    }

    public void handleCheckOut(List<CartDetail> cartDetails){
        for (CartDetail cartDetail : cartDetails){
            Optional<CartDetail> cdOptional = this.cartDetailRepository.findById(cartDetail.getId());
            if (cdOptional.isPresent()){
                CartDetail curenCartDetail = cdOptional.get();
                curenCartDetail.setQuantity(cartDetail.getQuantity());
                this.cartDetailRepository.save(curenCartDetail);
            }
        }
    }
}
