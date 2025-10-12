package com.example.ecommerce.ecommerce.model.vto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleVTO {
    private Integer id;
    private String titleEn;
    private String titleAr;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
