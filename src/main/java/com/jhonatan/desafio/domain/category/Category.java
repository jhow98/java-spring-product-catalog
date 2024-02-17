package com.jhonatan.desafio.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;

    public Category(CategoryDTO categoryDTO){
        this.title = categoryDTO.title();
        this.description = categoryDTO.description();
        this.ownerId = categoryDTO.ownerId();
    }

    @SneakyThrows
    @Override
    public String toString(){
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("description", description);
        json.put("ownerId", ownerId);
        json.put("id", id);
        json.put("type", "category");

        return json.toString();
    }
}
