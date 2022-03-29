package com.example.clothes.models;

import com.example.clothes.enums.QueryOperator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class FilterQuery {
    private String field;
    private QueryOperator operator;
    private String value;
    private List<String> values; //Used in case of IN operator
    public static List <String> splitValues(String params,String separator){
        return List.of(params.toLowerCase().split(separator));
    }
    @Override
    public String toString() {
        return "FilterQuery{" +
                "field='" + field + '\'' +
                ", operator=" + operator +
                ", value='" + value + '\'' +
                ", values=" + values +
                '}';
    }
}
