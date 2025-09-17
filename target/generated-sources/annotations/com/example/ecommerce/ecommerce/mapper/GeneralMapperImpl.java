package com.example.ecommerce.ecommerce.mapper;

import com.example.ecommerce.ecommerce.model.dto.CategoryDTO;
import com.example.ecommerce.ecommerce.model.dto.OrderDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductCreateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.RegisterRequestDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import com.example.ecommerce.ecommerce.model.entity.Order;
import com.example.ecommerce.ecommerce.model.entity.OrderItem;
import com.example.ecommerce.ecommerce.model.entity.Product;
import com.example.ecommerce.ecommerce.model.entity.User;
import com.example.ecommerce.ecommerce.model.vto.CategoriesVTO;
import com.example.ecommerce.ecommerce.model.vto.CategoryVTO;
import com.example.ecommerce.ecommerce.model.vto.OrderItemVTO;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import com.example.ecommerce.ecommerce.model.vto.ProductVTO;
import com.example.ecommerce.ecommerce.model.vto.UserVto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-17T06:30:23+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class GeneralMapperImpl implements GeneralMapper {

    @Override
    public User toUser(RegisterRequestDTO registerRequestDTO) {
        if ( registerRequestDTO == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( registerRequestDTO.getFirstName() );
        user.setLastName( registerRequestDTO.getLastName() );
        user.setEmail( registerRequestDTO.getEmail() );
        user.setMobileNumber( registerRequestDTO.getMobileNumber() );
        user.setPassword( registerRequestDTO.getPassword() );

        return user;
    }

    @Override
    public UserVto toUserVto(User user) {
        if ( user == null ) {
            return null;
        }

        UserVto userVto = new UserVto();

        userVto.setId( user.getId() );
        userVto.setEmail( user.getEmail() );
        userVto.setFirstName( user.getFirstName() );
        userVto.setLastName( user.getLastName() );
        userVto.setMobileNumber( user.getMobileNumber() );

        return userVto;
    }

    @Override
    public Product toProduct(ProductCreateRequestDTO product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setName( product.getName() );
        product1.setDescription( product.getDescription() );
        product1.setPrice( product.getPrice() );
        product1.setQuantity( product.getQuantity() );

        return product1;
    }

    @Override
    public ProductVTO toProductVTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductVTO productVTO = new ProductVTO();

        productVTO.setId( product.getId() );
        productVTO.setName( product.getName() );
        productVTO.setDescription( product.getDescription() );
        productVTO.setPrice( product.getPrice() );

        return productVTO;
    }

    @Override
    public Product toProduct(ProductUpdateRequestDTO productUpdateRequestDTO) {
        if ( productUpdateRequestDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productUpdateRequestDTO.getId() );
        product.setName( productUpdateRequestDTO.getName() );
        product.setDescription( productUpdateRequestDTO.getDescription() );
        product.setPrice( productUpdateRequestDTO.getPrice() );

        return product;
    }

    @Override
    public Category toCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( categoryDTO.getName() );

        return category;
    }

    @Override
    public CategoryVTO toCategoryVTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryVTO categoryVTO = new CategoryVTO();

        categoryVTO.setId( category.getId() );
        categoryVTO.setName( category.getName() );
        categoryVTO.setCreatedAt( category.getCreatedAt() );
        categoryVTO.setUpdatedAt( category.getUpdatedAt() );

        return categoryVTO;
    }

    @Override
    public List<CategoryVTO> toCategoryVTOList(List<Category> category) {
        if ( category == null ) {
            return null;
        }

        List<CategoryVTO> list = new ArrayList<CategoryVTO>( category.size() );
        for ( Category category1 : category ) {
            list.add( toCategoryVTO( category1 ) );
        }

        return list;
    }

    @Override
    public CategoriesVTO toCategoriesVTO(Integer count, List<Category> categories) {
        if ( count == null && categories == null ) {
            return null;
        }

        CategoriesVTO categoriesVTO = new CategoriesVTO();

        categoriesVTO.setCount( count );
        categoriesVTO.setCategories( toCategoryVTOList( categories ) );

        return categoriesVTO;
    }

    @Override
    public Order toOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDTO.getId() );
        order.setOrderDate( orderDTO.getOrderDate() );
        order.setStatus( orderDTO.getStatus() );
        order.setTotalAmount( orderDTO.getTotalAmount() );
        order.setCreatedAt( orderDTO.getCreatedAt() );
        order.setUpdatedAt( orderDTO.getUpdatedAt() );

        return order;
    }

    @Override
    public List<OrderItemVTO> toOrderItemVTO(List<OrderItem> orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        List<OrderItemVTO> list = new ArrayList<OrderItemVTO>( orderItem.size() );
        for ( OrderItem orderItem1 : orderItem ) {
            list.add( orderItemToOrderItemVTO( orderItem1 ) );
        }

        return list;
    }

    @Override
    public OrderVTO toOrderVTO(Order order, List<OrderItem> orderItems) {
        if ( order == null && orderItems == null ) {
            return null;
        }

        OrderVTO orderVTO = new OrderVTO();

        if ( order != null ) {
            orderVTO.setId( order.getId() );
            orderVTO.setStatus( order.getStatus() );
        }
        orderVTO.setOrderItems( toOrderItemVTO( orderItems ) );

        return orderVTO;
    }

    protected OrderItemVTO orderItemToOrderItemVTO(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemVTO orderItemVTO = new OrderItemVTO();

        if ( orderItem.getQuantity() != null ) {
            orderItemVTO.setQuantity( orderItem.getQuantity() );
        }

        return orderItemVTO;
    }
}
