package com.example.gxy.model;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author GXY
 * @Package com.example.gxy.model
 * @date 2020/12/23 0:09
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class ModelImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                "com.example.gxy.model.Animal",
                "com.example.gxy.model.Car"
        };
    }
}
