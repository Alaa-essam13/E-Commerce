package com.example.ecommerce.ecommerce.mapper;


import com.example.ecommerce.ecommerce.model.dto.CategoryDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductCreateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.RegisterRequestDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import com.example.ecommerce.ecommerce.model.entity.Product;
import com.example.ecommerce.ecommerce.model.entity.User;
import com.example.ecommerce.ecommerce.model.vto.CategoriesVTO;
import com.example.ecommerce.ecommerce.model.vto.CategoryVTO;
import com.example.ecommerce.ecommerce.model.vto.ProductVTO;
import com.example.ecommerce.ecommerce.model.vto.UserVto;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

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

    List<CategoryVTO> toCategoryVTOList(List<Category> categories);


    default CategoriesVTO toCategoriesVTO(List<Category> categories) {
        return new CategoriesVTO(toCategoryVTOList(categories));
    }

}
