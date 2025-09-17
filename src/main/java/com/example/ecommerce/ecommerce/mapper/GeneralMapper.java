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

    Product toProduct(ProductCreateRequestDTO product);

    ProductVTO toProductVTO(Product product);

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


    OrderItem toOrderItem(OrderItemDTO orderItemDTO,Product product);

    OrderItem toOrderItem(OrderItemUpdateRequestDTO orderItemUpdateRequestDTO);

}
