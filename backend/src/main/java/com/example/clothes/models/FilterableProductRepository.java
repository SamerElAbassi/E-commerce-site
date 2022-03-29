package com.example.clothes.models;

import com.example.clothes.enums.Sizes;
import com.example.clothes.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
@RequiredArgsConstructor
public class FilterableProductRepository {
    private final ProductRepository productRepository;

    public List<Product> getQueryResult(List<FilterQuery> filters) {
        if (filters.size() > 0) {
            return productRepository.findAll(getSpecificationFromFilters(filters));
        } else {
            return productRepository.findAll();
        }
    }

    private Specification<Product> getSpecificationFromFilters(List<FilterQuery> filter) {
        Specification<Product> specification = where(createSpecification(filter.remove(0)));
        for (FilterQuery input : filter) {
            specification = specification.and(createSpecification(input));
        }
        return specification;
    }

    private Specification<Product> createSpecification(FilterQuery input) {
        switch (input.getOperator()) {
            case EQUALS:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(input.getField()),
                                castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
            case NOT_EQ:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.notEqual(root.get(input.getField()),
                                castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
            case GREATER_THAN:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.gt(root.get(input.getField()),
                                (Number) castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
            case LESS_THAN:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.lt(root.get(input.getField()),
                                (Number) castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
            case LIKE:
                return (root, query, criteriaBuilder) ->
                        criteriaBuilder.like(root.get(input.getField()), "%" + input.getValue() + "%");
            case IN:

                return (root, query, criteriaBuilder) ->

                        criteriaBuilder.lower(root.get(input.getField())).in(
                                castToRequiredType(root.get(input.getField()).getJavaType(), input.getValues())
                        );
            case BETWEEN:
                return (root, query, criteriaBuilder) -> {
                    double[] values = input.getValues().stream().mapToDouble(Double::parseDouble).toArray();
                    return criteriaBuilder.between(root.get(input.getField()), values[0], values[1]);
                };

            default:
                throw new RuntimeException("Operation not supported yet");
        }
    }

    private Object castToRequiredType(Class fieldType, String value) {

        if (fieldType.isAssignableFrom(Double.class)) {

            return Double.valueOf(value);
        }
        else if (fieldType.isAssignableFrom(Integer.class)) {
            return Integer.valueOf(value);
        }
        else if (EnumUtils.isValidEnum(Sizes.class,value.toUpperCase()))
       {

            return EnumUtils.getEnum(Sizes.class,value.toUpperCase());
        }
         else if (fieldType.isAssignableFrom(String.class)) {

            return String.valueOf(value);
        }
         System.out.println("Not assigable");
        return null;
    }

    private Object castToRequiredType(Class fieldType, List<String> value) {
        List<Object> lists = new ArrayList<>();
        for (String s : value) {
            lists.add(castToRequiredType(fieldType, s));
        }
        return lists;
    }
}
