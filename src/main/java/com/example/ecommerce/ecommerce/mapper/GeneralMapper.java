package com.example.ecommerce.ecommerce.mapper;


import com.example.ecommerce.ecommerce.model.dto.*;
import com.example.ecommerce.ecommerce.model.entity.*;
import com.example.ecommerce.ecommerce.model.vto.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface GeneralMapper {

    User toUser(RegisterRequestDTO registerRequestDTO);

    UserVto toUserVto(User user);

    @Mapping(target = "category",source = "category")
    @Mapping(target = "name",source = "product.name")
    Product toProduct(ProductCreateRequestDTO product,Category category);

    ProductVTO toProductVTO(Product product);

    PagedProductResponseVTO toPagedProductResponseVTO(List<Product> content,Long totalElements);

    Product toProduct(ProductUpdateRequestDTO productUpdateRequestDTO);

    Category toCategory(CategoryDTO categoryDTO);

    CategoryVTO toCategoryVTO(Category category);

    List<CategoryVTO> toCategoryVTOList(List<Category> category);


    @Mapping(source = "categories", target = "categories")
    CategoriesVTO toCategoriesVTO(Integer count,List<Category> categories);


    Order toOrder(OrderDTO orderDTO);

    List<OrderItemVTO> toOrderItemVTO(List<OrderItem> orderItem);

    @Mapping(target = "orderItems", source = "orderItems")
    OrderVTO toOrderVTO(Order order, List<OrderItem> orderItems);



    OrderItem toOrderItem(OrderItemUpdateRequestDTO orderItemUpdateRequestDTO);


    @Mapping(target = "productId",source = "cartItem.product.id")
    @Mapping(target = "name",source = "cartItem.product.name")
    @Mapping(target = "price",source = "cartItem.product.price")
    @Mapping(target = "quantity",source = "cartItem.quantity")
    @Mapping(target = "totalPrice", expression = "java(cartItem.getProduct().getPrice() * cartItem.getQuantity())")
    CartItemVTO toCartItemVTO(CartItem cartItem);

    List<CartItemVTO> toCartItemsVTO(List<CartItem> cartItems);



}
